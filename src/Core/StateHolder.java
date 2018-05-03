package Core;

import java.util.LinkedList;

import Chess.Chess;
import Main.GameMaster;


/**
 * Keeps the current state of the board.
 * 
 * @Course CS-252: Object Oriented Programming.
 * 
 * @Assignment Chess Project.
 * 
 * @Date December 2008.
 * 
 * @author Despotakis Christos (1910)<br />
 * Petraki Eirinh (1888)<br />
 * Computer Science Depart.<br />
 * University Of Crete
 *
 */
public class StateHolder 
{
	private Board currentState;
	
	private LinkedList<Board> history;
	private LinkedList<Board> future;
	
	
	/**
	 * Creates a new StateHolder.
	 * 
	 * @category Constructor.
	 */
	public StateHolder()
	{
		this.currentState = new Board();
		this.history = new LinkedList<Board>();
		this.future = new LinkedList<Board>();
	}
	
	
	/**
	 * Push $currentState to $history.
	 * 
	 * @category Transformer.
	 */
	public void setHistory()
	{
		this.history.push(currentState);
	}
	
	public LinkedList<Board> getHistory()
	{
		return this.history;
	}
	
	
	public LinkedList<Board> getFuture()
	{
		return this.future;
	}
	
	/**
	 * Updates $currentState
	 * 
	 * @category Transformer.
	 */
	public void setStateHolder()
	{
		this.currentState = Chess.board;
	}
	
	
	/**
	 * Returns the currentState of the board.
	 * 
	 * @category Getter.
	 * 
	 * @return the currentState of the board.
	 */
	public Board getStateHolder()
	{
		return this.currentState;
	}
	
	
	/**
	 * Sets $currentState to the previous one.
	 * 
	 * @category Transformer.
	 */
	public void goBack()
	{
		this.future.push(currentState);
		this.currentState = this.history.pop();
	}
	
	
	/**
	 * Sets $currentState to the next one.
	 * 
	 * @category Transformer.
	 */
	public void goForwards()
	{
		this.history.push(currentState);
		this.currentState = this.future.pop();
	}
}
