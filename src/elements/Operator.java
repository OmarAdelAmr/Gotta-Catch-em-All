package elements;

public abstract class Operator
{
	private int cost;

	public abstract State getNextState(State state);

	public Operator(int cost)
	{
		this.cost = cost;
	}

	public int getCost()
	{
		return cost;
	}

	public void setCost(int cost)
	{
		this.cost = cost;
	}

}
