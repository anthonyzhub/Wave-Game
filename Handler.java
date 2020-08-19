import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	// OBJECTIVE: Update and render all objects on the window
	
	// Create a global link list of all the objects that will be created
	LinkedList<GameObject> object_list = new LinkedList<GameObject>();
	
	public void callMessage(String s)
	{
//		System.out.printf("Calling from: %s%n", s);
	}
	
	public void tick()
	{
		// OBJECTIVE: Update all object's movement
		
		// Function call
		callMessage("Handler's tick func!");
		
		// Call tick() for every object
		for (int i=0; i < object_list.size(); i++)
		{
			GameObject temp_object = object_list.get(i);
			temp_object.tick(); // <- This refers to tick() from GameObject. Not tick() from this class
		}
	}
	
	public void render(Graphics g)
	{
		// OBJECTIVE: To render all objects inside link list to screen
		
		// Function call
		callMessage("Handler's render func!");
				
		// Call render() for every object
		for (int i=0; i < object_list.size(); i++)
		{
			GameObject temp_object = object_list.get(i);
			temp_object.render(g);
		}
	}
	
	public void addObject(GameObject new_object)
	{
		// OBJECTIVE: To add a new gaming object to the link list
		
		// Function call
		callMessage("Handler's addObject func!");
		
		object_list.add(new_object);
	}
	
	public void removeObject(GameObject old_object)
	{
		// OBJECTIVE: To remove an already existing gaming object from the link list
		
		// Function call
		callMessage("Handler's removeObject func!");
		
		object_list.remove(old_object);
	}
}
