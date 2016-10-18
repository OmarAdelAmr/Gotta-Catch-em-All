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

	public State initNextState(mazeState state, cell cell){
		if(cell == null){
			return null;
		}
		int pokimonsLeft = getPokimonsLeft(state, cell);
		boolean[][] pokimons = getPokimons(state,cell);
		int stepsLeft = getStepsLeft(state);
		char d = getNextDirection(state.getDirection());
		return new mazeState(pokimonsLeft,stepsLeft,cell.getCoordinates(),d,pokimons);
	}
	
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
		boolean[][] pokimons = copyPokimonsArray(state.getPokemons());
		int x = nextCell.getCoordinates()[0];
		int y = nextCell.getCoordinates()[1];
		if(pokimons[x][y]){
			pokimons[x][y] = false;
		}
		return pokimons;
	}
	
	public static boolean[][] copyPokimonsArray(boolean[][] old){
		boolean[][] pokis = new boolean[old.length][old[0].length];
		for(int i = 0;i<pokis.length;i++){
			for(int j = 0;j<pokis[i].length;j++){
				pokis[i][j] = old[i][j];
			}
		}
		return pokis;
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
