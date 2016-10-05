package catch_em;

import elements.Operator;
import elements.State;

public class mazeOperator extends Operator
{

	private String operator;

	public mazeOperator(String operator, int cost)
	{
		super(cost);
		this.operator = operator;
	}

	public State getNextState(State state)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String operator)
	{
		this.operator = operator;
	}

}
