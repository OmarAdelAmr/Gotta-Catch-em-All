package catch_em;

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
		int pokimonsLeft = getPokimonsLeft(temp, nextCell);
		int stepsLeft = getStepsLeft(temp);
		char d = getNextDirection(temp.getDirection());
		return new mazeState(pokimonsLeft,stepsLeft,nextCell.getCoordinates(),d);
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
