package maze;

import java.util.ArrayList;
import java.util.Random;

import catch_em.mazeState;
import elements.State;

public class MainEngine {
	int [] gameDimensions;
	Player player;
	cell [][] grid;
	int stepsNeeded;
	cell endPoint;
	
	// TODO all of these are supposed to be random
	public MainEngine(int x, int y, int stepsNeeded)
	{
		this.stepsNeeded = stepsNeeded;
		gameDimensions =  new int[]{x, y};
		Maze theMaze = new Maze (x, y);
		theMaze.init();
		
		this.grid = theMaze.getGrid();
		endPoint = theMaze.getEndPoint();
		
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
		ArrayList<cell> actions = this.getPossibleActions(player.getPosition()[0], player.getPosition()[1]);
		if (d == 'n' && actions.get(0) == null) System.out.println("Cannot go north!");
		else if (d == 's' && actions.get(1) == null) System.out.println("Cannot go south!");
		else if (d == 'e' && actions.get(2) == null) System.out.println("Cannot go east!");
		else if (d == 'w' && actions.get(3) == null) System.out.println("Cannot go west!");
		else 
			{
			player.step();
			player.setSteps(player.getSteps() + 1);
			cell PositionCell = grid[player.getPosition()[0]][player.getPosition()[1]];
			if (PositionCell.hasPokimon())
			{
				player.addPokimon(PositionCell.getPokimon());
				PositionCell.setHasPokimon(false);
				PositionCell.setPokimon("");
			}
			if (!player.eggHatched())
			{
				stepsNeeded--;
				if (stepsNeeded == 0)
				{
					System.out.println("Mabrook ksbt m3ana Pikatchu lel");
					player.setEggHatched(true);
				}
			}
			}
	}
	
	
	public ArrayList<cell> getPossibleActions(int x, int y)
	{
		ArrayList<cell> actions = new ArrayList<cell>();
		cell currentCell = grid[x][y];
		actions.add(grid[x][y].north?grid[currentCell.getNeighbour(x, y, 'n')[0]][currentCell.getNeighbour(x, y, 'n')[1]]:null);
		actions.add(grid[x][y].south?grid[currentCell.getNeighbour(x, y, 's')[0]][currentCell.getNeighbour(x, y, 's')[1]]:null);
		actions.add(grid[x][y].east?grid[currentCell.getNeighbour(x, y, 'e')[0]][currentCell.getNeighbour(x, y, 'e')[1]]:null);
		actions.add(grid[x][y].west?grid[currentCell.getNeighbour(x, y, 'w')[0]][currentCell.getNeighbour(x, y, 'w')[1]]:null);
	
		return actions;
	}
	
	public cell moveForward(int[] currentPosition, char d){
		int x = currentPosition[0];
		int y = currentPosition[1];
		cell currentCell = grid[x][y];
		cell nextPosition;
		switch(d){
		case 'n': 	nextPosition = grid[x][y].north?grid[currentCell.getNeighbour(x, y, 'n')[0]][currentCell.getNeighbour(x, y, 'n')[1]]:null;
					break;
		case 's':	nextPosition = grid[x][y].south?grid[currentCell.getNeighbour(x, y, 's')[0]][currentCell.getNeighbour(x, y, 's')[1]]:null;
					break;
		case 'e':	nextPosition = grid[x][y].east?grid[currentCell.getNeighbour(x, y, 'e')[0]][currentCell.getNeighbour(x, y, 'e')[1]]:null;
					break;
		case 'w':	nextPosition = grid[x][y].west?grid[currentCell.getNeighbour(x, y, 'w')[0]][currentCell.getNeighbour(x, y, 'w')[1]]:null;
					break;
		default: nextPosition = null;
			
		}
		
		return nextPosition;
		
	}
	
	public cell moveBackward(int[] currentPosition, char d){
		int x = currentPosition[0];
		int y = currentPosition[1];
		cell currentCell = grid[x][y];
		cell nextPosition;
		switch(d){
		case 'n': 	nextPosition = grid[x][y].south?grid[currentCell.getNeighbour(x, y, 's')[0]][currentCell.getNeighbour(x, y, 's')[1]]:null;
					break;
		case 's':	nextPosition = grid[x][y].north?grid[currentCell.getNeighbour(x, y, 'n')[0]][currentCell.getNeighbour(x, y, 'n')[1]]:null;
					break;
		case 'e':	nextPosition = grid[x][y].west?grid[currentCell.getNeighbour(x, y, 'w')[0]][currentCell.getNeighbour(x, y, 'w')[1]]:null;
					break;
		case 'w':	nextPosition = grid[x][y].east?grid[currentCell.getNeighbour(x, y, 'e')[0]][currentCell.getNeighbour(x, y, 'e')[1]]:null;
					break;
		default: nextPosition = null;
			
		}
		
		return nextPosition;
	}
	
