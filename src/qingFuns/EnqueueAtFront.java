package qingFuns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import elements.SearchNode;

public class EnqueueAtFront implements QingFun{
	@Override
	public Queue<SearchNode> initQueue() {
		return new LinkedList<SearchNode>();
	}

	
	@Override
	public Queue<SearchNode> expand(Queue<SearchNode> nodes, ArrayList<SearchNode> newNodes) {
		LinkedList<SearchNode> temp = (LinkedList<SearchNode>) nodes;
		temp.addAll(0, newNodes);
		return temp;
	}
}
