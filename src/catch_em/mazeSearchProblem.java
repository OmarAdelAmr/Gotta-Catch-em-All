package catch_em;

import java.util.ArrayList;

import elements.HeuristicFun;
import elements.Operator;
import elements.SearchProblem;
import elements.State;
import maze.cell;

public class mazeSearchProblem extends SearchProblem
{
	private cell endPoint;

	public mazeSearchProblem(ArrayList<Operator> operators, State initialState, ArrayList<State> stateSpace,
			cell endPoint,HeuristicFun hueristicFun)
	{
		super(operators, initialState, stateSpace,hueristicFun);
		this.endPoint = endPoint;
	}

	public boolean goalTest(State state)
	{
		if (state instanceof mazeState)
		{
			System.out.println("goal test: "+ state);
			mazeState tempState = (mazeState) state;
			if (tempState.getPokemonsLeft() == 0 && tempState.getStepsLeft() == 0
					&& tempState.getCurrentPosition()[0] == endPoint.getCoordinates()[0]
							&& tempState.getCurrentPosition()[1] == endPoint.getCoordinates()[1])
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
