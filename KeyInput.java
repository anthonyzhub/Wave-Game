import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent; // Look out for any keys pressed

public class KeyInput extends KeyAdapter
{
	// OBJECTIVE: Override functions created in KeyAdapter class
	
	private Handler handler;
	
	public KeyInput(Handler incoming_handler)
	{
		// OBJECTIVE: Class constructor
		
		handler = incoming_handler;
	}
	
	public void keyPressed(KeyEvent e)
	{
		// OBJECTIVE: Listen for any pressed keys
		
		// Get number value of corresponding key that was clicked
		int key = e.getKeyCode();
		
		// Iterate link list of game's objects
		for (int i=0; i<handler.object_list.size(); i++)
		{
			GameObject tempObject = handler.object_list.get(i);
			
			// Check if object is a player
			if (tempObject.getID() == Object_ID.Player)
			{
				// Check which keys were pressed, then update object's velocity
				
				if (key == KeyEvent.VK_UP)
				{
					tempObject.setVelocityY(-1);
				}
				
				if (key == KeyEvent.VK_DOWN)
				{
					tempObject.setVelocityY(1);
				}
				
				if (key == KeyEvent.VK_LEFT)
				{
					tempObject.setVelocityX(-1);
				}
				
				if (key == KeyEvent.VK_RIGHT)
				{
					tempObject.setVelocityX(1);
				}
			}
		}
	}
	
	public void keyReleased(KeyEvent e)
	{
		// OBJECTIVE: List for any released keys
		
		int key = e.getKeyCode();
		
		// Iterate link list of game's objects
		for (int i=0; i<handler.object_list.size(); i++)
		{
			GameObject tempObject = handler.object_list.get(i);
			
			// Check if object is a player
			if (tempObject.getID() == Object_ID.Player)
			{
				// Check which keys were released, then stop object's velocity
				
				if (key == KeyEvent.VK_UP)
				{
					tempObject.setVelocityY(0);
				}
				
				if (key == KeyEvent.VK_DOWN)
				{
					tempObject.setVelocityY(0);
				}
				
				if (key == KeyEvent.VK_LEFT)
				{
					tempObject.setVelocityX(0);
				}
				
				if (key == KeyEvent.VK_RIGHT)
				{
					tempObject.setVelocityX(0);
				}
			}
		}
	}
}
