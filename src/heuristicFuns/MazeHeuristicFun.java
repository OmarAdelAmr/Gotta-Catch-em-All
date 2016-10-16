package heuristicFuns;

import maze.MainEngine;

public abstract class MazeHeuristicFun {
	private MainEngine engine;

	public MazeHeuristicFun(MainEngine engine) {
		this.engine = engine;
	}
	
	public MainEngine getEngine() {
		return engine;
	}
	
}
