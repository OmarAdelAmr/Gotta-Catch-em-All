package elements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;

import qingFuns.EnqueueAtEnd;
import qingFuns.EnqueueAtFront;
import qingFuns.OrderedInsert;
import qingFuns.QingFun;

public class GeneralSearch {
	int nodesVisited;
	ArrayList<State> visitedStates;
	public GeneralSearch(){
		nodesVisited = 0;
		visitedStates = new ArrayList<>();
	}
	public Solution search(SearchProblem searchProblem, QingFun qingFun){
		Queue<SearchNode> nodes = qingFun.initQueue(); 
		SearchNode initNode = new SearchNode(searchProblem.getInitialState(), null, null, 0, 0, -1);
		nodes.add(initNode);
		
		while(!nodes.isEmpty()){
			SearchNode node = nodes.remove();
			if(!visitedStates.contains(node.getState())){
				visitedStates.add(node.getState());
				nodesVisited++;
				if(searchProblem.goalTest(node.getState())){
					return Solution.success(node, nodesVisited);
				}
				ArrayList<SearchNode> expandedNodes = searchProblem.expand(node);
				//expandedNodes = filterExpandedNodesByVisitedStates(expandedNodes);
				nodes = qingFun.expand(nodes, expandedNodes);
			}
		}
		
		return Solution.fail(nodesVisited);
				
	}
	
	public Solution depthLimitedSearch(SearchProblem searchProblem, QingFun qingFun, int depth) {
		Queue<SearchNode> nodes = qingFun.initQueue();
		SearchNode initNode = new SearchNode(searchProblem.getInitialState(), null, null, 0, 0, -1);
		nodes.add(initNode);
		
		while(!nodes.isEmpty()){
			SearchNode node = nodes.remove();
			if(!visitedStates.contains(node.getState())){
				visitedStates.add(node.getState());
				nodesVisited++;
				if(searchProblem.goalTest(node.getState())){
					return Solution.success(node, nodesVisited);
				}
				ArrayList<SearchNode> expandedNodes = searchProblem.expand(node);
				expandedNodes = filterExpandedNodesByDepth(expandedNodes, depth);
				//expandedNodes = filterExpandedNodesByVisitedStates(expandedNodes);
				if(!expandedNodes.isEmpty())
					nodes = qingFun.expand(nodes, expandedNodes);
			}
		}
		visitedStates.clear();
		return Solution.fail(nodesVisited);
	}
	
	public ArrayList<SearchNode> filterExpandedNodesByVisitedStates(ArrayList<SearchNode> expandedNodes){
		ArrayList<SearchNode> filteredNodes = new ArrayList<>();
		Iterator<SearchNode> i = expandedNodes.iterator();
		while(i.hasNext()){
			SearchNode currentNode = i.next();
			if(!visitedStates.contains(currentNode.getState()))
				filteredNodes.add(currentNode);
		}
		return filteredNodes;
	}
	
	public static ArrayList<SearchNode> filterExpandedNodesByDepth(ArrayList<SearchNode> expandedNodes, int depth){
		ArrayList<SearchNode> filteredNodes = new ArrayList<>();
		Iterator<SearchNode> i = expandedNodes.iterator();
		while(i.hasNext()){
			SearchNode currentNode = i.next();
			if(currentNode.getDepth()<=depth)
				filteredNodes.add(currentNode);
		}
		return filteredNodes;
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
	
	private Solution BestFirstSearch(SearchProblem searchProblem, Comparator<SearchNode> EvalFun){
		return search(searchProblem,new OrderedInsert(EvalFun));
	}
	
	public Solution greedySearch(SearchProblem searchProblem){
		Comparator<SearchNode> EvalFun = new Comparator<SearchNode>() {

			@Override
			public int compare(SearchNode n1, SearchNode n2) {
				return n1.getPredictedCost()-n2.getPredictedCost();
			}
			
		};
		return BestFirstSearch(searchProblem, EvalFun);
	}
	
	public Solution AStarSearch(SearchProblem searchProblem){
		Comparator<SearchNode> EvalFun = new Comparator<SearchNode>() {

			@Override
			public int compare(SearchNode n1, SearchNode n2) {
				return (n1.getPredictedCost()+n1.getPathCost())-(n2.getPredictedCost()+n2.getPathCost());
			}
			
		};
		return BestFirstSearch(searchProblem, EvalFun);
	}
}
