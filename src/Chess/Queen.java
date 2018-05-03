package Chess;

import java.util.Vector;

import Core.Color;
import Core.Piece;
import Core.Square;

/**
 * The Queen.
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
public class Queen extends Piece {
	Vector<Square> tmp=new Vector<Square>();
	private static String getImgPath(Color c){
		return (c == Color.white) ? "wqueen" : "bqueen";
	}
	/**
	 * Creates a queen.
	 * 
	 * @category Constructor
	 * 
	 * @param c The Color of the queen.
	 * @param s The Square of the queen.
	 */
	public Queen(Color c, Square s) {
		super(c, s, getImgPath(c));
	}
	

	/**
	 * Returns all the probable moves of the queen.
	 *  
	 * @category Accessor. 
	 * 
	 * @return a vector with all the probable moves of the queen.
	 */
	private void probablyMoves(){
		tmp.clear();
		//panw-katw
		for(int i=this.getSquare().getY()+1;i<8;i++){
			if(!Chess.getBoard().getSquare(this.getSquare().getX(),i).hasPiece())
				tmp.add(Chess.getBoard().getSquare(this.getSquare().getX(),i));
			else if(Chess.getBoard().getSquare(this.getSquare().getX(),i).getPiece().getColor()==this.getColor())
				break;
			else{
				tmp.add(Chess.getBoard().getSquare(this.getSquare().getX(),i));
				break;
			
			}
		}
		for(int i=this.getSquare().getY()-1;i>=0;i--){
			if(!Chess.getBoard().getSquare(this.getSquare().getX(),i).hasPiece())
				tmp.add(Chess.getBoard().getSquare(this.getSquare().getX(),i));
			else if(Chess.getBoard().getSquare(this.getSquare().getX(),i).getPiece().getColor()==this.getColor())
				break;
			else{
				tmp.add(Chess.getBoard().getSquare(this.getSquare().getX(),i));
				break;
			
			}
		}
		//deksia-aristera
		for(int i=this.getSquare().getX()+1;i<8;i++){
				if(!Chess.getBoard().getSquare(i,this.getSquare().getY()).hasPiece())
					tmp.add(Chess.getBoard().getSquare(i,this.getSquare().getY()));
				else if(Chess.getBoard().getSquare(i,this.getSquare().getY()).getPiece().getColor()==this.getColor())
					break;
				else{
					tmp.add(Chess.getBoard().getSquare(i,this.getSquare().getY()));
					break;
				
				}
		}
		for(int i=this.getSquare().getX()-1;i>=0;i--){
			if(!Chess.getBoard().getSquare(i,this.getSquare().getY()).hasPiece())
				tmp.add(Chess.getBoard().getSquare(i,this.getSquare().getY()));
			else if(Chess.getBoard().getSquare(i,this.getSquare().getY()).getPiece().getColor()==this.getColor())
				break;
			else{
				tmp.add(Chess.getBoard().getSquare(i,this.getSquare().getY()));
				break;
			}
		}
		//deksia-diagonia
		for(int i=this.getSquare().getX()+1, j=this.getSquare().getY()+1;i<8 && i>=0 
		&&j>=0 &&j<6;i++,j++){
			if(!Chess.getBoard().getSquare(i,j).hasPiece())
				tmp.add(Chess.getBoard().getSquare(i,j));
			else if(Chess.getBoard().getSquare(i,j).getPiece().getColor()==this.getColor())
				break;
			else{
				tmp.add(Chess.getBoard().getSquare(i,j));
				break;
			}
		}
		for(int i=this.getSquare().getX()+1, j=this.getSquare().getY()-1;i>=0 && i<8 && j<8 && j>=0;i++,j--){
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
		for(int i=this.getSquare().getX()-1, j=this.getSquare().getY()+1;i>=0 && i<8 && j>=0 && j<8;i--,j++){
			if(!Chess.getBoard().getSquare(i,j).hasPiece())
				tmp.add(Chess.getBoard().getSquare(i,j));
			else if(Chess.getBoard().getSquare(i,j).getPiece().getColor()==this.getColor())
				break;
			else{
				tmp.add(Chess.getBoard().getSquare(i,j));
				break;
			}
		}
		for(int i=this.getSquare().getX()-1, j=this.getSquare().getY()-1;i>=0 && i<8 && j>=0 && j<8;i--,j--){
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
	 * Returns all the allowed moves of the queen.
	 *  
	 * @category Accessor. 
	 * 
	 * @return a vector with all the allowed moves of the queen.
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
	 * Returns all the threaten squares of the queen.
	 *  
	 * @category Accessor. 
	 * 
	 * @return a vector with all the threaten squares of the queen.
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
