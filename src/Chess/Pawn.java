package Chess;

import java.util.Vector;

import javax.swing.ImageIcon;

import Core.Board;
import Core.Color;
import Core.Piece;
import Core.Square;

/**
 * The Pawn.
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
public class Pawn extends Piece {
	Vector <Square> tmp = new Vector <Square>();
	
	private static String getImgPath(Color c){
		return (c == Color.white) ? "wpawn" : "bpawn";
	}
	/**
	 * Creates a pawn.
	 * 
	 * @category Constructor
	 * 
	 * @param c The Color of the pawn.
	 * @param s The Square of the pawn.
	 */
	public Pawn(Color c, Square s) {
		super(c, s, getImgPath(c));
	}
	
	
	/**
	 * Returns all the probable moves of the pawn.
	 *  
	 * @category Accessor. 
	 * 
	 * @return a vector with all the probable moves of the pawn.
	 */
	private  Vector <Square> probablyMoves() {
		
		tmp.clear();
		
		int cases = 0;
		if(this.getColor()==Color.white){
			cases=1;
			if(this.hasMoved()==true){ cases=2;}
		}
		if(this.getColor()== Color.black){
			cases=3;
			if(this.hasMoved()==true){ cases=4;}
		}
		switch(cases)
		{
			case 1:	//white not moved
			{				
				for(int i=1;i<=2;i++)
				{
					if (Chess.board.getSquare(this.getSquare().getX() - i,this.getSquare().getY()).hasPiece() == false)
						tmp.add(Chess.board.getSquare(this.getSquare().getX() - i,this.getSquare().getY()));
					else
						break;
				}
				
				movesforCapture();
				break;	
			}
			case 2:	//white moved
			{
				if (Chess.board.getSquare(this.getSquare().getX() - 1,this.getSquare().getY()).hasPiece() == false)
					tmp.add(Chess.board.getSquare(this.getSquare().getX()-1,this.getSquare().getY()));
				
				movesforCapture();
				break;
			}
			case 3:	//black not moved
			{		
				for(int i=1;i<=2;i++)
				{
					if (Chess.board.getSquare(this.getSquare().getX()+i,this.getSquare().getY()).hasPiece() == false)
						tmp.add(Chess.board.getSquare(this.getSquare().getX()+i,this.getSquare().getY()));
					else
						break;
				}
				
				movesforCapture();
				break;
			}
			case 4:	//black moved
			{
				
				if (Chess.board.getSquare(this.getSquare().getX()+1,this.getSquare().getY()).hasPiece() == false)
					tmp.add(Chess.board.getSquare(this.getSquare().getX()+1,this.getSquare().getY()));
				
				movesforCapture();
				break;	
			}
		}
		System.out.println("probably["+tmp.toString()+"]\n");
		return tmp;

	}
	
	/**
	 * @category Accessor
	 * show the moves of pawn for capture....can used in specialmoves.capture();
	 */
	private void movesforCapture(){
		if(this.getColor()==Color.white)
		{
			
			if (this.getSquare().getY() == 0)
			{
				if(Chess.board.getSquare(this.getSquare().getX()-1,this.getSquare().getY()+1).hasPiece() && Chess.board.getSquare(this.getSquare().getX()-1,this.getSquare().getY()+1).getPiece().getColor()==Color.black)
					tmp.add(Chess.board.getSquare(this.getSquare().getX()-1,this.getSquare().getY()+1));
			}
			else if (this.getSquare().getY() == 7)
			{
				if(Chess.board.getSquare(this.getSquare().getX()-1,this.getSquare().getY()-1).hasPiece() && Chess.board.getSquare(this.getSquare().getX()-1,this.getSquare().getY()-1).getPiece().getColor()==Color.black)
					tmp.add(Chess.board.getSquare(this.getSquare().getX()-1,this.getSquare().getY()-1));
			}
			else
			{
				if(Chess.board.getSquare(this.getSquare().getX()-1,this.getSquare().getY()+1).hasPiece() &&	Chess.board.getSquare(this.getSquare().getX()-1,this.getSquare().getY()+1).getPiece().getColor()==Color.black)
					tmp.add(Chess.board.getSquare(this.getSquare().getX()-1,this.getSquare().getY()+1));
				
				if(Chess.board.getSquare(this.getSquare().getX()-1,this.getSquare().getY()-1).hasPiece() && Chess.board.getSquare(this.getSquare().getX()-1,this.getSquare().getY()-1).getPiece().getColor()==Color.black)
					tmp.add(Chess.board.getSquare(this.getSquare().getX()-1,this.getSquare().getY()-1));
			}			
		}
		
		if(this.getColor()==Color.black)
		{
			if (this.getSquare().getY() == 0)
			{
				if(Chess.board.getSquare(this.getSquare().getX()+1,this.getSquare().getY()+1).hasPiece() && Chess.board.getSquare(this.getSquare().getX()+1,this.getSquare().getY()+1).getPiece().getColor()==Color.white)
					tmp.add(Chess.board.getSquare(this.getSquare().getX()+1,this.getSquare().getY()+1));
			}
			else if (this.getSquare().getY() == 7)
			{
				if(Chess.board.getSquare(this.getSquare().getX()+1,this.getSquare().getY()-1).hasPiece() && Chess.board.getSquare(this.getSquare().getX()+1,this.getSquare().getY()-1).getPiece().getColor()==Color.white)
					tmp.add(Chess.board.getSquare(this.getSquare().getX()+1,this.getSquare().getY()-1));
			}
			else
			{
				if(Chess.board.getSquare(this.getSquare().getX()+1,this.getSquare().getY()-1).hasPiece() && Chess.board.getSquare(this.getSquare().getX()+1,this.getSquare().getY()-1).getPiece().getColor()==Color.white)
					tmp.add(Chess.board.getSquare(this.getSquare().getX()+1,this.getSquare().getY()-1));
				
				if(Chess.board.getSquare(this.getSquare().getX()+1,this.getSquare().getY()+1).hasPiece() && Chess.board.getSquare(this.getSquare().getX()+1,this.getSquare().getY()+1).getPiece().getColor()==Color.white)
					tmp.add(Chess.board.getSquare(this.getSquare().getX()+1,this.getSquare().getY()+1));
			}
		}
	}
	

	/**
	 * Returns all the allowed moves of the pawn.
	 *  
	 * @category Accessor. 
	 * 
	 * @return a vector with all the allowed moves of the pawn.
	 */
	// auta pou 8a fotizoun san pi8anes kiniseis
	public Vector<Square> allowedMoves() {
			Vector<Square> allowmoves=new Vector<Square>();
			probablyMoves();

			allowmoves = tmp;

			return allowmoves;
	}

	
	/**
	 * Returns all the threaten squares of the pawn.
	 *  
	 * @category Accessor. 
	 * 
	 * @return a vector with all the threaten squares of the pawn.
	 */
	public Vector<Square> threatenSquares() {
		Vector<Square> threatenSquares=new Vector<Square>();
		movesforCapture();
		for(int i=0;i<tmp.size();i++){
			if(tmp.elementAt(i).hasPiece()== true && tmp.elementAt(i).getPiece().getColor()!= this.getColor() ){
				threatenSquares.add(tmp.elementAt(i));
			}
		}
		return threatenSquares;
	}
}
