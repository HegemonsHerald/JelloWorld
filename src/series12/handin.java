package series12;

// package speedrunner;

import static programming.set12.speedrunner.SpeedRunner.GameState.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 *	The {@link SpeedRunner} implements the Speed Runner game.
 */
@SuppressWarnings("serial")
public class SpeedRunner extends GraphicsProgram {

	/**
	 * The state of the game is controlled by the following enum.
	 */
	public enum GameState {
		/** Waiting for the game to start. */
		WAITING,
		
		/** Preparing next round. */
		STARTING,
		
		/** Game round is running. */
		RUNNING,
		
		/** Generating new maze. */
		GENERATING,
		
		/** Exiting game. */
		EXITING
	}

	/** Visible size of a maze block in pixel. */
	private final static int BLOCK_SIZE = 10;
	
	/** Visible size of the player in pixel. */
	private final static int PLAYER_SIZE = 4;
	
	/** Number of horizontal blocks. */
	private final static int HORIZONTAL_BLOCK_COUNT = 100;
	
	/** Number of vertical blocks. */
	private final static int VERTICAL_BLOCK_COUNT = 20;
	
	/** Offset of the playing field in pixel. */
	private final static int BOARD_OFFSET = 10;
	
	/** Speed of the player in seconds if not blocked by an obstacle. */
	private final static int PLAYER_SPEED_PER_SECOND = 200;
	
	/** Logical frames per seconds. */
	private final static int FRAMES_PER_SECOND = 100;
	
	/** Milliseconds between frames. */
	private final static int MILLISECONDS_PER_FRAME = 1000 / FRAMES_PER_SECOND;
	
	/** Stating game wait time in ms. */
	private final static int WAIT_TIME = 3000;
	
	/** Random generator instance. */
	private final static RandomGenerator RGEN = RandomGenerator.getInstance();

	/** Heavy ass motion const yeah man dude */
	private final static double MOVE_RATE = 10.d;
	
	
	/** The player rectangle. */
	protected GRect player = null;
	
	/** The compound that holds the playing field and also the player. */
	protected GCompound board = null;
	
	/** A status label for showing information to the user. */
	protected GLabel status = null;
	
	/** The global state of the game. */
	protected GameState gameState = WAITING;

	
	/**
	 * Initialization method.
	 * Add one time initializations, such as handler registrations, here.
	 * You are allowed to add code to this method.
	 */
	@Override
	public void init() {
		super.init();

		addKeyListeners();

	}

	/**
	 * The run method initialized the game and calls the main game loop.
	 * At the end the application's shutdown is forced.
	 * Do not change this method.
	 */
	@Override
	public void run() {
		gameInit();

		gameLoop();

		System.exit(0);
	}
	
	/**
	 * {@link GameInit} initializes the game objects.
	 * Therefore, the player, the playing field and the status label objects are created.
	 * Additionally, the windows if adjusted to the appropriate size.
	 * Do not change this method.
	 */
	public void gameInit() {
		// Create player.
		player = new GRect(PLAYER_SIZE, PLAYER_SIZE);
		player.setColor(Color.RED);
		player.setFilled(true);
		
		// Creae game board.
		createAndAddNewBoardCompound();

		// Create status label.
		status = new GLabel("");
		Font font = status.getFont();
		status.setFont(new Font(font.getName(), font.getStyle(), 18));
		status.setLocation(BOARD_OFFSET, VERTICAL_BLOCK_COUNT * BLOCK_SIZE + BOARD_OFFSET + status.getAscent());
		add(status);
		status.setLabel("Press SPACE to start... (N for new maze, Q for quit...)");

		// Set window size.
		setSize(HORIZONTAL_BLOCK_COUNT * BLOCK_SIZE + BOARD_OFFSET * 2, VERTICAL_BLOCK_COUNT * BLOCK_SIZE + BOARD_OFFSET * 2 + (int) status.getHeight());
	}
	
	/**
	 * The outer game loop switches between the different phases of the game until the {@link gameState} is set to EXITING.
	 * The phases are implemented in {@link GameWait}, {@link GameStart}, and {@link GamePlay}.
	 * Do not change this method. 
	 */
	public void gameLoop() {
		while (gameState != EXITING) {
			gameWait();
			if (gameState == STARTING) {
				gameStart();
				gamePlay();
			}
		}
	}
	
	/**
	 * {@link GameWait} is the first phase of the game.
	 * The loop idles and waits for the {@link gameState} to change.
	 * If the state is set to GENERATING, a new maze will be created. Otherwise, the loop is exited and the game proceeds according to state.
	 * Do not change this method.
	 */
	public void gameWait() {
		gameState = WAITING;
		while (gameState != STARTING) {
			// It's sometimes good practice to not consume all available cpu cycles.
			// Instead just wait for a brief moment.
			pause(10);
			if (gameState == EXITING) {
				return;
			} else if (gameState == GENERATING) {
				// Generate a new maze if requested.
				createAndAddNewBoardCompound();
				gameState = WAITING;
			}
		}
	}		
	
