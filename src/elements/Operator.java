package elements;

public abstract class Operator
{
	private int cost;

	public abstract State getNextState(State state);

	public int getCost()
	{
		return cost;
	}

}
