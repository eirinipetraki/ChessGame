package Core;

import java.util.Vector;

import Chess.Chess;
import Main.GameMaster;



/**
 * An 8 by 8 squares chess board.
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
public class Board 
{
	private static final int ROWS = 8;
	private static final int LINES = 8;
	
	private Square[][] Board = new Square[LINES][ROWS];
	
	
	/**
	 * Creates an 8 by 8 square chess board.
	 * 
	 * @category Constructor.
	 * 
	 * @Preconditions None.
	 * @Postconditions None.
	 * @Invariants board[].length == LINES && board.length == ROWS && board[][] instanceof Square.  
	 */
	public Board()
	{
		for (int x = 0 ; x < LINES; x++ ){
			for (int y = 0; y < ROWS; y++){
				this.Board[x][y] = new Square(x, y);
				
			}
		}
//				We reversed x , y

		// Invariant asserts.
		this.checkInvariant();
	}
	
	
	/**
	 * Returns the square with $abscissa and $ordinate.
	 * 
	 * @category Getter.
	 * 
	 * @Preconditions (0 <= $abscissa < 8) && (0 <= $ordinate < 8).
	 * @Postconditions None.
	 * @Invariants board[].length == LINES && board.length == ROWS && board[][] instanceof Square. 
	 * 
	 * @param abscissa
	 * @param ordinate
	 * @return
	 */
	public Square getSquare(int x, int y)
	{
		//Precondition checking.		
		if (x < 0 || x > 8 || y < 0 || y > 8)
			throw new IllegalArgumentException();
		
		return this.Board[x][y];
	}
	
	
	/**
	 * Returns all the pieces that on the board.
	 * 
	 * @category Accessor.
	 * 
	 * @return a vector with all the pieces that on the board.
	 */
	public Vector<Piece> pieceonBoard(){
		Vector <Piece> pieces=new Vector <Piece>();
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(Chess.getBoard().getSquare(i, j).hasPiece()){
					pieces.add((Piece) Chess.getBoard().getSquare(i, j).getPiece());
					
				}
			}
		}
		return pieces;
	}
	
	
	
	/**
	 * Checks the Invariants.
	 * 
	 * @Invariants board[].length == LINES && board.length == ROWS && board[][] instanceof Square. 
	 */
	private void checkInvariant()
	{
		assert(this.Board.length == ROWS);
		for (int i = 0; i < ROWS; ++i)
		{
			assert(this.Board[i].length == LINES);
			for (int j = 0; j < LINES; ++j)
				assert(this.Board[i][j] instanceof Square);
		}
	}
	
}
