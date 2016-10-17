package elements;

import java.util.ArrayList;

public class Solution {
	private boolean success;
	ArrayList<State> path;
	int pathCost;
	int nodesVisited;
	
	public Solution(boolean success, ArrayList<State> path, int nodesVisited){
		this.success = success;
		this.path = path;
		this.nodesVisited = nodesVisited;
	}
	
	public static Solution success(SearchNode node,int nodesVisited){
		ArrayList<SearchNode> result = new ArrayList<>();
		while(node != null){
			result.add(0,node);
			node = node.getParent();
		}
		return new Solution(true, null, nodesVisited);
	}
	
	public static Solution fail(int nodesVisited){
		return new Solution(false,null, nodesVisited);
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
