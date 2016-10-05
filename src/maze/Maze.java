package maze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Maze
{
private cell [][] grid;	
Stack<cell> stack;
private cell endPoint;

public cell[][] getGrid()
{
	return grid;
}


public Maze(int x, int y)
{
	grid  = new cell [x][y];
	stack = new Stack<cell>();
}

public void init()
{
	for (int i = 0; i < grid.length; i++) {
		for (int j = 0; j < grid[0].length; j++)
		{
			int [] index = {j, i};
			cell newCell = new cell(false, false, false, false, index);
			grid[j][i] =  newCell;
		}
	}
	endPoint = grid[(int) (Math.random() * grid.length)][(int) (Math.random() * grid[0].length)];
	makeMaze(0,0);
}

public cell getEndPoint()
{
	return endPoint;
}

public void makeMaze(int x, int y)
{
	cell Cell = grid[x][y];
	if (Cell.visited)
	{
		stack.pop();
		cell next = stack.pop();
		next.visited = false;		
		if (!stack.isEmpty()) makeMaze(next.coordinates[0], next.coordinates[1]);			
		return;
	}
	Cell.visited = true;
	stack.push(Cell);
	ArrayList<cell> neighbours = getNeighbours(Cell);
	Collections.shuffle(neighbours);
	boolean found = false;
	for (int i = 0; i < neighbours.size() && found == false; i++) {
		cell neighbourCell = neighbours.get(i);
		if (!neighbourCell.visited)
		{
		found = true;
		char direction = getDirection(Cell.coordinates[0], Cell.coordinates[1],
										neighbourCell.coordinates[0], neighbourCell.coordinates[1]);		
			if (direction == 'n') 
			{
				Cell.north = true;
				neighbourCell.south = true;
				y--;
			}
			if (direction == 's') 
			{
				Cell.south = true;
				neighbourCell.north = true;
				y++;
			}
			if (direction == 'w') 
			{
				Cell.west = true;
				neighbourCell.east = true;
				x--;
			}
			if (direction == 'e') 
			{
				Cell.east = true;
				neighbourCell.west = true;
				x++;
			}
		}
		
	}	
	makeMaze(x, y); 
	
}
public char getDirection(int currentX, int currentY, int nx, int ny)
{
	if (currentY - ny < 0) return 's';
	if (currentY - ny > 0) return 'n';
	if (currentX - nx > 0) return 'w';
    return 'e';
}
public ArrayList<cell> getNeighbours(cell Cell)
{	
	ArrayList<cell> neighbours = new ArrayList<cell>();
	int x = Cell.coordinates[0];
	int y = Cell.coordinates[1];
	if (y > 0) neighbours.add(grid[x][y - 1]); 
	if (y < grid[0].length - 1) neighbours.add(grid[x][y + 1]); 
	if (x > 0) neighbours.add(grid[x - 1][y]); 
	if (x < grid[0].length - 1) neighbours.add(grid[x + 1][y]); 
	return neighbours;
}
public static void main(String[] args) {
	Maze Maze = new Maze(30,30);
	Maze.init();
	Maze.makeMaze(0, 0);
	
	
	/*for (int i = 0; i < Maze.grid.length; i++) {
		for (int j = 0; j < Maze.grid[0].length; j++) {
			cell Cell = Maze.grid[i][j];
			System.out.print(Cell.coordinates[0] + " , " + Cell.coordinates[1] + ": " +Cell.north + " " + Cell.east + ' ' + Cell.south + 
								' ' + Cell.west + " ");
		}
		System.out.println();
	}*/
}
}
