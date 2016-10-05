package elements;

import java.util.ArrayList;

public class Player {
private int steps;
private int [] position;
private char direction;
private boolean eggHatched;
private ArrayList<String> catchedPokimons;

public Player(int x, int y, char direction)
{
	this.steps = 0;
	this.position = new int []{x, y};
	this.direction = direction;
	eggHatched = false;
	catchedPokimons = new ArrayList<String>();
}

public void addPokimon(String pokimon)
{
	catchedPokimons.add(pokimon);
}

public boolean eggHatched()
{
	return eggHatched;
}

public void setEggHatched(boolean eggHatched)
{
	this.eggHatched = eggHatched;
}

public int getSteps()
{
	return steps;
}

public void setSteps(int steps)
{
	this.steps = steps;
}

public int [] getPosition()
{
	return position;
}

public char getDirection()
{
	return direction;
}

public void step()
{
	switch(direction)
	{
		case 'n' : this.position[0]--; break;
		case 's' : this.position[0]++; break;
		case 'w' : this.position[1]--; break;
		case 'e' : this.position[1]++; break;
	}
}

public void rotateRight()
{
	switch(direction)
	{
	 case 'n': direction = 'e'; break;
	 case 'e': direction = 's'; break;
	 case 's': direction = 'w'; break;
	 case 'w': direction = 'n'; break;
	}
}

public void rotateLeft()
{
	switch(direction)
	{
	 case 'n': direction = 'w'; break;
	 case 'e': direction = 'n'; break;
	 case 's': direction = 'e'; break;
	 case 'w': direction = 's'; break;
	}
}

public static void main(String[] args) {
	//Player x = new Player(15,15, 'e');
	
}
}
