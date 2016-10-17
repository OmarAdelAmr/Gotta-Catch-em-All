package catch_em;

public class SearchSolution
{
	// TODO ADD SEQUENCE OF MOVES TO REACH THE GOAL

	private int solutionCost;
	private int numberOfNodesExpanded;

	public SearchSolution(int solutionCost, int numberOfNodesExpanded)
	{
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
