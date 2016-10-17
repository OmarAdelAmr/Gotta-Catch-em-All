package heuristicFuns;

import catch_em.mazeState;
import elements.HeuristicFun;
import elements.State;
import maze.MainEngine;

public class thirdHeuriticFun extends MazeHeuristicFun implements HeuristicFun
{
	// Depends on the distance between the state and nearest pokemon
	// If equal to zero refer to h1
	public thirdHeuriticFun(MainEngine engine)
	{
		super(engine);
	}

	@Override
	public int getHeuristicCost(State state)
	{
		mazeState tempState = (mazeState) state;
		int pokemonsRemainig = tempState.getPokemonsLeft();
		if (pokemonsRemainig == 0)
		{
			int endPointDistance = getEngine().estimateCost(tempState.getCurrentPosition());
			return endPointDistance;
		}
		// TODO REPLACE NULL WITH 2D ARRAY OF POKEMONS' STATES
		int distanceToNearestPokemon = getEngine().nearestPokimon(tempState.getCurrentPosition(), null);
		return distanceToNearestPokemon;
	}

}
