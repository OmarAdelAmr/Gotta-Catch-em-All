package qingFuns;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import elements.SearchNode;

public class EnqueueAtEnd implements QingFun {

	@Override
	public Queue<SearchNode> initQueue() {
		return new PriorityQueue<SearchNode>();
	}
	
	@Override
	public Queue<SearchNode> expand(Queue<SearchNode> nodes, ArrayList<SearchNode> newNodes) {
		nodes.addAll(newNodes);
		return nodes;
	}

}
