package catch_em;

import java.util.ArrayList;
import java.util.Iterator;

import elements.GeneralSearch;
import elements.Operator;
import elements.Solution;
import elements.State;
import heuristicFuns.FirstHeuristicFun;
import heuristicFuns.FourthHeuristicFun;
import heuristicFuns.SecondHeuristicFun;
import heuristicFuns.thirdHeuriticFun;
import maze.MainEngine;
import maze.Maze;
import maze.cell;
import mazeOperators.MoveBackwardOperator;
import mazeOperators.MoveForwardOperator;
import mazeOperators.MoveLeftOperator;
import mazeOperators.MoveRightOperator;

public class catchEmAll
{

	private MainEngine maze_engine;
	private mazeSearchProblem search_problem;

	public catchEmAll()
	{
		maze_engine = new MainEngine();
		initSearchProblem();
	}

	public void initSearchProblem()
	{
		State initState = new mazeState(maze_engine.getNumberOfPokemons(), maze_engine.getStepsNeeded(),
				maze_engine.getPlayer().getPosition(), maze_engine.getPlayer().getDirection(),
				maze_engine.getPokimonStates());

		ArrayList<State> stateSpace = new ArrayList<State>();

		ArrayList<Operator> operators = new ArrayList<Operator>();
		operators.add(new MoveForwardOperator(1, maze_engine));
		operators.add(new MoveLeftOperator(2, maze_engine));
		operators.add(new MoveRightOperator(2, maze_engine));
		operators.add(new MoveBackwardOperator(3, maze_engine));
		cell endPoint = maze_engine.getEndPoint();

		search_problem = new mazeSearchProblem(operators, initState, stateSpace, endPoint, null);

	}

	public SearchSolution Search(Maze maze, String strategy, boolean visualize)
	{
		GeneralSearch generalSearch = new GeneralSearch();
		
		Solution solution = null;

		if (strategy.equals("BF"))
		{
			solution = generalSearch.BFS(search_problem);
		} else if (strategy.equals("DF"))
		{
			solution = generalSearch.BFS(search_problem);
		} else if (strategy.equals("ID"))
		{
			solution = generalSearch.IterativeDeepingSearch(search_problem);
		} else if (strategy.equals("UC"))
		{
			solution = generalSearch.UniformCostSearch(search_problem);
		} else
		{
			try
			{
				int heuristicNumber = Integer.parseInt(strategy.substring(2));
				switch (heuristicNumber)
				{
				case 1:
					search_problem.setHeuristicFun(new FirstHeuristicFun(maze_engine));
					break;
				case 2:
					search_problem.setHeuristicFun(new SecondHeuristicFun(maze_engine));
				case 3:
					search_problem.setHeuristicFun(new thirdHeuriticFun(maze_engine));
				case 4:
					search_problem.setHeuristicFun(new FourthHeuristicFun(maze_engine));
				default:
					break;
				}
				if (strategy.startsWith("GR"))
				{
					solution = generalSearch.greedySearch(search_problem);
				} else if (strategy.startsWith("AS"))
				{
					solution = generalSearch.AStarSearch(search_problem);
				}
			} catch (Exception e)
			{
				System.out.println("Wrong Input");
			}

		}

		ArrayList<mazeState> path = new ArrayList<mazeState>();
		Iterator<mazeState> i = path.iterator();
		while(i.hasNext()){
			path.add((mazeState)i.next());
		}
		
		return new SearchSolution(path, solution.getPathCost(), solution.getNodesVisited());
	}

	public static void main(String[] args)
	{
		// new catchEmAll();
		String c = "GR23";
		System.out.println(c.substring(2));
	}

}
