package heuristicFuns;

import catch_em.mazeState;
import elements.HeuristicFun;
import elements.State;
import maze.MainEngine;


public class SecondHeuristicFun extends MazeHeuristicFun implements HeuristicFun {

	public SecondHeuristicFun(MainEngine engine) {
		super(engine);
	}

	@Override
	public int getHeuristicCost(State state) {
		mazeState temp = (mazeState) state;
		// return getEngine().secondHeuristicFun(/*2le 2nta 3awzo*/);
		return 0;//TODO
	}

}
