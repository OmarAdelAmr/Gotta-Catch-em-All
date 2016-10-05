package elements;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class SearchProblem {
	private ArrayList<Operator> operators;
	private State initialState;
	private ArrayList<State> stateSpace;
	public abstract boolean goalTest(State state);
	public abstract int pathCost(State state);
	
	public ArrayList<Operator> getOperators() {
		return operators;
	}
	public State getInitialState() {
		return initialState;
	}
	public ArrayList<State> getStateSpace() {
		return stateSpace;
	}
	
	public ArrayList<SearchNode> expand(SearchNode node){
		ArrayList<SearchNode> result = new ArrayList<>();
		Iterator<Operator> i = operators.iterator();
		while(i.hasNext()){
			Operator operator = i.next();
			SearchNode nextNode = new SearchNode(
					operator.getNextState(node.getState()),
					node,
					operator,
					node.getDepth()+1,
					node.getPathCost()+operator.getCost());
			result.add(nextNode);
		}
		return result;
	}
	
	
	
}
