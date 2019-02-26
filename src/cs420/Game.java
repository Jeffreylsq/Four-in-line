package cs420;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

/**
 * The Game class implements the client code and creates the main window for the
 * game.
 * 
 * @author Jeffrey Wei
 *
 */
public class Game {
	/**
	 * The number of pixels of the main window
	 */
	private static final int FRAME_WIDTH = 457;
	private static final int FRAME_HEIGHT = 483;

	/**
	 * Initializes the game components and implements a mouse listener that
	 * responds to user input for moves
	 */
	private void run() {
		final Board board = new Board();
		final Human human = new Human(board);
		final AI ai = new AI(board);

		JFrame frame = new JFrame("Connect Five");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final BoardComponent component = new BoardComponent(board);
		component.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getY() / BoardComponent.SQUARE_SIZE;
				int y = e.getX() / BoardComponent.SQUARE_SIZE;
				if (board.getBoard(true)[x][y] >= 0 && board.getWinner() == 0) {
					human.move(x, y);
					if (board.getWinner() == 0)
						ai.move();
					component.repaint();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		frame.add(component);
		frame.setVisible(true);
	}

	
	public static void main(String[] args) {
		new Game().run();
	}
}