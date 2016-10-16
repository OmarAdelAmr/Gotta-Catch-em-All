package catch_em;

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
		int pokimonsLeft = getPokimonsLeft(temp, nextCell);
		int stepsLeft = getStepsLeft(temp);
		char d = getNextDirection(temp.getDirection());
		return new mazeState(pokimonsLeft,stepsLeft,nextCell.getCoordinates(),d);
		//TODO heuristics
	}

	@Override
	public char getNextDirection(char d) {
		return d;
	}
	
}
