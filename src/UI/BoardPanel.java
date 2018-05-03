package UI;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Chess.Chess;
import Core.Board;
import Core.Piece;
import Core.Square;

public class BoardPanel extends JPanel implements MouseListener{
	private static final long serialVersionUID = -4999900827543479711L;
	public Chess myChess;
	private Point initial;
	private Point destination;
	private int click = 0;
	private Graphics2D g2;
	Vector<Square> highLightedMoves = null;

	public BoardPanel(){
		myChess=new Chess();
		 initalizePlayer();
		myChess.initialize();
		for(int i=0;i<myChess.board.pieceonBoard().size();i++){
			
			this.add(myChess.board.pieceonBoard().elementAt(i));
		}
		this.addMouseListener(this);
	}

	public void paint(Graphics g){

		setBackground(Color.gray);
		super.paintComponent(g);
		g2=(Graphics2D)g;
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(i != myChess.getBoard().getSquare(i, j).getX() ||
						j != myChess.getBoard().getSquare(i, j).getY())

				{
					System.exit(ERROR);
				}

				if(myChess.getBoard().getSquare(i,j).getColor()==Core.Color.black){
					g2.setPaint(Color.LIGHT_GRAY);
				}
				else{
					g2.setPaint(Color.WHITE);
				}
				int x=i*80+25;
				int y=j*80+25;
				g2.fill(new Rectangle2D.Double(j*80+25, i*80+25, 80, 80));

			}
		}
		if(highLightedMoves != null){
			for(int i=0;i<highLightedMoves.size();i++){
				
				int	l=highLightedMoves.elementAt(i).getX();
				int	j=highLightedMoves.elementAt(i).getY();
				
				
				
				g2.setPaint(Color.blue);
				g2.fill(new Rectangle2D.Double(j*80+25, l*80+25, 80, 80));
				

			}
		}
		for(int i=0;i<myChess.getBoard().pieceonBoard().size();i++){
			myChess.getBoard().pieceonBoard().elementAt(i).paint(g);

		}
	}
public void initalizePlayer(){
	String nameofplayer1 = JOptionPane.showInputDialog("THE PLAYER 1 PLAY WHITE: GIVE YOUR NAME");
	myChess.player1.setName(nameofplayer1);
	
	String nameofplayer2=JOptionPane.showInputDialog("THE PLAYER 2 PLAY BLACK: GIVE YOUR NAME");
	myChess.player2.setName(nameofplayer2);
	
}
	public void mouseClicked(MouseEvent e) {
		if(click == 0){
			initial = e.getPoint();
			initial.x=e.getX();
			initial.y=e.getY();
		}
		else if(click == 1){
			destination = e.getPoint();
			destination.x = e.getX();
			destination.y = e.getY();
		}
		click++;
		handleEvent();

		this.repaint();
	}

	public void handleEvent(){
		int firstx = 0,firsty = 0;
		int secondx = 0, secondy = 0;

		switch(click){
			case(1):{
				
				System.out.println("click1"+click);
				
				firstx=((int)initial.getY()-40)/80;
				firsty=((int)initial.getX()-40)/80;
				if(Chess.getBoard().getSquare(firstx,firsty).getPiece().getColor()==myChess.activePlayer.getColor()){
				if(Chess.getBoard().getSquare(firstx,firsty).hasPiece()){
					highLightedMoves = myChess.getBoard().getSquare(firstx,firsty).getPiece().allowedMoves();
					
					System.out.println("first"+firstx+firsty);
				}
				
				}
				
				else
					
					click=0;
			}
			break;
	
			case(2):{
				System.out.println("click2"+click);
				firstx=((int)initial.getY()-40)/80;
				firsty=((int)initial.getX()-40)/80;
				secondx=((int)destination.getY()-40)/80;
				secondy=((int)destination.getX()-40)/80;
				for(int i=0;i<highLightedMoves.size();i++){
					if(Chess.getBoard().getSquare(secondx,secondy) == highLightedMoves.elementAt(i)){
						myChess.move(firstx, firsty, secondx, secondy);
					}
				}
				highLightedMoves = null;
				click=0;
			}
			break;
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
