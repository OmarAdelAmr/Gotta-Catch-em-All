package catch_em;

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
		int pokimonsLeft = getPokimonsLeft(temp, nextCell);
		int stepsLeft = getStepsLeft(temp);
		char d = getNextDirection(temp.getDirection());
		return new mazeState(pokimonsLeft,stepsLeft,nextCell.getCoordinates(),d);
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
