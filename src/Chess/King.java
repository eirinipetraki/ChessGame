package Chess;

import java.util.Vector;

import Core.Color;
import Core.Piece;
import Core.Square;

/**
 * The King.
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
public class King extends Piece 
{
	Vector <Square>tmp=new Vector<Square>();
	
	private static String getImgPath(Color c){
		return (c == Color.white) ? "wking" : "bking";
	}
	/**
	 * Creates a king.
	 * 
	 * @category Constructor
	 * 
	 * @param c The Color of the king.
	 * @param s The Square of the king.
	 */
	public King(Color c, Square s) 
	{
		super(c, s, getImgPath(c));
	}
	
	
	/**
	 * Returns all the probable moves of the king.
	 *  
	 * @category Accessor. 
	 * 
	 * @return a vector with all the probable moves of the king.
	 */
	private void probablyMoves()
	{
		tmp.clear();
		
		//de3ia
		if(this.getSquare().getY()+1 < 8 ){
			tmp.add(Chess.getBoard().getSquare(this.getSquare().getX(),this.getSquare().getY()+1));
		}
		//katw de3ia
		if(this.getSquare().getX()+1 < 8 && this.getSquare().getY()+1 < 8){
			tmp.add(Chess.getBoard().getSquare(this.getSquare().getX()+1,this.getSquare().getY()+1));
		}
		//katw
		if(this.getSquare().getX()+1 < 8 ){
			tmp.add(Chess.getBoard().getSquare(this.getSquare().getX()+1,this.getSquare().getY()));
		}
		//katw aristera
		if(this.getSquare().getX()+1 <8 && this.getSquare().getY()-1 >= 0){
			tmp.add(Chess.getBoard().getSquare(this.getSquare().getX()+1,this.getSquare().getY()-1));
		}
		//panw
		if( this.getSquare().getY()-1 >= 0){
			tmp.add(Chess.getBoard().getSquare(this.getSquare().getX(),this.getSquare().getY()-1));
		}
		//panw aristera
		if(this.getSquare().getX()-1 >= 0 && this.getSquare().getY()-1 >= 0){
			tmp.add(Chess.getBoard().getSquare(this.getSquare().getX()-1,this.getSquare().getY()-1));
		}
		//aristera
		if(this.getSquare().getX()-1 >= 0 ){
			tmp.add(Chess.getBoard().getSquare(this.getSquare().getX()-1,this.getSquare().getY()));
		}
		//panw de3ia
		if(this.getSquare().getX()-1 >= 0 && this.getSquare().getY()+1 < 8){
			tmp.add(Chess.getBoard().getSquare(this.getSquare().getX()-1,this.getSquare().getY()+1));
		}
		
	}
	
	
	/**
	 * Returns all the allowed moves of the king.
	 *  
	 * @category Accessor. 
	 * 
	 * @return a vector with all the allowed moves of the king.
	 */
	public Vector<Square> allowedMoves() {
		Vector<Square> allowmoves=new Vector<Square>();
		probablyMoves();
		for(int i=0;i<tmp.size();i++){
			if(!tmp.elementAt(i).hasPiece())
				allowmoves.add(tmp.elementAt(i));
			else if(tmp.elementAt(i).getPiece().getColor() == this.getColor())
				continue;
			else
				allowmoves.add(tmp.elementAt(i));
		}
		
		System.out.println(tmp.toString());
		System.out.println(allowmoves.toString());
		
		return allowmoves;
	}

	
	/**
	 * Returns all the threaten squares of the king.
	 *  
	 * @category Accessor. 
	 * 
	 * @return a vector with all the threaten squares of the king.
	 */
	public Vector<Square> threatenSquares() {
		Vector<Square> threatenSquares=new Vector<Square>();
		probablyMoves();
		for(int i=0;i<tmp.size();i++){
		if(tmp.elementAt(i).hasPiece()== true && tmp.elementAt(i).getPiece().getColor()!= this.getColor() ){
			threatenSquares.add(tmp.elementAt(i));
		}
		}
		return threatenSquares;
	}


}
