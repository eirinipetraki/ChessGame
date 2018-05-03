package UI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;

/*public class DrawFrame extends JFrame{
	private static final long serialVersionUID = 7770341791206510347L;
	BoardPanel panel = new BoardPanel();
	static int size=700;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	public int screenHeight = screenSize.height;
	public int screenWidth = screenSize.width;
	public static final int FRAME_WIDTH = size;
	public static final int FRAME_HEIGHT = size;

	public DrawFrame(){
		setLocation(100,100);
		setResizable(true);
		setTitle("My chess Board");
		setUndecorated(false);

		Container contentPane = getContentPane();
		contentPane.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.add(panel);
		this.pack();
		setSize(size,size);
	}
	
}
*/



import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class DrawFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 7770341791206510347L;
	BoardPanel panel = new BoardPanel();
	static int size=800;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	public int screenHeight = screenSize.height;
	public int screenWidth = screenSize.width;
	public static final int FRAME_WIDTH = size;
	public static final int FRAME_HEIGHT = size;
	
	
	private JMenuItem newGame;
	private JMenuItem undo;
	private JMenuItem redo;
	private JMenuItem exit;
	private JMenuItem about;

	public DrawFrame(){
		
		//menu
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("File");
		newGame = new JMenuItem("New Game");
		undo = new JMenuItem("Undo");
		redo = new JMenuItem("Redo");
		exit = new JMenuItem("Exit");
		JMenu help = new JMenu("Help");
		about = new JMenuItem("About");
		menu.add(file);
		file.add(newGame);
		file.addSeparator();
		file.add(undo);
		file.add(redo);
		file.addSeparator();
		file.add(exit);
		menu.add(help);
		help.add(about);
		//
		newGame.addActionListener(this);
		undo.addActionListener(this);
		redo.addActionListener(this);
		exit.addActionListener(this);
		about.addActionListener(this);
		
		
		setLocation(100,100);
		setResizable(true);
		setTitle("Virtua Chess 2009");
		this.setJMenuBar(menu);
		setUndecorated(false);

		Container contentPane = getContentPane();
		contentPane.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.add(panel);
		this.pack();
		setSize(size,size);
	}

	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		int option;
		
		if (source == newGame) 
		{
			System.err.println("NEW GAME");
			panel = new BoardPanel();
			this.repaint();
		}
		
		if (source == undo)
		{
			if (panel.myChess.state.getHistory().isEmpty())
				System.err.println("Cannot undo");
			else
			{
				System.err.println("UNDO");
				panel.myChess.undo();
				this.repaint();
			}
		}
		
		if (source == redo)
		{
			if (panel.myChess.state.getFuture().isEmpty())
				System.err.println("Cannot redo");
			else
			{
				System.err.println("REDO");
				panel.myChess.redo();
				this.repaint();
			}
		}
		
		if (source == exit) {
			
			System.err.println("EXIT");
			
			option = JOptionPane.showConfirmDialog(this, "Do you really want to quit this game?", "Exit confirmation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			switch (option) {
				case 0:
					System.exit(0); break;
				case 1: break;
			}
		}
		if (source == about)
			JOptionPane.showMessageDialog(this, "Developed by:\nIrene 'Arisha' Petraki\nChristos 'Archangel Uriel' Despotakis", "About", JOptionPane.INFORMATION_MESSAGE);
	}
		
}
