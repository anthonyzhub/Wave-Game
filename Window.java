import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas
{
	// OBJECTIVE: To create a window where game will be held
	
	// Import declaration from Canvas
	private static final long serialVersionUID = 1L;
	
	// constructor
	public Window(int width, int height, String title, Game game)
	{
		// Create window with set tile
		// JFrame - An inbuilt library responsible for the frame of the window
		JFrame frame = new JFrame(title);
		
		// Create a predefined dimension for the window
		Dimension dime = new Dimension(width, height);
		frame.setPreferredSize(dime);
		
		// Set maximum and minimum size
		Dimension max = new Dimension(width, height);
		Dimension min = new Dimension(width, height);
		
		frame.setMaximumSize(max);
		frame.setMinimumSize(min);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Enable close window feature when X button is hit
		frame.setResizable(false); // Prevent window from resizing
		frame.setLocationRelativeTo(null); // Optional - By ignoring it, window will pop up on top left corner
		frame.add(game); // Add the actual game to the frame
		frame.setVisible(true);
		
		game.start(); // Call start() from Game class
	}
}