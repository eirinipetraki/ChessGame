package Core;




/**
 * A square of a chess board.
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
public class Square 
{
	private int x;
	private int y;
	private Color color;
	private Piece piece;
	
	
	/**
	 * Creates a square of a chess board.
	 * 
	 * @category Constructor.
	 * 
	 * @Preconditions (x >= 0) && (y >= 0).
	 * @Postconditions None.
	 * 
	 * @param x
	 * @param y
	 */
	public Square (int x, int y)
	{
		if (x < 0 || y < 0)
			throw new IllegalArgumentException();
		
		this.x = x;
		
		this.y = y;
		System.out.println("Square"+this.x+this.y);
//		TODO We reversed colors
		this.color = (this.x + this.y)%2 == 0? Color.white: Color.black;
		this.piece = null;
		
		//Invariant asserts.
		this.checkInvariant();
	}
	
	
	/**
	 * Returns the abscissa of this square.
	 * 
	 * @category Getter.
	 * 
	 * @Preconditions None.
	 * @Postconditions None.
	 * 
	 * @return
	 */
	public int getX()
	{
		return this.x;
	}
	
	
	/**
	 * Returns the ordinate of this square.
	 * 
	 * @category Getter.
	 * 
	 * @Preconditions None.
	 * @Postconditions None.
	 * 
	 * @return
	 */
	public int getY()
	{
		return this.y;
	}
	
	
	/**
	 * Returns the color of this square.
	 * 
	 * @category Getter.
	 * 
	 * @Preconditions None.
	 * @Postconditions None.
	 * 
	 * @return
	 */
	public Color getColor()
	{
		return this.color;
	}
	
	
	/**
	 * Returns the piece that rest in this square.
	 * 
	 * @category Getter.
	 * 
	 * @return the piece that rest in this square.
	 */
	public Piece getPiece()
	{
		return this.piece;
	}
	
	
	/**
	 * Sets the piece that rests in this square.
	 * 
	 * @category Setter.
	 * 
	 * @param p the piece.
	 */
	public void setPiece(Piece p)
	{
		this.piece = p;
	}
	
	/**
	 * Returns true if this square is occupied by a piece.
	 * 
	 * @category Checker.
	 * 
	 * @Preconditions None.
	 * @Postconditions None.
	 * 
	 * @return
	 */
	public boolean hasPiece()
	{
		return this.piece == null ? false : true;
	}
	
//	public boolean isValid()
//	{
//		
//	}
	
	/**
	 * Checks the Invariants.
	 * 
	 * @Invariants x >= 0 && y >= 0 && color instanceof Color. 
	 */
	private void checkInvariant()
	{
		assert(this.x >= 0);
		assert(this.y >= 0);
		assert(this.color instanceof Color);
	}
	
	public String toString()
	{
		return (this.x + "," + this.y );
		
	}
}
