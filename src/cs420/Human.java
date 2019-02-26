package cs420;

public class Human extends Player {
	/**
	 * Value indicating a human player
	 */
	public static final int HUMAN_PLAYER = -1;

	/**
	 * The connect-five game
	 */
	private Board game;

	/**
	 * Constructs a human player for the game
	 * 
	 * @param game
	 *            the connect-five game
	 */
	public Human(Board game) {
		this.game = game;
	}

	/**
	 * Moves the human player according to the user input
	 * 
	 * @param x
	 *            the x-coordinate of the move
	 * @param y
	 *            the y-coordinate of the move
	 */
	public void move(int x, int y) {
		super.move(game, HUMAN_PLAYER, x, y);
	}
}
