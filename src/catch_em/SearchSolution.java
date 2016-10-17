package catch_em;

import java.util.ArrayList;

public class SearchSolution
{
	
	private ArrayList<mazeState> path;
	private int solutionCost;
	private int numberOfNodesExpanded;

	public SearchSolution(ArrayList<mazeState> path, int solutionCost, int numberOfNodesExpanded)
	{
		this.path = path;
		this.solutionCost = solutionCost;
		this.numberOfNodesExpanded = numberOfNodesExpanded;
	}
	

	public int getSolutionCost()
	{
		return solutionCost;
	}

	public void setSolutionCost(int solutionCost)
	{
		this.solutionCost = solutionCost;
	}

	public int getNumberOfNodesExpanded()
	{
		return numberOfNodesExpanded;
	}

	public void setNumberOfNodesExpanded(int numberOfNodesExpanded)
	{
		this.numberOfNodesExpanded = numberOfNodesExpanded;
	}
	

}
