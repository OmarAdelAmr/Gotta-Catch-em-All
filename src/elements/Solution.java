package elements;

import java.util.ArrayList;

public class Solution {
	private boolean success;
	ArrayList<State> path;
	public Solution(boolean success, ArrayList<State> path){
		this.success = success;
		this.path = path;
	}
	
	public static Solution success(SearchNode node){
		ArrayList<SearchNode> result = new ArrayList<>();
		while(node != null){
			result.add(0,node);
			node = node.getParent();
		}
		return new Solution(true, null);
	}
	
	public static Solution fail(){
		return new Solution(false,null);
	}
	
	public boolean isSuccess(){
		return success;
	}
}
