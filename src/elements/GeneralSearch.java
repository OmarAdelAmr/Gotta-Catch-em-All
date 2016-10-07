package elements;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	public Solution depthLimitedSearch(SearchProblem searchProblem, QingFun qingFun, int depth) {
		Queue<SearchNode> nodes = qingFun.initQueue();
		SearchNode initNode = new SearchNode(searchProblem.getInitialState(), null, null, 0, 0); //TODO
		nodes.add(initNode);
		
		while(!nodes.isEmpty()){
			SearchNode node = nodes.remove();
			if(searchProblem.goalTest(node.getState())){
				return Solution.success(node);
			}
			ArrayList<SearchNode> expandedNodes = searchProblem.expand(node);
			filterExpandedNodesByDepth(expandedNodes, depth);
			if(!expandedNodes.isEmpty())
				nodes = qingFun.expand(nodes, expandedNodes);
		}
		
		return Solution.fail();
	}
	
	public static void filterExpandedNodesByDepth(ArrayList<SearchNode> expandedNodes, int depth){
		ArrayList<SearchNode> filteredNodes = new ArrayList<>();
		Iterator<SearchNode> i = expandedNodes.iterator();
		while(i.hasNext()){
			SearchNode currentNode = i.next();
			if(currentNode.getDepth()<=depth)
				filteredNodes.add(currentNode);
		}
		expandedNodes = filteredNodes;
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
	public Solution IterativeDeepingSearch(SearchProblem searchProblem){
		int depth = 0;
		while(true){
			Solution solution  = depthLimitedSearch(searchProblem,new EnqueueAtFront(),depth);
			if(solution.isSuccess())
				return solution;
			depth++;
			//TODO case missing is if there is no solution at all
		}
	}
	
	
}
