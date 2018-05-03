package Chess;

import java.util.Vector;

import Core.Color;
import Core.Piece;
import Core.Square;


/**
 * The Bishop.
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
public class Bishop extends Piece {
Vector <Square> tmp = new Vector <Square>();
	
	private static String getImgPath(Color c){
		return (c == Color.white) ? "wbishop" : "bbishop";
	}
	/**
	 * Creates a bishop.
	 * 
	 * @category Constructor
	 * 
	 * @param c The Color of the bishop.
	 * @param s The Square of the bishop.
	 */
	public Bishop(Color c, Square s) {
		super(c, s, getImgPath(c));
	}
	

	
	
	
	/**
	 * Returns all the probable moves of the bishop.
	 *  
	 * @category Accessor. 
	 * 
	 * @return a vector with all the probable moves of the bishop.
	 */
	private void probablyMoves(){
		tmp.clear();
		//deksia-diagonia
		for(int i=this.getSquare().getX()+1, j=this.getSquare().getY()+1;i<8 && i>=0
		&&j>=0 &&j<8;i++,j++){
			if(!Chess.getBoard().getSquare(i,j).hasPiece())
				tmp.add(Chess.getBoard().getSquare(i,j));
			else if(Chess.getBoard().getSquare(i,j).getPiece().getColor()==this.getColor())
				break;
			else{
				tmp.add(Chess.getBoard().getSquare(i,j));
				break;
			}
		}
		for(int i=this.getSquare().getX()+1, j=this.getSquare().getY()-1;i>=0&& i<8 && j<8 && j>=0;i++,j--){
			if(!Chess.getBoard().getSquare(i,j).hasPiece())
				tmp.add(Chess.getBoard().getSquare(i,j));
			else if(Chess.getBoard().getSquare(i,j).getPiece().getColor()==this.getColor())
				break;
			else{
				tmp.add(Chess.getBoard().getSquare(i,j));
				break;
			}
			
		}
		//aristera-diagonio
		for(int i=this.getSquare().getX()-1, j=this.getSquare().getY()+1;i>=0&& i<8 && j>=0&& j<8;i--,j++){
			if(!Chess.getBoard().getSquare(i,j).hasPiece())
				tmp.add(Chess.getBoard().getSquare(i,j));
			else if(Chess.getBoard().getSquare(i,j).getPiece().getColor()==this.getColor())
				break;
			else{
				tmp.add(Chess.getBoard().getSquare(i,j));
				break;
			}
		}
		for(int i=this.getSquare().getX()-1, j=this.getSquare().getY()-1;i>=0&& i<8 && j>=0&& j<8;i--,j--){
			if(!Chess.getBoard().getSquare(i,j).hasPiece())
				tmp.add(Chess.getBoard().getSquare(i,j));
			else if(Chess.getBoard().getSquare(i,j).getPiece().getColor()==this.getColor())
				break;
			else{
				tmp.add(Chess.getBoard().getSquare(i,j));
				break;
			}
		}
		
	}
	
	
	/**
	 * Returns all the allowed moves of the bishop.
	 *  
	 * @category Accessor. 
	 * 
	 * @return a vector with all the allowed moves of the bishop.
	 */
	public Vector<Square> allowedMoves() {
		Vector<Square> allowmoves=new Vector<Square>();
		probablyMoves();
		for(int i=0;i<tmp.size();i++){
		
			allowmoves.add(tmp.elementAt(i));
			
		}
		System.out.println(tmp.toString());
		System.out.println(allowmoves.toString());
		
		return allowmoves;
	}

	
	/**
	 * Returns all the threaten squares of the bishop.
	 *  
	 * @category Accessor. 
	 * 
	 * @return a vector with all the threaten squares of the bishop.
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


