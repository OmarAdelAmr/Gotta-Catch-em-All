package catch_em;

import java.util.ArrayList;

import elements.Operator;
import elements.State;
import maze.MainEngine;
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
				maze_engine.getPlayer().getPosition(), maze_engine.getPlayer().getDirection(), maze_engine.getPokemonsState());

		ArrayList<State> stateSpace = new ArrayList<State>();

		ArrayList<Operator> operators = new ArrayList<Operator>();
		operators.add(new MoveForwardOperator(1, maze_engine));
		operators.add(new MoveLeftOperator(2, maze_engine));
		operators.add(new MoveRightOperator(2, maze_engine));
		operators.add(new MoveBackwardOperator(3, maze_engine));
		cell endPoint = maze_engine.getEndPoint();

		search_problem = new mazeSearchProblem(operators, initState, stateSpace, endPoint,null); //TODO hueristic function

	}

	public static void main(String[] args)
	{
		new catchEmAll();
	}

}
