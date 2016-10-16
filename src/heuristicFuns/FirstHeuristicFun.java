package heuristicFuns;

import catch_em.mazeState;
import elements.HeuristicFun;
import elements.State;
import maze.MainEngine;

public class FirstHeuristicFun extends MazeHeuristicFun implements HeuristicFun {

	public FirstHeuristicFun(MainEngine engine) {
		super(engine);
	}

	@Override
	public int getHeuristicCost(State state) {
		mazeState temp = (mazeState) state;
		// return getEngine().firstHeuristicFun(/*2le 2nta 3awzo*/);
		return 0;//TODO
	}

}