	/**
	 * {@link GameStart} resets the player location to the starting point.
	 * Afterwards, a count down is displayed that waits for the specified start wait time.
	 * Do not change this method.
	 */
	public void gameStart() {
		// Set players starting position.
		player.setLocation(BLOCK_SIZE / 2 - PLAYER_SIZE / 2,
				BLOCK_SIZE / 2 - PLAYER_SIZE / 2 + board.getHeight() / 2);
		
		// Display count down.
		long startTime = System.currentTimeMillis();
		long elapsedTime = 0;
		do {
			elapsedTime = System.currentTimeMillis() - startTime;
			status.setLabel("Game will start in " + String.format("%.1f", Math.max(0, WAIT_TIME - elapsedTime) / 1000d) + " seconds...");
			pause(100);
		} while (elapsedTime < WAIT_TIME);
		
		gameState = RUNNING;
	}

	/**
	 * The inner game loop is iterated until the player reaches the right side of the playing board.
	 * Every frame, the {@link GamePlayFrame} method is called.
	 * Additionally, the status labels shows the elapsed time since game start.
	 * Do not change this method.
	 */
	public void gamePlay() {
		long lastTime = System.currentTimeMillis();
		long currentTime;
		double seconds = 0;

		while (player.getX() + player.getWidth() < board.getWidth()) {
			currentTime = System.currentTimeMillis();
			
			// For every frame time passed, call gamePlayFrame.
			while (currentTime - lastTime >= MILLISECONDS_PER_FRAME) {
				seconds += MILLISECONDS_PER_FRAME / 1000d;
				lastTime += MILLISECONDS_PER_FRAME;
				
				gamePlayFrame();
				status.setLabel("Running for " + String.format("%.2f", seconds) + " seconds...");
			}
		}
		
		status.setLabel("Finished round in " + String.format("%.2f", seconds) + " seconds! Press SPACE to start again...");
	}
	
	/**
	 * {@link GamePlayFrame} is called every frame by the {@link GamePlay} method.
	 * Basically, this method is responsible for the player movement.
	 * Complete this method. You are allowed to change the present code.
	 */
	public void gamePlayFrame() {
		
		double newX;
		
		newX = player.getX() + PLAYER_SPEED_PER_SECOND / FRAMES_PER_SECOND;

		GObject gg = board.getElementAt(newX + PLAYER_SIZE, player.getY());

		if (gg == null) {

			player.setLocation(newX, player.getY());

		}
	}


	
	// ************************************************************************
	// You must react to the inputs to the user.
	// It would be a good idea to implement your input handlers somewhere.
	// YEAH NO SHIT.
	// ************************************************************************

	public void moveUp() {

		double newY = player.getY() - MOVE_RATE;
		GObject gg = board.getElementAt(player.getX(), newY + PLAYER_SIZE);

		if (gg == null) {
			player.setLocation(player.getX(), newY);
		}

	}

	public void moveDown() {

		double newY = player.getY() + MOVE_RATE;
		GObject gg = board.getElementAt(player.getX(), newY + PLAYER_SIZE);

		if (gg == null) {
			player.setLocation(player.getX(), newY);
		}

	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				moveUp();
				break;
			case KeyEvent.VK_DOWN:
				moveDown();
				break;
			case 32: // space
				gameState = STARTING;
				break;
			case 81: // q
				if (gameState == WAITING) gameState = EXITING;
				break;
			case 78: // n
				if (gameState == WAITING) gameState = GENERATING;
				break;
		}
	}


	/**
	 * Creates a new, random playing field. GRects, which are not the player, are obstacles. 
	 * You do not need to change this method. You can, of course, add own mazes for testing purposes.
	 *
	 * @param horizontalBlocks
	 * 			Number of horizontal blocks.
	 * @param verticalBlocks
	 * 			Number of vertical blocks.
	 * @return
	 * 			Returns the playing field as GCompound.
	 */
	public GCompound createBoard(int horizontalBlocks, int verticalBlocks) {
		boolean[][] board = new boolean[verticalBlocks][horizontalBlocks];

		int pathY = verticalBlocks / 2;
		board[pathY][0] = true;
		for (int x = 1; x < horizontalBlocks; x++) {
			board[pathY][x] = true;
			pathY = pathY + RGEN.nextInt(3) - 1;
			if (pathY < 1) {
				pathY = 2;
			} else if (pathY > verticalBlocks - 2) {
				pathY = verticalBlocks - 3;
			}
			board[pathY][x] = true;
		}

		GCompound compound = new GCompound();
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				if (!board[y][x]) {
					GRect rect = new GRect(BLOCK_SIZE, BLOCK_SIZE);
					rect.setLocation(x * BLOCK_SIZE, y * BLOCK_SIZE);
					rect.setColor(Color.GREEN);
					rect.setFilled(true);
					compound.add(rect);
				}
			}
		}

		return compound;
	}

	/**
	 * Convenient method to create a new playing field.
	 * If a board is already present, remove it.
	 * Then, create a new board, offset its position, and add the player to the same compound.
	 * Also add the compound to the root pane.
	 * Do not change this method.
	 */
	protected void createAndAddNewBoardCompound() {
		if (board != null) {
			remove(board);
		}

		board = createBoard(HORIZONTAL_BLOCK_COUNT, VERTICAL_BLOCK_COUNT);
		board.setLocation(BOARD_OFFSET, BOARD_OFFSET);
		board.add(player);
		add(board);
	}
}
