package catch_em;

import java.util.ArrayList;

import elements.Operator;
import elements.State;
import maze.MainEngine;
import maze.cell;

public class catchEmAll
{

	private MainEngine maze_engine;
	private mazeSearchProblem search_problem;

	public catchEmAll()
	{
		maze_engine = new MainEngine(10, 10, 2);
		initSearchProblem();
	}

	public void initSearchProblem()
	{
		State initState = new mazeState(maze_engine.getNumberOfPokemons(), maze_engine.getStepsNeeded(),
				maze_engine.getPlayer().getPosition(), maze_engine.getPlayer().getDirection());

		ArrayList<State> stateSpace = new ArrayList<State>();

		ArrayList<Operator> operators = new ArrayList<Operator>();
		operators.add(new mazeOperator("step", 1));
		operators.add(new mazeOperator("rotateRight", 1));
		operators.add(new mazeOperator("rotateLeft", 1));
		cell endPoint = maze_engine.getEndPoint();

		search_problem = new mazeSearchProblem(operators, initState, stateSpace, endPoint);

	}

	public static void main(String[] args)
	{
		new catchEmAll();
	}

}
