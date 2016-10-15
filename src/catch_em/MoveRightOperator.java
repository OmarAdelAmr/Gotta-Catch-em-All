package catch_em;

import elements.Operator;
import elements.State;
import maze.MainEngine;

public class MoveRightOperator extends Operator {
	public MoveRightOperator(int cost) {
		super(cost);
	}

	@Override
	public State getNextState(State state) {
		return MainEngine.moveRight(state);
	}
}
