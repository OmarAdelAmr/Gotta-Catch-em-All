package elements;

import java.util.ArrayList;

public class Solution {
	private boolean success;
	ArrayList<State> path;
	int pathCost;
	int nodesVisited;
	
	public Solution(boolean success, ArrayList<State> path, int nodesVisited, int pathCost){
		this.success = success;
		this.path = path;
		this.pathCost = pathCost;
		this.nodesVisited = nodesVisited;
	}
	
	public static Solution success(SearchNode node,int nodesVisited){
		ArrayList<State> result = new ArrayList<>();
		int cost = node.getPathCost();
		while(node != null){
			result.add(0,node.getState());
			node = node.getParent();
		}
		return new Solution(true, result, nodesVisited, cost);
	}
	
	public static Solution fail(int nodesVisited){
		return new Solution(false,null, nodesVisited, -1);
	}
	
	public boolean isSuccess(){
		return success;
	}

	public ArrayList<State> getPath() {
		return path;
	}

	public int getPathCost() {
		return pathCost;
	}

	public int getNodesVisited() {
		return nodesVisited;
	}
	
}
