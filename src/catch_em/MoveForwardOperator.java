package catch_em;

import elements.Operator;
import elements.State;
import maze.MainEngine;

public class MoveForwardOperator extends Operator {
	
	
	public MoveForwardOperator(int cost) {
		super(cost);
	}

	@Override
	public State getNextState(State state) {
		return MainEngine.moveForward(state);
	}
	
}
