package com.gmail.ellendar.shoesbot.state;

import java.util.Queue;

import org.slf4j.Logger;

import com.gmail.ellendar.NotImplementedException;

/**
 * State machine base class.
 * @author jgill
 *
 */
public abstract class State {
	/**
	 * Reads available input from the input queue and screen until either no data is available or a state transition happens.
	 * @return The new state of the machine.
	 */
	public State pump(StateMachineContext context) {
		Logger logger = getLogger();
		
		logger.info("Pumping state");
		
		Queue<String> inputQueue = context.getInputQueue();
		State nextState = this;
		String input = inputQueue.poll();
		//until the queue is empty or we've transitioned states
		while(input != null && nextState == this) {
			nextState = transition(context.getScreenState(), input);
		}
		
		if(nextState == null) {
			logger.error("Transition function returned a null transition state");
			
			//TODO: Panic
			throw new NotImplementedException();
		}
		
		return nextState;
	}
	
	/**
	 * Determines if the machine should transition to a new state. 
	 * If yes, execute state transition code and return the new state.
	 * If no, return this.
	 * This method MUST return a non-null state, otherwise the machine will sieze.
	 * @param screenState
	 * @param input
	 * @return
	 */
	public abstract State transition(ScreenState screenState, String input);
	
	public abstract Logger getLogger();
	
	public abstract String getName();
	
	@Override
	public String toString() {
		//TODO: Improve
		return getName();
	}
}
