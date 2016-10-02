
public class cell {

	
boolean north, south, east, west, visited;
int [] coordinates;

public cell (boolean n, boolean s, boolean e, boolean w, int [] c)
{
	north = n;
	south = s;
	east = s;
	west = w;
	visited = false;
	coordinates = c;
	
}

}
