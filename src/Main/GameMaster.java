package Main;

import Core.Color;
import Core.Board;
import Core.Square;
import Core.StateHolder;


/**
 * The main interface of every board game, played at a chessboard.
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
public interface GameMaster 
{
	
	/**
	 * Initialize the chess board.
	 */
	public void initialize();
	
	/**
	 * Go a move back in history.
	 */
	public void undo();
	/**
	 * Go a move forward to the future.
	 */
	public void redo();
	
	/**
	 * Move fron $px,$py to $nx,$ny.
	 * @param px Old abscissa.
	 * @param py Old ordinate.
	 * @param nx New abscissa.
	 * @param ny New ordinate.
	 */
	public void move(int px,int py,int nx,int ny);
	public void castle();
	public void capture(int px,int py,int nx,int ny);
	public void promote(int nx,int ny,Color c);
	
	
	public boolean saxCheck(int nx,int ny);
	public boolean matCheck(Square st);
	public boolean  eqCheck();
	
	
	public void changePlayer();
	
	public Square select();
	public void deselect();
	
	public boolean hasEnded();
	
}
