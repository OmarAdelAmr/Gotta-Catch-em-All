package elements;

public abstract class Operator
{
	public int pathCost;
	
	
	public abstract State getNextState(State state);
	
	public int getPathCost(){
		return pathCost;
	}
	
}
