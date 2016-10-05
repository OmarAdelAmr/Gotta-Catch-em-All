package catch_em;

import maze.MainEngine;

public class catchEmAll
{

	private MainEngine maze_engine;
	private mazeSearchProblem search_problem;

	public catchEmAll()
	{
		maze_engine = new MainEngine(10, 10, 2);
		initSearchProblem();
	}

	public void initSearchProblem()
	{
		mazeState initState = new mazeState(maze_engine.getPokemons(), maze_engine.getStepsNeeded(),
				maze_engine.getPlayer().getPosition(), maze_engine.getPlayer().getDirection());
	}

	public static void main(String[] args)
	{
		new catchEmAll();
	}

}
