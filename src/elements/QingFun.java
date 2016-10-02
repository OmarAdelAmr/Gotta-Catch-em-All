package elements;

import java.util.ArrayList;
import java.util.PriorityQueue;

public interface QingFun {
	public PriorityQueue<SearchNode> expand(PriorityQueue<SearchNode> nodes, ArrayList<SearchNode> newNodes);
	public PriorityQueue<SearchNode> initQueue();
}
