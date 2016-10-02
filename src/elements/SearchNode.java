package elements;

public class SearchNode {
	State state;
	SearchNode parent;
	Operator operator;
	int depth;
	int pathCost;
	
	
	public SearchNode(State state, SearchNode parent, Operator operator, int depth, int pathCost) {
		super();
		this.state = state;
		this.parent = parent;
		this.operator = operator;
		this.depth = depth;
		this.pathCost = pathCost;
	}
	
	public State getState() {
		return state;
	}
	public SearchNode getParent() {
		return parent;
	}
	public Operator getOperator() {
		return operator;
	}
	public int getDepth() {
		return depth;
	}
	public int getPathCost() {
		return pathCost;
	}
	
}
