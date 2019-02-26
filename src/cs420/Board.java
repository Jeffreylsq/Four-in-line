package cs420;

import java.util.Arrays;


public class Board {
	/**
	 * Number of rows and columns of the game board
	 */
	public static final int BOARD_SIZE =8;

	/**
	 * Stores a human and AI version of the game board as well as the game
	 * winner
	 */
	private int[][] human, ai;
	private int winner;

	/**
	 * Constructs a connect-five game board
	 */
	public Board() {
		human = new int[BOARD_SIZE][BOARD_SIZE];
		ai = new int[BOARD_SIZE][BOARD_SIZE];
		winner = 0;
	}


	@Override
	public Board clone() {
		Board copy = new Board();
		for (int i = 0; i < BOARD_SIZE; i++) {
			copy.getBoard(true)[i] = Arrays.copyOf(getBoard(true)[i],
					BOARD_SIZE);
			copy.getBoard(false)[i] = Arrays.copyOf(getBoard(false)[i],
					BOARD_SIZE);
		}
		copy.setWinner(winner);
		return copy;
	}

	/**
	 * Gets a human or AI version of the game board
	 * 
	 * @param isHuman
	 *            true if the desired board is human, false otherwise
	 * @return the desired version of the game board
	 */
	public int[][] getBoard(boolean isHuman) {
		return isHuman ? human : ai;
	}

	/**
	 * Gets the current value of the game board
	 * 
	 * @return the current value of the game board
	 */
	public int getBoardValue() {
		int value = 0;
		for (int i = 0; i < BOARD_SIZE; i++)
			for (int j = 0; j < BOARD_SIZE; j++)
				if (human[i][j] >= 0)
					value += ai[i][j] - human[i][j];
		return value;
	}

	/**
	 * Gets the winner of the game
	 * 
	 * @return a value indicating the winning player of the game
	 */
	public int getWinner() {
		return winner;
	}

	/**
	 * Checks if the given coordinate is within the bounds of the game board
	 * 
	 * @param x
	 *            the given x-coordinate
	 * @param y
	 *            the given y-coordinate
	 * @return true if the move is within the bounds, false otherwise
	 */
	public static boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && x < BOARD_SIZE && y < BOARD_SIZE;
	}

	/**
	 * Checks if the given move is valid
	 * 
	 * @param x
	 *            the given x-coordinate
	 * @param y
	 *            the given y-coordinate
	 * @return true if the move is valid, false otherwise
	 */
	public boolean isValidMove(int x, int y) {
		return isValid(x, y) && human[x][y] >= 0;
	}

	/**
	 * Moves the given player to the desired coordinate
	 * 
	 * @param player
	 *            a value indicating if the player is human or AI
	 * @param x
	 *            the given x-coordinate
	 * @param y
	 *            the given y-coordinate
	 */
	public void move(int player, int x, int y) {
		human[x][y] = player;
		ai[x][y] = player;
	}

	/**
	 * Sets the given coordinate to the desired value
	 * 
	 * @param player
	 *            a value indicating if the player is human or AI
	 * @param x
	 *            the given x-coordinate
	 * @param y
	 *            the given y-coordinate
	 * @param value
	 *            the desired value
	 */
	public void setValue(int player, int x, int y, int value) {
		if (player == Human.HUMAN_PLAYER)
			human[x][y] = value;
		else if (player == AI.AI_PLAYER)
			ai[x][y] = value;
	}

	/**
	 * Sets the winner to the given player
	 * 
	 * @param player
	 *            a value indicating if the player is human or AI
	 */
	public void setWinner(int player) {
		winner = player;
	}

	/**
	 * Creates a String representation of the game board
	 * 
	 * @return a String representing the game board
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String print = "   ";
		for (int i = 0; i < BOARD_SIZE; i++)
			print += String.format("%3d", i);
		print += "\n";

		for (int i = 0; i < BOARD_SIZE; i++) {
			print += String.format("%3d", i);
			for (int j = 0; j < BOARD_SIZE; j++)
				print += String.format("%3s", human[i][j] >= 0 ? "-"
						: human[i][j] == Human.HUMAN_PLAYER ? "X" : "O");
			print += "\n";
		}

		return print;
	}
}