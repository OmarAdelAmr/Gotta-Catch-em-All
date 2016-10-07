package qingFuns;

import java.util.ArrayList;
import java.util.Queue;

import elements.SearchNode;

public interface QingFun {
	public Queue<SearchNode> initQueue();
	public Queue<SearchNode> expand(Queue<SearchNode> nodes, ArrayList<SearchNode> newNodes);
}
