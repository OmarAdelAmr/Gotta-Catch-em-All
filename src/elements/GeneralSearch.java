package elements;

import java.util.Queue;

import qingFuns.EnqueueAtEnd;
import qingFuns.EnqueueAtFront;
import qingFuns.OrderedInsert;
import qingFuns.QingFun;

public class GeneralSearch {
	
	public Solution search(SearchProblem searchProblem, QingFun qingFun){
		Queue<SearchNode> nodes = qingFun.initQueue();
		SearchNode initNode = new SearchNode(searchProblem.getInitialState(), null, null, 0, 0); //TODO
		nodes.add(initNode);
		
		while(!nodes.isEmpty()){
			SearchNode node = nodes.remove();
			if(searchProblem.goalTest(node.getState())){
				return Solution.success(node);
			}
			nodes = qingFun.expand(nodes, searchProblem.expand(node));
		}
		
		return Solution.fail();
				
	}
	
	public Solution BFS(SearchProblem searchProblem){
		return search(searchProblem,new EnqueueAtEnd());
	}
	public Solution DFS(SearchProblem searchProblem){
		return search(searchProblem,new EnqueueAtFront());
	}
	public Solution UniformCostSearch(SearchProblem searchProblem){
		return search(searchProblem,new OrderedInsert());
	}
	
	
}
