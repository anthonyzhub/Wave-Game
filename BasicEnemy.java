import java.awt.Color;
import java.awt.Graphics;

public class BasicEnemy extends GameObject
{
	// OBJECTIVE: Handle all properties of BasicEnemy
	
	public BasicEnemy(int x, int y, Object_ID id)
	{
		// OBJECTIVE: Class constructor
		super(x, y, id);
		
		// Start instance with BasicEnemy moving
		velocity_x = 5;
		velocity_y = 5;
	}
	
	@Override
	public void tick() 
	{
		// OBJECTIVE: Handle object's movement
		
		// Update object's velocity
		x += velocity_x;
		y += velocity_y;
		
		// Check if object reaches or goes over screen border.
		// HEIGHT comes from Game class
		// -32 is a random number picked for the object not escaping below the screen border
		// FYI: I'm not adding Game.clamp() because the enemy needs to constantly move! The player can stop at anytime.
		if (y <= 0 || y >= Game.HEIGHT - 32)
		{
			velocity_y *= -1;
		}
		
		if (x <= 0 || x >= Game.WIDTH - 32)
		{
			velocity_x *= -1;
		}
	}

	@Override
	public void render(Graphics g) 
	{
		// OBJECTIVE: Control how BasicEnemy's object looks like
		
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}

}
