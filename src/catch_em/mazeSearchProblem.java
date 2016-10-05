package catch_em;

import java.util.ArrayList;

import elements.Operator;
import elements.SearchProblem;
import elements.State;
import maze.cell;

public class mazeSearchProblem extends SearchProblem
{

	public mazeSearchProblem(ArrayList<Operator> operators, State initialState, ArrayList<State> stateSpace)
	{
		super(operators, initialState, stateSpace);
	}

	public boolean goalTest(State state, cell endPoint)
	{
		if (state instanceof mazeState)
		{
			mazeState tempState = (mazeState) state;
			// TODO
			if (tempState.getPokemonsLeft() == 0 && tempState.getStepsLeft() == 0
					&& tempState.getCurrentPosition() == endPoint.getCoordinates())
			{
				return true;
			}
		}
		return false;
	}

	public boolean goalTest(State state)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public int pathCost(State state)
	{
		// TODO use vector in mazeState class to calculate
		return 0;
	}

}
