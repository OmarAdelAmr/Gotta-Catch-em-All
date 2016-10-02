package elements;

import java.util.ArrayList;

public abstract class SearchProblem {
	ArrayList<Operator> operators;
	State initialState;
	ArrayList<State> stateSpace;
	public abstract boolean goalTest(State state);
	public abstract int pathCost(State state);
}
