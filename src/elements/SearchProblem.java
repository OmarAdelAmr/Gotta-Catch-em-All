package elements;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class SearchProblem
{
	private ArrayList<Operator> operators;
	private State initialState;
	private ArrayList<State> stateSpace;
	private HeuristicFun heuristicFun;

	public abstract boolean goalTest(State state);

	public abstract int pathCost(State state);

	public SearchProblem(ArrayList<Operator> operators, State initialState, ArrayList<State> stateSpace,
			HeuristicFun heuristicFun)
	{
		this.operators = operators;
		this.initialState = initialState;
		this.stateSpace = stateSpace;
		this.heuristicFun = heuristicFun;
	}

	public ArrayList<SearchNode> expand(SearchNode node)
	{
		ArrayList<SearchNode> result = new ArrayList<>();
		Iterator<Operator> i = operators.iterator();
		while (i.hasNext())
		{
			Operator operator = i.next();

			State nextState = operator.getNextState(node.getState());
			int HeuristicCost = heuristicFun.getHeuristicCost(nextState);
			SearchNode nextNode = new SearchNode(nextState, node, operator, node.getDepth() + 1,
					node.getPathCost() + operator.getCost(), HeuristicCost);

			result.add(nextNode);
		}
		return result;
	}

	public ArrayList<Operator> getOperators()
	{
		return operators;
	}

	public State getInitialState()
	{
		return initialState;
	}

	public ArrayList<State> getStateSpace()
	{
		return stateSpace;
	}

	public HeuristicFun getHeuristicFun()
	{
		return heuristicFun;
	}

	public void setHeuristicFun(HeuristicFun heuristicFun)
	{
		this.heuristicFun = heuristicFun;
	}

	public void setOperators(ArrayList<Operator> operators)
	{
		this.operators = operators;
	}

	public void setInitialState(State initialState)
	{
		this.initialState = initialState;
	}

	public void setStateSpace(ArrayList<State> stateSpace)
	{
		this.stateSpace = stateSpace;
	}

}
