package Core;


/**
 * A player of a board game.
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
public class Player 
{
	private String Name;
	private Color color;
	
	
	
	/**
	 * Creates a new player.
	 * 
	 * @category Constructor.
	 * 
	 * @param name The name of the player.
	 * @param color The color of the player.
	 */
	public Player (String name, Color color)
	{
		this.Name = name;
		this.color = color;
	}
	
	
	/**
	 * Return the name of the player.
	 * 
	 * @category Getter.
	 * 
	 * @return the name of the player.
	 */
	public String getName() 
	{
		return Name;
	}
	
	
	/**
	 * Sets the name of the player.
	 * 
	 * @category Setter.
	 * 
	 * @param name The name of the player.
	 */
	public void setName(String name) 
	{
		Name = name;
	}
	
	
	/**
	 * Return the color of the player.
	 * 
	 * @category Getter.
	 * 
	 * @return the color of the player.
	 */
	public Color getColor() 
	{
		return color;
	}
	
	
	/**
	 * Sets the color of the player.
	 * 
	 * @category Setter.
	 * 
	 * @param color the color of the player.
	 */
	public void setColor(Color color) 
	{
		this.color = color;
	}
	
	

}
