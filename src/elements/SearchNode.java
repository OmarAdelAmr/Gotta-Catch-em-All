package elements;

public class SearchNode {
	private State state;
	private SearchNode parent;
	private Operator operator;
	private int depth;
	private int pathCost;
	private int predictedCost;
	
	
	public SearchNode(State state, SearchNode parent, Operator operator, int depth, int pathCost, int predictedCost) {
		this.state = state;
		this.parent = parent;
		this.operator = operator;
		this.depth = depth;
		this.pathCost = pathCost;
		this.predictedCost = predictedCost;
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
	public int getPredictedCost(){
		return predictedCost;
	}
	
}
