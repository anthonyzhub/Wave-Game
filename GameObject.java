import java.awt.Graphics;

public abstract class GameObject 
{
	/*
	 * OBJECTIVE: A foundation objects in the game. An object can be enemies, players, coins, and more.
	 * 				Each object in the game will be an instance of this class.
	 */
	
	// Protected - Variables that are accessible to classes that are inherited from this one
	
	// Create coordinate for each object
	protected int x;
	protected int y;
	
	// Specify object type with Object_ID (enum)
	protected Object_ID id;
	
	// Maintain object's movement
	protected int velocity_x;
	protected int velocity_y;

	public GameObject(int new_x, int new_y, Object_ID new_id)
	{
		// OBJECTIVE: Class constructor
		
		// System call
//		System.out.printf("Calling from GameObject's Constructor func!%n");
		
		// Set variable's value
		x = new_x;
		y = new_y;
		id = new_id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	// ===== Setter and Getter methods ===== 
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getX()
	{
		return x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setID(Object_ID id)
	{
		this.id = id;
	}
	
	public Object_ID getID()
	{
		return id;
	}
	
	public void setVelocityX(int velocity_x)
	{
		this.velocity_x = velocity_x;
	}
	
	public int getVelocityX()
	{
		return velocity_x;
	}
	
	public void setVelocityY(int velocity_y)
	{
		this.velocity_y = velocity_y;
	}
	
	public int getVelocityY()
	{
		return velocity_y;
	}
}
