package catch_em;

import elements.Operator;
import elements.State;
import maze.MainEngine;
import maze.cell;

public abstract class MazeOperator extends Operator
{
	protected MainEngine engine;
	public MazeOperator(int cost,MainEngine engine){
		super(cost);
		this.engine = engine;
	}

	public abstract State getNextState(State state);

	public MainEngine getEngine(){
		return engine;
	}
	
	public int getPokimonsLeft(mazeState state, cell nextCell){
		int pokimonsLeft = state.getPokemonsLeft();
		if(nextCell.hasPokimon()){
			pokimonsLeft--;
		}
		return pokimonsLeft;
	}
	
	public int getStepsLeft(mazeState state){
		int stepsLeft = state.getStepsLeft();
		stepsLeft -= getCost();
		if(stepsLeft < 0)
			stepsLeft = 0;
		return stepsLeft;
	}
	
	public abstract char getNextDirection(char d);
	

}