	public cell moveLeft(int[] currentPosition, char d){
		int x = currentPosition[0];
		int y = currentPosition[1];
		cell currentCell = grid[x][y];
		cell nextPosition;
		switch(d){
		case 'n': 	nextPosition = grid[x][y].west?grid[currentCell.getNeighbour(x, y, 'w')[0]][currentCell.getNeighbour(x, y, 'w')[1]]:null;
					break;
		case 's':	nextPosition = grid[x][y].east?grid[currentCell.getNeighbour(x, y, 'e')[0]][currentCell.getNeighbour(x, y, 'e')[1]]:null;
					break;
		case 'e':	nextPosition = grid[x][y].north?grid[currentCell.getNeighbour(x, y, 'n')[0]][currentCell.getNeighbour(x, y, 'n')[1]]:null;
					break;
		case 'w':	nextPosition = grid[x][y].south?grid[currentCell.getNeighbour(x, y, 's')[0]][currentCell.getNeighbour(x, y, 's')[1]]:null;
					break;
		default: nextPosition = null;
			
		}
		
		return nextPosition;
	}
	
	public cell moveRight(int[] currentPosition, char d){
		int x = currentPosition[0];
		int y = currentPosition[1];
		cell currentCell = grid[x][y];
		cell nextPosition;
		switch(d){
		case 'n': 	nextPosition = grid[x][y].east?grid[currentCell.getNeighbour(x, y, 'e')[0]][currentCell.getNeighbour(x, y, 'e')[1]]:null;
					break;
		case 's':	nextPosition = grid[x][y].west?grid[currentCell.getNeighbour(x, y, 'w')[0]][currentCell.getNeighbour(x, y, 'w')[1]]:null;
					break;
		case 'e':	nextPosition = grid[x][y].south?grid[currentCell.getNeighbour(x, y, 's')[0]][currentCell.getNeighbour(x, y, 's')[1]]:null;
					break;
		case 'w':	nextPosition = grid[x][y].north?grid[currentCell.getNeighbour(x, y, 'n')[0]][currentCell.getNeighbour(x, y, 'n')[1]]:null;
					break;
		default: nextPosition = null;
			
		}
		
		return nextPosition;
	}
	
	public int [] calculateCost(cell source, char d)
	{
		int [] costs = new int[4];
		ArrayList<cell> neighbours = getPossibleActions(source.coordinates[0], source.coordinates[1]);
		for (int i = 0; i < neighbours.size(); i++) 
		{
			cell tmp = neighbours.get(i);
			if (tmp != null)
			{
				if (d == 'w' || d == 'e')
					{
						switch(i)
						{
							case 0: costs[i] = 1;
							case 1: costs[i] = 2;
							case 2: costs[i] = 1;
							case 3: costs[i] = 2;
						}
					}
				else
					{
						switch(i)
						{
							case 0: costs[i] = 2;
							case 1: costs[i] = 1;
							case 2: costs[i] = 2;
							case 3: costs[i] = 1;
						}
					}
			}
		}
		
		return costs;
		
	}
	
	@SuppressWarnings("unchecked")
	public Pair <mazeState, Integer>[] actionsWithCost(mazeState state)
	{
		int x = state.getCurrentPosition()[0];
		int y = state.getCurrentPosition()[1];
		char d = state.getDirection();
		int pokimons = state.getPokemonsLeft();
		Pair<mazeState, Integer>[] actions = new Pair [4];
		ArrayList<cell> cells = getPossibleActions(x, y);
		int [] costs = calculateCost(grid[x][y], d);
		for (int i = 0; i < costs.length; i++)
		{
			if (cells.get(i) != null)
			{
				if (cells.get(i).hasPokimon())
				{
					int [] newPosition = cells.get(i).coordinates;
					int newPokimonsLeft = pokimons--;
					mazeState tmp = new mazeState(newPokimonsLeft, state.getStepsLeft() - 1, 
													newPosition, getDirection(i));
					actions[i] =  new Pair<mazeState, Integer>(tmp, costs[i]);
				}

			}
		}
		return actions;
	}
	
	public char getDirection(int i)
	{
		if (i == 0) return 'n';
		if (i == 1) return 's';
		if (i == 2) return 'e';
		return 'w';
	}
	
	public boolean isEndPoint(int [] cell)
	{
		if (cell[0] == endPoint.coordinates[0] &&
				cell[1] == endPoint.coordinates[1])
			return true;
		return false;
	}
	
	public void queryCell(mazeState state)
	{
		System.out.println("3el2 ¯\\_(ツ)_//¯");
	}
	
	public char changeDirectionRight(char d)
	{
		switch(d)
		{
		 case 'n': return 'e'; 
		 case 'e': return 's'; 
		 case 's': return 'w'; 
		 case 'w': return 'n'; 
		}	
		return ' ';
	}
	
	public char changeDirectionLeft(char d)
	{
		switch(d)
		{
		 case 'n': return 'w'; 
		 case 'e': return 'n'; 
		 case 's': return 'e'; 
		 case 'w': return 's'; 
		}	
		return ' ';
	}
	
	
	public Player getPlayer()
	{
		return player;
	}
	
	public int getNumberOfPokemons()
	{
		int result = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++)
			{
				if(grid[i][j].hasPokimon())
				{
					result++;
				}
			}
		}
		return result;
	}
	
	public int getStepsNeeded()
	{
		return stepsNeeded;
	}
	
	public void setStepsNeeded(int stepsNeeded)
	{
		this.stepsNeeded = stepsNeeded;
	}
	
	public cell getEndPoint()
	{
		return endPoint;
	}
	
	public void setEndPoint(cell endPoint)
	{
		this.endPoint = endPoint;
	}
	
	public static void main(String[] args) {
	//MainEngine z = new MainEngine(30,30);
	
	}




}

