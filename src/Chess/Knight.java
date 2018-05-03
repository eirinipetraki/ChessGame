package Chess;

import java.util.Vector;

import Core.Color;
import Core.Piece;
import Core.Square;

/**
 * The Knight.
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
public class Knight extends Piece {
	Vector <Square>tmp=new Vector<Square>();
	private static String getImgPath(Color c){
		return (c == Color.white) ? "wknighte" : "bknighte";
	}
	/**
	 * Creates a knight.
	 * 
	 * @category Constructor
	 * 
	 * @param c The Color of the knight.
	 * @param s The Square of the knight.
	 */
	public Knight(Color c, Square s) {
		super(c, s, getImgPath(c));
	}
	
	
	/**
	 * Returns all the probable moves of the knight.
	 *  
	 * @category Accessor. 
	 * 
	 * @return a vector with all the probable moves of the knight.
	 */
	private void probablyMoves(){
		//1
		
		
		if((this.getSquare().getX()+1)<8 && (this.getSquare().getX()+1)>=0 && (this.getSquare().getY()+2)<8 && (this.getSquare().getY()+2)>=0){
			
			tmp.add(Chess.getBoard().getSquare(this.getSquare().getX()+1,this.getSquare().getY()+2));
		}
		//2
		if((this.getSquare().getX()+2)<8&& (this.getSquare().getX()+2)>=0 && (this.getSquare().getY()+1)<8 && (this.getSquare().getY()+1)>=0){
			
			tmp.add(Chess.getBoard().getSquare(this.getSquare().getX()+2,this.getSquare().getY()+1));
		}
		//3
		if((this.getSquare().getX()+1)<8 && (this.getSquare().getX()+1)>=0 && (this.getSquare().getY()-2)<8 && (this.getSquare().getY()-2)>=0){
		
			tmp.add(Chess.getBoard().getSquare(this.getSquare().getX()+1,this.getSquare().getY()-2));
		}
		//4
		if((this.getSquare().getX()+2)<8&& (this.getSquare().getX()+2)>=0 && (this.getSquare().getY()-1)<8 && (this.getSquare().getY()-1)>=0){
			
			tmp.add(Chess.getBoard().getSquare(this.getSquare().getX()+2,this.getSquare().getY()-1));
		}
		//5
		if((this.getSquare().getX()-1)<8&& (this.getSquare().getX()-1)>=0 && (this.getSquare().getY()+2)<8 && (this.getSquare().getY()+2)>=0){
			
			tmp.add(Chess.getBoard().getSquare(this.getSquare().getX()-1,this.getSquare().getY()+2));
		}
		//6
		if((this.getSquare().getX()-2)<8&& (this.getSquare().getX()-2)>=0 && (this.getSquare().getY()+1)<8 && (this.getSquare().getY()+1)>=0){
			
			tmp.add(Chess.getBoard().getSquare(this.getSquare().getX()-2,this.getSquare().getY()+1));
		}
		//8
		if((this.getSquare().getX()-1)<8&& (this.getSquare().getX()-1)>=0 && (this.getSquare().getY()-2)<8 && (this.getSquare().getY()-2)>=0){
			
			tmp.add(Chess.getBoard().getSquare(this.getSquare().getX()-1,this.getSquare().getY()-2));
		}
		//8
		if((this.getSquare().getX()-2)<8&& (this.getSquare().getX()-2)>=0 && (this.getSquare().getY()-1)<8 && (this.getSquare().getY()-1)>=0){
			
			tmp.add(Chess.getBoard().getSquare(this.getSquare().getX()-2,this.getSquare().getY()-1));
		}
		
	}
	
	
	/**
	 * Returns all the allowed moves of the knight.
	 *  
	 * @category Accessor. 
	 * 
	 * @return a vector with all the allowed moves of the knight.
	 */
	public Vector<Square> allowedMoves() {
		Vector<Square> allowmoves=new Vector<Square>();
		probablyMoves();
		for(int i=0;i<tmp.size();i++){
		if(tmp.elementAt(i).hasPiece()== false){
			allowmoves.add(tmp.elementAt(i));
			
		}
		else if (tmp.elementAt(i).getPiece().getColor()==this.getColor())
			continue;
		else allowmoves.add(tmp.elementAt(i));
		}
		tmp.clear();
		return allowmoves;
	}

	
	/**
	 * Returns all the threaten squares of the knight.
	 *  
	 * @category Accessor. 
	 * 
	 * @return a vector with all the threaten squares of the knight.
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
