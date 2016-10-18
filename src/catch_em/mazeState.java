package catch_em;

import elements.State;

public class mazeState extends State {
	private int pokemonsLeft;
	private int stepsLeft;
	private int[] currentPosition;
	private char direction;
	private boolean[][] pokemons; // true if there is a pokemon
	// TODO add vector of steps

	public mazeState(int pokemonsLeft, int stepsLeft, int[] currentPosition, char direction, boolean[][] pokemons) {
		this.pokemonsLeft = pokemonsLeft;
		this.stepsLeft = stepsLeft;
		this.currentPosition = currentPosition;
		this.direction = direction;
		this.pokemons = pokemons;
	}

	public int getPokemonsLeft() {
		return pokemonsLeft;
	}

	public void setPokemonsLeft(int pokemonsLeft) {
		this.pokemonsLeft = pokemonsLeft;
	}

	public int getStepsLeft() {
		return stepsLeft;
	}

	public void setStepsLeft(int stepsLeft) {
		this.stepsLeft = stepsLeft;
	}

	public int[] getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int[] currentPosition) {
		this.currentPosition = currentPosition;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public boolean[][] getPokemons() {
		return pokemons;
	}

	public void setPokemons(boolean[][] pokemons) {
		this.pokemons = pokemons;
	}

	public String toString() {
		return "{position = ("+currentPosition[0]+", "+currentPosition[1]+") direction = "+ direction+" pokemons left = " + pokemonsLeft + " stepsLeft = " + stepsLeft+"}";
	}

	public boolean comparePokemonsArray(boolean[][] y) {
		for (int i = 0; i < y.length; i++) {
			for (int j = 0; j < y[0].length; j++) {
				if (y[i][j] ^ this.pokemons[i][j])
					return false;
			}
		}
		return true;
	}

	@Override
	public boolean equals(Object y) {
		if (!(y instanceof mazeState))
			return false;
		mazeState temp = (mazeState) y;
		return this.currentPosition[0] == temp.currentPosition[0] && this.currentPosition[1] == temp.currentPosition[1]
				&& this.direction == temp.direction && this.stepsLeft == temp.stepsLeft
				&& this.pokemonsLeft == temp.pokemonsLeft && comparePokemonsArray(temp.pokemons);
	}

}
