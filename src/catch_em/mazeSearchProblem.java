package catch_em;

import elements.SearchProblem;
import elements.State;
import maze.cell;

public class mazeSearchProblem extends SearchProblem
{

	public mazeSearchProblem()
	{

	}

	public boolean goalTest(State state, cell endPoint)
	{
		if (state instanceof mazeState)
		{
			mazeState tempState = (mazeState) state;
			// TODO
			if (tempState.getPokemonsLeft().isEmpty() && tempState.getStepsLeft() == 0
					&& tempState.getCurrentPosition() == null)
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
		// TODO
		return 0;
	}

}
