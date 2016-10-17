package mazeOperators;

import catch_em.mazeState;
import elements.State;
import maze.MainEngine;
import maze.cell;

public class MoveBackwardOperator extends MazeOperator {
	public MoveBackwardOperator(int cost, MainEngine engine) {
		super(cost,engine);
	}

	@Override
	public State getNextState(State state) {
		mazeState temp = (mazeState) state;
		cell nextCell =  getEngine().moveBackward(temp.getCurrentPosition(),temp.getDirection());
		return initNextState(temp, nextCell);
	}
	
	public char getNextDirection(char d){
		switch(d){
		case 'n' : 	return 's';
		case 's' :	return 'n';
		case 'e' :	return 'w';
		case 'w' :	return 'e';
		default: return ' ';
		}
	}
}
