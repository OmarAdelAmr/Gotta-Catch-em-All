package catch_em;

import elements.Operator;
import elements.State;
import maze.MainEngine;

public class MoveBackwardOperator extends Operator {
	public MoveBackwardOperator(int cost) {
		super(cost);
	}

	@Override
	public State getNextState(State state) {
		return MainEngine.moveBackward(state);
	}
}
