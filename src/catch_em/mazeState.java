package catch_em;

import java.util.ArrayList;

import elements.State;
import maze.cell;

public class mazeState extends State
{
	private ArrayList<String> pokemonsLeft;
	private int stepsLeft;
	private int[] currentPosition;
	private char direction;
	// TODO add vector of steps

	public mazeState(ArrayList<String> pokemonsLeft, int stepsLeft, int[] currentPosition, char direction)
	{
		this.pokemonsLeft = pokemonsLeft;
		this.stepsLeft = stepsLeft;
		this.currentPosition = currentPosition;
		this.direction = direction;
	}

	public ArrayList<String> getPokemonsLeft()
	{
		return pokemonsLeft;
	}

	public void setPokemonsLeft(ArrayList<String> pokemonsLeft)
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
