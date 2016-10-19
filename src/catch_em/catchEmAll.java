package catch_em;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

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
		Collections.shuffle(operators, new Random(System.nanoTime()));
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
					break;
				case 3:
					search_problem.setHeuristicFun(new thirdHeuriticFun(maze_engine));
					break;
				case 4:
					search_problem.setHeuristicFun(new FourthHeuristicFun(maze_engine));
					break;
				default:
					System.out.println("Heuristic Not Available");
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
		if(!solution.isSuccess())
			try {
				throw new Exception("failed 3aaaaaaaaa");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		ArrayList<mazeState> path = new ArrayList<mazeState>();
		Iterator<State> i = solution.getPath().iterator();
		while (i.hasNext())
		{
			path.add((mazeState) i.next());
		}

		return new SearchSolution(path, solution.getPathCost(), solution.getNodesVisited());
	}

	public static void main(String[] args)
	{
		String c = "ID";
		catchEmAll x = new catchEmAll();
		System.out.println();
		long startTime = System.currentTimeMillis();
//		System.out.println(x.Search(null, "BF", true));
//		System.out.println("Total execution time: " + (System.currentTimeMillis() - startTime) );
//		startTime = System.currentTimeMillis();
//		System.out.println(x.Search(null, "DF", true));
//		System.out.println("Total execution time: " + (System.currentTimeMillis() - startTime) );
//		startTime = System.currentTimeMillis();
//		System.out.println(x.Search(null, "UC", true));
//		System.out.println("Total execution time: " + (System.currentTimeMillis() - startTime) );
		startTime = System.currentTimeMillis();
		System.out.println(x.Search(null, c, true));
		System.out.println("Total execution time: " + (System.currentTimeMillis() - startTime) );
	}

}
