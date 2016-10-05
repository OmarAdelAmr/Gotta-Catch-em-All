package maze;
public class cell {

	
boolean north, south, east, west, visited;
int [] coordinates;
private String pokimon;
private boolean hasPokimon;
private int cost;

public cell (boolean n, boolean s, boolean e, boolean w, int [] c)
{
	north = n;
	south = s;
	east = s;
	west = w;
	visited = false;
	coordinates = c;
	hasPokimon = false;
	pokimon = "";
	cost = 0;
	
}


public int getCost()
{
	return cost;
}
public void setCost(int cost)
{
	this.cost = cost;
}

public String getPokimon() {
	return pokimon;
}



public void setPokimon(String pokimon) {
	this.pokimon = pokimon;
}



public boolean hasPokimon() {
	return hasPokimon;
}



public void setHasPokimon(boolean hasPokimon) {
	this.hasPokimon = hasPokimon;
}



public int [] getNeighbour(int x, int y, char d)
{
	switch (d){
		case 'n': return new int []{x - 1, y};
		case 's': return new int []{x + 1, y};
		case 'e': return new int []{x, y + 1};
		case 'w': return new int []{x, y - 1};
	}
	return new int[]{};

}

public void addPokimon()
{
	int random = Math.random() > 0.5? 1:0;
	if (random == 1)
	{
	 hasPokimon = true;
	 this.pokimon = Pokimon.getRandom().name();
	}

}

}
