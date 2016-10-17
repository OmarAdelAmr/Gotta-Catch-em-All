package maze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Maze
{
	private cell [][] grid;	
	private Stack<cell> stack;
	private int numberOfPokimons;

	
	public Maze(int x, int y)
	{
		grid  = new cell [x][y];
		stack = new Stack<cell>();
		numberOfPokimons = 0;
	}
	
	public cell[][] getGrid()
	{
		return grid;
	}
	
	public int getNumberOfPokimons()
	{
		return numberOfPokimons;
	}
	
	public void setNumberOfPokimons(int n)
	{
		this.numberOfPokimons = n;
	}
	
	
	public void init()
	{
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++)
			{
				int [] index = {i, j};
				cell newCell = new cell(false, false, false, false, index);
				this.numberOfPokimons = newCell.hasPokimon()? numberOfPokimons+=1: numberOfPokimons;
				grid[i][j] =  newCell;
			}
		}
		makeMaze(0,0);
	}
	

	
	public void makeMaze(int x, int y)
	{
		cell Cell = grid[x][y];
		System.out.println("Function Called on cell: " + x + " , " + y);

		if (Cell.visited)
		{
			System.out.println("Yes it is visited");
			stack.pop();
			cell next = stack.pop();
			next.visited = false;		
			if (!stack.isEmpty())
				{
				System.out.println("Cell is taken out of stack! " + next.coordinates[0] +  " , " + next.coordinates[1]);

				makeMaze(next.coordinates[0], next.coordinates[1]);	

				}
			return;
		}
		Cell.visited = true;
		stack.push(Cell);
		ArrayList<cell> neighbours = getNeighbours(Cell);
		for (int i = 0; i < neighbours.size(); i++) {
			System.out.println("This cell neighbours are: " + neighbours.get(i).coordinates[0] + " , " + neighbours.get(i).coordinates[1]);
		}
		Collections.shuffle(neighbours);
		boolean found = false;
		for (int i = 0; i < neighbours.size() && found == false; i++) {
			cell neighbourCell = neighbours.get(i);
			if (!neighbourCell.visited)
			{
			System.out.println("Cell " + neighbourCell.coordinates[0] + " , " + neighbourCell.coordinates[1] + " has been chosen");
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
				System.out.println(direction);
			}
			
		}	
		System.out.println("End of function --------- calling on " + x + " , " + y);
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
		if (x < grid.length - 1) neighbours.add(grid[x + 1][y]); 
		return neighbours;
	}
	public static void main(String[] args) {
		Maze Maze = new Maze(4,3);
		Maze.init();
		System.out.println(Maze.getNumberOfPokimons());
		
	
	}
}
