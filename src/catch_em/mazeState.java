package catch_em;

import elements.State;

public class mazeState extends State
{
	private int pokemonsLeft;
	private int stepsLeft;
	private int[] currentPosition;
	private char direction;
	// TODO add vector of steps

	public mazeState(int pokemonsLeft, int stepsLeft, int[] currentPosition, char direction)
	{
		this.pokemonsLeft = pokemonsLeft;
		this.stepsLeft = stepsLeft;
		this.currentPosition = currentPosition;
		this.direction = direction;
	}

	public int getPokemonsLeft()
	{
		return pokemonsLeft;
	}

	public void setPokemonsLeft(int pokemonsLeft)
	{
		this.pokemonsLeft = pokemonsLeft;
	}

	public int getStepsLeft()
	{
		return stepsLeft;
	}

	public void setStepsLeft(int stepsLeft)
	{
		this.stepsLeft = stepsLeft;
	}

	public int[] getCurrentPosition()
	{
		return currentPosition;
	}

	public void setCurrentPosition(int[] currentPosition)
	{
		this.currentPosition = currentPosition;
	}

	public char getDirection()
	{
		return direction;
	}

	public void setDirection(char direction)
	{
		this.direction = direction;
	}

}