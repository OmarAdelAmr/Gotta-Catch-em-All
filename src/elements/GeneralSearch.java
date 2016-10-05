package elements;

import java.util.Queue;

public class GeneralSearch {
	
	QingFun qingFun;
	SearchProblem searchProblem;
	public GeneralSearch(SearchProblem searchProblem, QingFun qingFun) {
		super();
		this.searchProblem = searchProblem;
		this.qingFun = qingFun;
	}
	
	public Solution search(){
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
	
}
