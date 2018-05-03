package Core;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Chess.Chess;

import Main.GameMaster;


/**
 * The abstract piece of every board game.
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
public abstract class Piece extends Component
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5983194937788190705L;
	private Color color;
	private Square square;
	private boolean hasMoved;
	public boolean isCaptured;
	BufferedImage img;


	/**
	 * 
	 * @param c
	 * @param s
	 */
	public Piece(Color c, Square s, String imgPath)
	{
		this.color = c;
		this.square = s;
		this.hasMoved = false;
		this.isCaptured = false;
		try {
			img = ImageIO.read(new File(imgPath+".gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.setPiece(this);

		//Invariant asserts.
		this.checkInvariant();
	}

	public Object getImage(){
		return this.getImage();
	}

	public void paint(Graphics g) {
		int x=square.getX()*80+40;
		int y=square.getY()*80+40;
		g.drawImage(img,square.getY()*80+40 ,square.getX()*80+40, null);
		
	}

	public Dimension getPreferredSize() {
		if (img == null) {
			return new Dimension(100,100);
		} else {
			return new Dimension(img.getWidth(null), img.getHeight(null));
		}
	}

	/**
	 * Returns the color of this piece.
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
	 * Returns the square of this piece.
	 * 
	 * @category Getter.
	 * 
	 * @Preconditions None.
	 * @Postconditions None.
	 * 
	 * @return
	 */
	public Square getSquare()
	{
		return this.square;
	}


	/**
	 * Returns true if the move is succefully done.
	 * 
	 * @category Transformer.
	 * 
	 * @param to The destination square.
	 * 
	 * @return true if the move was succefull.
	 */
	public boolean move(Square to)
	{
		if (this.allowedMoves().contains(to))
		{
			Chess.state.setHistory();
			this.hasMoved = true;
			this.square.setPiece(null);
			this.square = to;
			to.setPiece(this);
			Chess.state.setStateHolder();

			//Invariant asserts.
			this.checkInvariant();

			System.out.println("Done.");

			return true;
		}
		else
		{
			System.out.println("NOT done.");
			return false;
		}
	}


	/**
	 * Returns true if the piece has been moved.
	 * 
	 * @category Checker.
	 * 
	 * @Preconditions None.
	 * @Postconditions None.
	 * 
	 * @return
	 */
	public boolean hasMoved()
	{
		return this.hasMoved;
	}


	/**
	 * Returns true if the piece was captured
	 * 
	 * @category Accessor
	 * 
	 * @Preconditions None.
	 * @Postconditions None.
	 * 
	 * @return true if piece was captured
	 */
	public boolean hasCaptured()
	{
		return this.isCaptured;
	}


	/**
	 * The moves which are allowed.
	 * 
	 * @category Accessor
	 * 
	 * @Preconditions None.
	 * @Postconditions None.
	 * 
	 * @return Vector<square> all probable moves
	 */
	public abstract Vector<Square> allowedMoves();

	/**
	 * The squares which are threatened.
	 * 
	 * @category Accessor
	 * 
	 * @Preconditions None.
	 * @Postconditions None.
	 * 
	 * @return Vector<square> all probable  squares for capture
	 */
	public abstract Vector<Square> threatenSquares();



	/**
	 * Returns true if $s is a threaten square.
	 * 
	 * @category Accessor.
	 * 
	 * @param s The square to be checked.
	 * 
	 * @return true if $s is a threaten square.
	 */
	public boolean hits(Square s){
		for(int i=0;i<threatenSquares().size();i++){
			if(s==threatenSquares().elementAt(i)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks the Invariants.
	 * 
	 * @Invariants color instanceof Color && square instanceof Square. 
	 */
	private void checkInvariant()
	{
		assert(this.color instanceof Color);
		assert(this.square instanceof Square);
	}
}