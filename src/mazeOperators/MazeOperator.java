package mazeOperators;

import catch_em.mazeState;
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
		boolean[][] pokimons = state.getPokemons();
		int x = nextCell.getCoordinates()[0];
		int y = nextCell.getCoordinates()[1];
		if(pokimons[x][y]){
			return state.getPokemonsLeft()-1;
		}
		return state.getPokemonsLeft();
	}
	
	public boolean[][] getPokimons(mazeState state, cell nextCell){
		boolean[][] pokimons = state.getPokemons().clone();
		int x = nextCell.getCoordinates()[0];
		int y = nextCell.getCoordinates()[1];
		if(pokimons[x][y]){
			pokimons[x][y] = false;
		}
		return pokimons;
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
