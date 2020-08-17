import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L; // This comes from Canvas
	private Thread thread; // Create a thread. The entire game will run on this entire thread (not recommended...)
	private boolean isRunning = false;

	// Specify window's width and height. By adding " * 9", the window will have a 16:9 ratio.
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH / 12 * 9;

	public Game()
	{
		// OBJECTIVE: Class's constructor
		new Window(WIDTH, HEIGHT, "Game Title", this); // "this" refers the class
	}

	public synchronized void start()
	{
		// OBJECTIVE: To initialize a thread for the game to start
		
		// Initialize a previously created thread
		thread = new Thread(this); // This refers to thread that was created above
		thread.start();
		
		// Change boolean variable
		isRunning = true;
	}
	
	public synchronized void stop()
	{
		// OBJECTIVE: To stop a game from running
		
		try
		{
			// join() kills thread
			thread.join();
			isRunning = false;
		}
		catch(Exception e)
		{
			// Retrace steps
			e.printStackTrace();
		}
	}
	
	private void tick()
	{
		
	}
	
	private void render()
	{
		// OBJECTIVE: Manages window rendering
		
		// BufferStrategy handles memory for windows and canvases
		BufferStrategy buff = this.getBufferStrategy();
		
		if (buff == null)
		{
			// Specifies how many buffers can be created. 3 is recommended
			this.createBufferStrategy(3);
			return; // Return nothing
		}
		
		// Change background (sort of)
		Graphics display = buff.getDrawGraphics();
		
		// Set background to black and specify where in the rectangular window to spread it
		display.setColor(Color.black);
		display.fillRect(0, 0, WIDTH, HEIGHT);
		
		display.dispose(); // Remove graphics from window and release resources
		buff.show(); // Make next available buffer visible
	}
	
	@Override
	public void run() 
	{
		// OBJECTIVE: Calculate FPS of computer screen
		
		long lastTime = System.nanoTime(); // Get current time
		long timer = System.currentTimeMillis(); // Start timer
		
		double amountOfTicks = 60.0; // 60 FPS
		double ns = 100_000_000; // Time until new screen (frame) is loaded
		double delta = 0;
		
		int frames = 0;
		
		while (isRunning) // Check if thread is created and being used
		{
			long now = System.nanoTime(); // Get current time
			delta += (now - lastTime) / ns; // Calculate how many frames were created from lastTime to now
			lastTime = now; // Update now variable
			
			while (delta >= 1) // While delta >= 1, call tick()
			{
				tick();
				delta--;
			}
			
			if (isRunning) // Again, check if thread is still running
			{
				render(); // Render screen
			}
			
			frames++; // Increment frames by 1
			
			// Print new frame every 1,000 seconds
			if (System.currentTimeMillis() - timer > 1_000)
			{
				timer += 1000;
				System.out.printf("FPS: %d%n", frames);
				frames = 0;
			}
		}
		
		// Stop game from running
		stop();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Call class's constructor
		new Game();
	}

}
