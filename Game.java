import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L; // This comes from Canvas
	private Thread thread; // Create a thread. The entire game will run on this entire thread (not recommended...)
	private boolean isRunning = false;
	private Handler handler;
	private Random r;
	private HUD hud;

	// Specify window's width and height. By adding " * 9", the window will have a 16:9 ratio.
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH / 12 * 9;

	public Game()
	{
		// OBJECTIVE: Class's constructor
		
		// Create a new instance of Handler
		handler = new Handler();
		
		// Create a new instance of KeyInput to lookout for any keys that are pressed
		this.addKeyListener(new KeyInput(handler));
		
		// Create a new window with specified weight, height, window this, and GameObject
		new Window(WIDTH, HEIGHT, "Game Title", this); // "this" refers the class
		
		// Create a new instance of Random
//		r = new Random();
		
		// Create a new instance of HUD
		hud = new HUD();
		
		// Add player (object) to window
		handler.addObject(new Player(100, 100, Object_ID.Player));
		
		// Add BasicEnemy (object) to window
		handler.addObject(new BasicEnemy(150, 150, Object_ID.BasicEnemy));
	}
	
	public void callMessage(String msg)
	{
//		System.out.printf("Calling from: %s%n", msg);
	}

	public synchronized void start()
	{
		// OBJECTIVE: To initialize a thread for the game to start
		
		// Function call
		callMessage("Game's start func!");
		
		// Initialize a thread
		thread = new Thread(this); // This refers to thread that was created above
		thread.start();
		
		// Change boolean variable
		isRunning = true;
	}
	
	public synchronized void stop()
	{
		// OBJECTIVE: To stop a game from running
		
		// Function call
		callMessage("Game's stop func!");
		
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
		// Function call
		callMessage("Game's tick func!");
		
		handler.tick();
		hud.tick();
	}
	
	private void render()
	{
		// OBJECTIVE: Manages window rendering
		
		// Function call
		callMessage("Game's render func!");
		
		// BufferStrategy handles memory for windows and canvases
		BufferStrategy buff = this.getBufferStrategy();
		
		if (buff == null)
		{
			// Specifies how many buffers can be created. 3 is recommended
			this.createBufferStrategy(3);
			return; // Return nothing
		}
		
		// Handle window's graphics
		Graphics window_graphics = buff.getDrawGraphics();
		
		// Set background to black and specify where in the rectangular window to spread it
		window_graphics.setColor(Color.black);
		window_graphics.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(window_graphics);
		hud.render(window_graphics);
		
		window_graphics.dispose(); // Remove graphics from window and release resources
		buff.show(); // Make next available buffer visible
	}
	
	@Override
	public void run() 
	{
		// OBJECTIVE: Calculate FPS of computer screen
		
		// Function call
		callMessage("Game's run func!");
		
		// Automatically accepts keyboard input without needing to click on window
		this.requestFocus();
		
		long lastTime = System.nanoTime(); // Get current time
		
		double amountOfTicks = 60.0; // 60 FPS
		double ns = 1_000_000_000 / amountOfTicks; // Time until new screen (frame) is loaded
		double delta = 0;
		
		long timer = System.currentTimeMillis(); // Start timer
		
		int frames = 0; // Keep track of how many frames there are
		
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
				timer += 1_000;
//				System.out.printf("FPS: %d%n", frames);
				frames = 0;
			}
		}
		
		// Stop game from running
		stop();
	}
	
	public static int clamp(int var, int min, int max)
	{
		// OBJECTIVE: Return updated X or Y position to the player
		
		if (var >= max)
		{
			// If X or Y position is above their maximum, return max
			return max;
		}
		else if (var <= min)
		{
			// If X or Y position is below their minimum, return min
			return min;
		}
		else
		{
			// Don't make changes. Return incoming variable
			return var;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Call class's constructor
		new Game();
	}

}
