package heuristicFuns;

import catch_em.mazeState;
import elements.HeuristicFun;
import elements.State;
import maze.MainEngine;

public class FourthHeuristicFun extends MazeHeuristicFun implements HeuristicFun
{
	// Depends on the distance between the state and the end point
	public FourthHeuristicFun(MainEngine engine)
	{
		super(engine);
	}

	@Override
	public int getHeuristicCost(State state)
	{
		mazeState tempState = (mazeState) state;
		int remainingPokemons = tempState.getPokemonsLeft();
		int[] statePosition = tempState.getCurrentPosition();
		// TODO RETURN NUMBER OF TRUE VALUES IN POKEMONS'STATES ARRAY
		return remainingPokemons;
	}
}
