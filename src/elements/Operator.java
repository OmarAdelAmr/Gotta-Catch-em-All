package elements;

public abstract class Operator
{
	protected int cost;
	
	public Operator(int cost)
	{
		this.cost = cost;
	}
	
	public abstract State getNextState(State state);

	public int getCost()
	{
		return cost;
	}

	public void setCost(int cost)
	{
		this.cost = cost;
	}

}
