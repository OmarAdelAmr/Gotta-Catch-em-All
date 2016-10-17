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
		int pokimonsLeft = getPokimonsLeft(temp, nextCell);
		boolean[][] pokimons = getPokimons(temp,nextCell);
		int stepsLeft = getStepsLeft(temp);
		char d = getNextDirection(temp.getDirection());
		return new mazeState(pokimonsLeft,stepsLeft,nextCell.getCoordinates(),d,pokimons);
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
