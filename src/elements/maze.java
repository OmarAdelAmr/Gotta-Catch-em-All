package elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class maze
{
	cell[][] grid;
	Stack<cell> stack;

	public maze(int x, int y)
	{
		grid = new cell[x][y];
		stack = new Stack<cell>();
	}

	public void init()
	{
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				int[] index = { j, i };
				cell newCell = new cell(false, false, false, false, index);
				grid[j][i] = newCell;
			}
		}
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				// System.out.println(grid[j][i].coordinates[0]+ "," +
				// grid[j][i].coordinates[1]);
			}
		}
	}

	public void makeMaze(int x, int y)
	{
		cell Cell = grid[x][y];
		if (Cell.visited)
		{
			stack.pop();
			cell next = stack.pop();

			if (!stack.isEmpty())
			{
				System.out.println("Next is taken " + next.coordinates[0] + " " + next.coordinates[1]);
				makeMaze(next.coordinates[0], next.coordinates[1]);

			}
			return;
		}
		Cell.visited = true;
		stack.push(Cell);
		ArrayList<cell> neighbours = getNeighbours(Cell);
		Collections.shuffle(neighbours);
		boolean found = false;
		for (int i = 0; i < neighbours.size() && found == false; i++)
		{
			cell neighbourCell = neighbours.get(i);
			if (!neighbourCell.visited)
			{
				found = true;
				System.out
						.println("Selected Cell: " + neighbourCell.coordinates[0] + " " + neighbourCell.coordinates[1]);
				char direction = getDirection(Cell.coordinates[0], Cell.coordinates[1], neighbourCell.coordinates[0],
						neighbourCell.coordinates[1]);
				System.out.println(direction);

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

		System.out.println(x + "," + y);
		makeMaze(x, y);

	}

	public char getDirection(int currentX, int currentY, int nx, int ny)
	{
		if (currentY - ny < 0)
			return 's';
		if (currentY - ny > 0)
			return 'n';
		if (currentX - nx > 0)
			return 'w';
		return 'e';

	}

	public ArrayList<cell> getNeighbours(cell Cell)
	{
		ArrayList<cell> neighbours = new ArrayList<cell>();
		int x = Cell.coordinates[0];
		int y = Cell.coordinates[1];
		System.out.println("Cell nummer: " + x + " " + y);
		if (y > 0)
			neighbours.add(grid[x][y - 1]);
		if (y < grid[0].length)
			neighbours.add(grid[x][y + 1]);
		if (x > 0)
			neighbours.add(grid[x - 1][y]);
		if (x < grid[0].length)
			neighbours.add(grid[x + 1][y]);
		for (int i = 0; i < neighbours.size(); i++)
		{
			System.out.println(
					"Neighbours :" + neighbours.get(i).coordinates[0] + " " + neighbours.get(i).coordinates[1]);
		}
		return neighbours;
	}

	public static void main(String[] args)
	{
		maze Maze = new maze(500, 500);
		Maze.init();
		Maze.makeMaze(0, 0);
	}
}
