import java.awt.Color;
import java.awt.Graphics;

public class HUD 
{
	// OBJECTIVE: Create and manage game's Heads Up Display (HUD)
	
	// A static was created because any class can access the variable without an initializer
	public static int HEALTH = 100;
	
	public void tick()
	{
		// OBJECTIVE: Update health bar
		
		HEALTH--;
		
		// clamp() will stop health bar from exiting border
		HEALTH = Game.clamp(HEALTH, 0, 100);
	}
	
	public void render(Graphics g)
	{
		// OBJECTIVE: Render health bar image to window
		
		// Create health bar's background
		g.setColor(Color.gray);
		g.fillRect(15, 15, 100, 32);
		
		// Create actual health bar
		g.setColor(Color.green);
		g.fillRect(15, 15, HEALTH, 32); // <- Bar needs to be in sync with player's health
		
		// Create border for health bar
		g.setColor(Color.white);
		g.drawRect(15, 15, 100, 32); // <- drawRect() only creates a rectangular borderline. Everything inside is blank/
	}
}
