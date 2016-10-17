package mazeOperators;

import catch_em.mazeState;
import elements.State;
import maze.MainEngine;
import maze.cell;

public class MoveLeftOperator extends MazeOperator{
	public MoveLeftOperator(int cost,MainEngine engine) {
		super(cost,engine);
	}

	@Override
	public State getNextState(State state) {
		mazeState temp = (mazeState) state;
		cell nextCell =  getEngine().moveLeft(temp.getCurrentPosition(),temp.getDirection());
		return initNextState(temp, nextCell);
	}

	@Override
	public char getNextDirection(char d) {
		switch(d){
		case 'n': return 'w';
		case 's': return 'e';
		case 'e': return 'n';
		case 'w': return 's';
		default : return ' ';
		}
	}
}
