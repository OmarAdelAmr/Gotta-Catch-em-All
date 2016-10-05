package elements;

import java.util.ArrayList;
import java.util.Queue;

public interface QingFun {
	public Queue<SearchNode> expand(Queue<SearchNode> nodes, ArrayList<SearchNode> newNodes);
	public Queue<SearchNode> initQueue();
}
