package qingFuns;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import elements.SearchNode;

public class OrderedInsert implements QingFun {
	private Comparator<SearchNode> comparator;
	
	
	
	public OrderedInsert(Comparator<SearchNode> comparator) {
		this.comparator = comparator;
	}
	
	public OrderedInsert(){
		this(new Comparator<SearchNode>() {
			@Override
			public int compare(SearchNode n1, SearchNode n2) {
				return n1.getPathCost() - n2.getPathCost();
			}
		});
	}

	@Override
	public Queue<SearchNode> initQueue() {

		return new PriorityQueue<SearchNode>(comparator);
	}
	
	@Override
	public Queue<SearchNode> expand(Queue<SearchNode> nodes, ArrayList<SearchNode> newNodes) {
		nodes.addAll(newNodes);
		return nodes;
	}

}
