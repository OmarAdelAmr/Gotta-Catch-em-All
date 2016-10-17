package heuristicFuns;

import catch_em.mazeState;
import elements.HeuristicFun;
import elements.State;
import maze.MainEngine;

public class SecondHeuristicFun extends MazeHeuristicFun implements HeuristicFun
{
	// Depends on the hatching time of the egg
	// If equal to zero refer to h1
	public SecondHeuristicFun(MainEngine engine)
	{
		super(engine);
	}

	@Override
	public int getHeuristicCost(State state)
	{
		mazeState tempState = (mazeState) state;
		int endPointDistance = getEngine().estimateCost(tempState.getCurrentPosition());
		int hatchingTime = getEngine().getStepsNeeded();
		if (endPointDistance < hatchingTime)
		{
			return hatchingTime;
		}
		return endPointDistance;
	}

}
