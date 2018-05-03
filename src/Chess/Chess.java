package Chess;


import javax.swing.JOptionPane;

import Core.*;
import Main.GameMaster;



/**
 * The implementation for the 
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
public class Chess implements GameMaster
{

	public Player player1 = new Player(null, Color.white);
	public Player player2 = new Player("Player 2", Color.black);
	public Player activePlayer;
	private Player lastPlayer=null;

	private Square st=null,tmp=null;

	protected boolean lastMoveWasSax = false;

	private Rook blackRook1, blackRook2, whiteRook1, whiteRook2;
	private Knight blackKnight1, blackKnight2, whiteKnight1, whiteKnight2;
	private Bishop blackBishop1, blackBishop2, whiteBishop1, whiteBishop2;
	private Queen blackQueen, whiteQueen;
	private King blackKing, whiteKing;
	private Pawn blackPawn1, blackPawn2, blackPawn3, blackPawn4, blackPawn5, blackPawn6, blackPawn7, blackPawn8, whitePawn1, whitePawn2, whitePawn3, whitePawn4, whitePawn5, whitePawn6, whitePawn7, whitePawn8;


	public static Board board;
	public static StateHolder state;

	public Chess()
	{

		board = new Board();

		state = new StateHolder();
		activePlayer = player1;
	}

	/**
	 * Return the current board.
	 * 
	 * @category Getter
	 * 
	 * @return the current board.
	 */
	public static Board getBoard()
	{
		return board;
	}


	/**
	 * Check if the game finish.
	 * 
	 * @category Accessor.
	 * 
	 *  @return true if the game finished, else false
	 */
	public boolean hasEnded() {
		// TODO Auto-generated method stub
		return false;
	}


	/**
	 * Initialize the pieces in the board
	 * @category Transformer
	 */
	public void initialize() 
	{
		blackRook1 = new Rook(Color.black, board.getSquare(0, 0));

		blackKnight1 = new Knight (Color.black, board.getSquare(0,1));

		blackBishop1 = new Bishop (Color.black, board.getSquare(0, 2));
		blackQueen = new Queen (Color.black, board.getSquare(0, 3));
		blackKing = new King (Color.black, board.getSquare(0, 4));
		blackBishop2 = new Bishop (Color.black, board.getSquare(0, 5));
		blackKnight2 = new Knight (Color.black, board.getSquare(0, 6));
		blackRook2 = new Rook(Color.black, board.getSquare(0, 7));




		whiteRook1 = new Rook(Color.white, board.getSquare(7, 0));
		whiteKnight1 = new Knight (Color.white, board.getSquare(7, 1));
		whiteBishop1 = new Bishop (Color.white, board.getSquare(7, 2));
		whiteQueen = new Queen (Color.white, board.getSquare(7, 3));
		whiteKing = new King (Color.white, board.getSquare(7, 4));
		whiteBishop2 = new Bishop (Color.white, board.getSquare(7, 5));
		whiteKnight2 = new Knight (Color.white, board.getSquare(7, 6));
		whiteRook2 = new Rook(Color.white, board.getSquare(7, 7));


		blackPawn1 = new Pawn (Color.black, board.getSquare(1, 0));
		blackPawn2 = new Pawn (Color.black, board.getSquare(1, 1));
		blackPawn3 = new Pawn (Color.black, board.getSquare(1, 2));
		blackPawn4 = new Pawn (Color.black, board.getSquare(1, 3));
		blackPawn5 = new Pawn (Color.black, board.getSquare(1, 4));
		blackPawn6 = new Pawn (Color.black, board.getSquare(1, 5));
		blackPawn7 = new Pawn (Color.black, board.getSquare(1, 6));
		blackPawn8 = new Pawn (Color.black, board.getSquare(1, 7));

		whitePawn1 = new Pawn (Color.white, board.getSquare(6, 0));
		whitePawn2 = new Pawn (Color.white, board.getSquare(6, 1));
		whitePawn3 = new Pawn (Color.white, board.getSquare(6, 2));
		whitePawn4 = new Pawn (Color.white, board.getSquare(6, 3));
		whitePawn5 = new Pawn (Color.white, board.getSquare(6, 4));
		whitePawn6 = new Pawn (Color.white, board.getSquare(6, 5));
		whitePawn7 = new Pawn (Color.white, board.getSquare(6, 6));
		whitePawn8 = new Pawn (Color.white, board.getSquare(6, 7));
	}


	/**
	 * Create the list of moves
	 * 
	 * @category Accessor
	 */
	public void redo() 
	{
		state.goForwards();
	}


	/**
	 * Create the queue of movies
	 * 
	 * @category Accessor
	 */
	public void undo() 
	{
		state.goBack();
	}

	/**
	 * Changes between the 2 players.
	 */
	public void changePlayer() 
	{
		
		activePlayer = activePlayer == player1 ? player2 : player1;
		
	
	}





	/**
	 * ALL moves of piece in the game.
	 * 
	 * @category Transformer
	 * 
	 * @param previous x,y; next x,y
	 * @preCondition px,py,nx,ny not null
	 */
	public void move(int px,int py,int nx,int ny) {
		
		
		
		board.getSquare(px,py).getPiece().move(board.getSquare(nx,ny));
		lastPlayer=activePlayer;
		//System.out.println("sax"+saxCheck(nx,ny));
		 changePlayer() ;
		
		
		
		//if(saxCheck(nx,ny)==true)System.out.println("sax");
		//System.out.println("sax"+saxCheck( nx, ny));

		/*if( lastMoveWasSax){
			JOptionPane.showMessageDialog(null,"YOU KING IS IN SAX STATE...");
		for(int i=0;i<Chess.getBoard().pieceonBoard().size();i++){
		
			if(Chess.getBoard().pieceonBoard().elementAt(i) instanceof King) {
				tmp=Chess.getBoard().pieceonBoard().elementAt(i).getSquare();
			}
		}
		if(board.getSquare(tmp.getX(), tmp.getY()).getPiece().allowedMoves()!= null){
			board.getSquare(tmp.getX(),tmp.getY()).getPiece().move(board.getSquare(nx,ny));
			System.out.println("sax ok");
		}
		else{
			// TODO NA TON KALIPSEI ALLOS
		}
	}*/

		//khnhsh se perhptosh promote
		if( nx==0 && board.getSquare(nx,ny).getPiece().getColor()==Color.white
				&& board.getSquare(nx,ny).getPiece() instanceof Pawn ){ promote(nx,ny,Color.white);}
		if( nx==7 && board.getSquare(nx,ny).getPiece().getColor()==Color.black
				&& board.getSquare(nx,ny).getPiece() instanceof Pawn ){ promote(nx,ny,Color.black);}


	}


	/**
	 * Moves for capture some piece
	 * @category Transformer
	 * @param previous x,y; next x,y
	 * @preCondition px,py,nx,ny not null
	 */
	public void capture(int px,int py,int nx,int ny) {
		Piece p= board.getSquare(px,py).getPiece();
		board.getSquare(nx,ny).getPiece().isCaptured=true;
		board.getSquare(nx,ny).setPiece(null);
		board.getSquare(px,py).setPiece(null);
		board.getSquare(nx,ny).setPiece(p);


	}


	/**
	 * implement the castle method
	 * @category Transformer
	 * @param 
	 * @preCondition piece king & piece rook !has moved
	 * 				checkSax==false
	 */
	public void castle() {


	}


	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private  boolean OO(){


		return false;
	}


	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean  OOO(){

		return false;
	}


	/**
	 * Check for draw.
	 * 
	 * @category Accessor
	 * 
	 * @return true if draw, false if not
	 */
	public boolean eqCheck() {
		if(board.getSquare(st.getX(), st.getY()).getPiece().allowedMoves()==null
				&& !lastMoveWasSax){
			return true;
		}
		for(int i=0;i<board.pieceonBoard().size();i++){
			if(board.pieceonBoard().elementAt(i) instanceof King 
					&& board.pieceonBoard().elementAt(i) instanceof Rook 
					&&board.pieceonBoard().elementAt(i) instanceof Rook ){return true;}

			if(board.pieceonBoard().elementAt(i) instanceof King 
					&& board.pieceonBoard().elementAt(i) instanceof Rook ){return true;}
			if(board.pieceonBoard().elementAt(i) instanceof King 
					&& board.pieceonBoard().elementAt(i) instanceof Knight ){return true;}
			if(board.pieceonBoard().elementAt(i) instanceof King){return true;}
		}
		return false;
	}


	/**
	 * Check the mat condition 
	 * @category Accessor
	 * @param Square the position of king
	 * @preCondition saxChech ==true
	 * @postCondition null
	 * @return true if mat false if not
	 */
	public boolean matCheck(Square st) {
		if(board.getSquare(st.getX(), st.getY()).getPiece().allowedMoves()==null){
			return true;
		}
		return false;
	}


	/**
	 * Moves and choises for promote 
	 * @category Transformer
	 * @param int,int(position) Color c(color of piece)
	 * @preCondition x,y,c not null
	 */
	public void promote(int nx,int ny,Color c) {
		board.getSquare(nx, ny).setPiece(null);
		String [] options = {"Bishop","Queen","Knight","Rook"};
		int option =JOptionPane.showOptionDialog
		(null, "Choose piece", "Promote",0,JOptionPane.PLAIN_MESSAGE,null, options,options[0]);
		switch(option){
		case 0:
			board.getSquare(nx, ny).setPiece(new Bishop(c,board.getSquare(nx, ny)));
			break;
		case 1:
			board.getSquare(nx, ny).setPiece(new Queen(c,board.getSquare(nx, ny)));
			break;
		case 2:
			board.getSquare(nx, ny).setPiece(new Knight(c,board.getSquare(nx, ny)));
			break;
		case 3:
			board.getSquare(nx, ny).setPiece(new Rook(c,board.getSquare(nx, ny)));
			break;
		}


	}
	/**
	 * Check the sax condition 
	 * @category Accessor
	 * @return true if sax false if not
	 */
	
	//nx,ny 8eseis tou pesou pou kinishke
	//sax check deixnei an me thn kineisei xthpaw tov avtipalw vassilia
	public boolean saxCheck(int nx,int ny) {
		
			for(int i=0;i<board.pieceonBoard().size();i++)
			{
				if(board.pieceonBoard().elementAt(i) instanceof King && 
						Chess.board.pieceonBoard().elementAt(i).getColor()!=Chess.getBoard().getSquare(nx, ny).getPiece().getColor())
				{
					st=board.pieceonBoard().elementAt(i).getSquare();
				}
				if(board.pieceonBoard().elementAt(i).hits(st)){
					lastMoveWasSax=true;
					return true;
				}
			}
			
		return false;
		}
	

	public void deselect() {
		// TODO Auto-generated method stub

	}

	public Square select() {
		// TODO Auto-generated method stub
		return null;
	}

}