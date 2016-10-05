package catch_em;

import java.util.ArrayList;

import elements.Operator;
import elements.State;
import maze.MainEngine;

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
		operators.add(new mazeOperator("forward", 1));
		operators.add(new mazeOperator("rotate left", 1));
		operators.add(new mazeOperator("rotate right", 1));

		search_problem = new mazeSearchProblem(operators, initState, stateSpace);

	}

	public static void main(String[] args)
	{
		new catchEmAll();
	}

}
