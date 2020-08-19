import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject
{
	// OBJECTIVE: Handle all properties of Player
	
	public Player(int x, int y, Object_ID id) 
	{
		// OBJECTIVE: Class constructor
		
		// This came be default because it is a child of GameObject class
		super(x, y, id);
		
	}
	
	public void callMessage(String s)
	{
//		System.out.printf("Calling from: %s%n", s);
	}

	@Override
	public void tick() 
	{
		// OBJECTIVE: Handle player's movement
		
		// Function call
		callMessage("Player's tick func!");
		
		// Update player's x & y coordinates
		x += velocity_x;
		y += velocity_y;
	}

	@Override
	public void render(Graphics g) 
	{
		// OBJECTIVE: Customize player's appearance
		
		// Function call
		callMessage("Player's render func!");
		
		g.setColor(Color.white); // Give player (object) a color
		g.fillRect(x, y, 32, 32); // Specify player's (object) dimension
	}

}
