package elements;

import java.util.ArrayList;
import java.util.Random;

public class MainEngine {
int [] gameDimensions;
Player player;
cell [][] grid;
public MainEngine(int x, int y)
{
	gameDimensions =  new int[]{x, y};
	Maze theMaze = new Maze (x, y);
	theMaze.init();
	
	this.grid = theMaze.getGrid();
	
	int posX = (int) (Math.random() * x);
	int posY = (int) (Math.random() * y);
	
	boolean found = false;
	char directorC = ' ';
	while(!found) {
		Random rand = new Random();
		int director = rand.nextInt(19) + 101;
		if (director % 110 == 0||director % 101 == 0||
				director % 115 == 0|| director % 119 == 0) 
			{
			found = !found;
			directorC = (char) director;
			this.player = new Player (posX, posY, directorC);
			}
	}
}

//control function

public void rotateRight()
{
	player.rotateRight();
}

public void rotateLeft()
{
	player.rotateLeft();
}

public void step()
{
	char d = player.getDirection();
	ArrayList<cell> actions = this.getPossibleActions(player.getPosition()[0], player.getPosition()[1], d);
	if (d == 'n' && actions.get(0) == null) System.out.println("Cannot go north!");
	else if (d == 's' && actions.get(1) == null) System.out.println("Cannot go south!");
	else if (d == 'e' && actions.get(2) == null) System.out.println("Cannot go east!");
	else if (d == 'w' && actions.get(3) == null) System.out.println("Cannot go west!");
	else player.step();
}


public ArrayList<cell> getPossibleActions(int x, int y, char d)
{
	ArrayList<cell> actions = new ArrayList<cell>();
	cell currentCell = grid[x][y];
	actions.add(grid[x][y].north?grid[currentCell.getNeighbour(x, y, 'n')[0]][currentCell.getNeighbour(x, y, 'n')[1]]:null);
	actions.add(grid[x][y].south?grid[currentCell.getNeighbour(x, y, 's')[0]][currentCell.getNeighbour(x, y, 's')[1]]:null);
	actions.add(grid[x][y].east?grid[currentCell.getNeighbour(x, y, 'e')[0]][currentCell.getNeighbour(x, y, 'e')[1]]:null);
	actions.add(grid[x][y].west?grid[currentCell.getNeighbour(x, y, 'w')[0]][currentCell.getNeighbour(x, y, 'w')[1]]:null);

	return actions;
}



public static void main(String[] args) {
//MainEngine z = new MainEngine(30,30);

}

}

