package catch_em;

import java.util.ArrayList;

import elements.Operator;
import elements.SearchProblem;
import elements.State;
import maze.cell;

public class mazeSearchProblem extends SearchProblem
{
	private cell endPoint;

	public mazeSearchProblem(ArrayList<Operator> operators, State initialState, ArrayList<State> stateSpace,
			cell endPoint)
	{
		super(operators, initialState, stateSpace);
		this.endPoint = endPoint;
	}

	public boolean goalTest(State state)
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

	public int pathCost(State state)
	{
		// TODO use vector in mazeState class to calculate
		return 0;
	}

}
