package mazeOperators;

import catch_em.mazeState;
import elements.State;
import maze.MainEngine;
import maze.cell;

public class MoveForwardOperator extends MazeOperator {
	
	
	public MoveForwardOperator(int cost,MainEngine engine) {
		super(cost,engine);
	}

	@Override
	public State getNextState(State state) {
		mazeState temp = (mazeState) state;
		cell nextCell =  getEngine().moveForward(temp.getCurrentPosition(),temp.getDirection());
		return initNextState(temp, nextCell);
	}

	@Override
	public char getNextDirection(char d) {
		return d;
	}
	
}
