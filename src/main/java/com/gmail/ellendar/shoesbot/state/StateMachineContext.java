package com.gmail.ellendar.shoesbot.state;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * The bot's running context
 * @author jgill
 *
 */
public class StateMachineContext {
	
	private final Queue<String> inputQueue = new ArrayBlockingQueue<String>(100);
	
	private ScreenState screenState = null;	//screen state
	
	/**
	 * Get the screen state, refreshing if neccessary. 
	 * The scraping operation is very likely to be expensive, so delay querying the screen state until strictly neccessary.
	 * @param refresh the state will be refreshed iff true or the state has never been loaded.
	 * @return the current screenState
	 */
	public ScreenState getScreenState(boolean refresh) {
		if(screenState == null || refresh) {
			screenState = new ScreenState();
		}
		return screenState;
	}
	
	public ScreenState getScreenState() {
		return getScreenState(false);
	}
	
	public Queue<String> getInputQueue() {
		return inputQueue;
	}
	
}
