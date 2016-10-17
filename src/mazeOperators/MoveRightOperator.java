package mazeOperators;

import catch_em.mazeState;
import elements.State;
import maze.MainEngine;
import maze.cell;

public class MoveRightOperator extends MazeOperator {
	public MoveRightOperator(int cost,MainEngine engine) {
		super(cost,engine);
	}

	@Override
	public State getNextState(State state) {
		mazeState temp = (mazeState) state;
		cell nextCell =  getEngine().moveRight(temp.getCurrentPosition(),temp.getDirection());
		return initNextState(temp, nextCell);
	}

	@Override
	public char getNextDirection(char d) {
		switch(d){
		case 'n': return 'e';
		case 's': return 'w';
		case 'e': return 's';
		case 'w': return 'n';
		default : return ' ';
		}
	}
}
