package catch_em;

import elements.Operator;
import elements.State;
import maze.MainEngine;

public class MoveLeftOperator extends Operator{
	public MoveLeftOperator(int cost) {
		super(cost);
	}

	@Override
	public State getNextState(State state) {
		return MainEngine.moveLeft(state);
	}
}
