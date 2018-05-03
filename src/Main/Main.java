package Main;

import java.util.Scanner;

import Chess.Chess;
import Core.StateHolder;

/**
 * The main program of the chess.
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
public class Main 
{

	static Scanner sc = new Scanner(System.in);
	static String comm;
	static Chess game;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		game = new Chess();
		
		game.initialize();
		
		print();
		
		printAll();
		
		while(!game.hasEnded())
		{
			command();
			print();
		}

	}
	
	private static void print()
	{
		for (int i = 0; i < 8; ++i)
		{
			for (int j = 0; j < 8; ++j)
			{
				if (game.board.getSquare(i, j).getPiece() != null)
					System.out.print(" " + "(" + game.board.getSquare(i, j).getX() + "," + game.board.getSquare(i, j).getY() + ")" + game.board.getSquare(i, j).getPiece().getClass().toString());
				else
					System.out.print(" null");
			}
			
			System.out.print("\n");
		}
		
	}
	
	private static void command()
	{
		System.out.println("Give command");
		game.move(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
	}

	private static void printAll()
	{
		System.out.println(game.board.getSquare(sc.nextInt(), sc.nextInt()).getPiece().allowedMoves());
//		
//		System.out.println(game.state.getHistory().toString());
//		System.out.println(game.state.getFuture().toString());
	}
	
}
