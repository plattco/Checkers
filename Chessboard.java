
/**
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * CSE201 Project
 * 
 * @author JinkaiZeng Chessboard for checker game 2/10/2018
 */
public class Chessboard extends JFrame {
	public Toolkit tk = Toolkit.getDefaultToolkit();
	private Color dark = new Color(247, 218, 188);
	private Color light = new Color(240, 191, 133);
	private Color red = new Color(200, 100, 100);
	private Color green = new Color(100, 200, 100);

	private JPanel board = new JPanel();
	private JPanel[][] square = new JPanel[8][8];
	private Point initialClick;
	private int h;
	private int pX, pY;
	private int rX, rY;
	private int blkCount = 0, redCount = 0;

	// Import an image and change it to icon.
	private ImageIcon bcRaw = new ImageIcon("bchecker.png");
	private ImageIcon bkRaw = new ImageIcon("bking.png");
	private ImageIcon rcRaw = new ImageIcon("rchecker.png");
	private ImageIcon rkRaw = new ImageIcon("rking.png");

	private ImageIcon bChecker;
	private ImageIcon bKing;
	private ImageIcon rChecker;
	private ImageIcon rKing;

	private ArrayList<Checker> blkCheckers = new ArrayList<>();
	private ArrayList<Checker> redCheckers = new ArrayList<>();

	/**
	 * Constructor to create a new chessboard.
	 * 
	 */
	public Chessboard() {
		setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		createBoard();
		start();
		// createButton();
		// createLabel();
	}

	/**
	 * Create a chessboard with 64 small panels with different background color.
	 * 
	 */
	public void createBoard() {
		
		Dimension dim = tk.getDefaultToolkit().getScreenSize();
		board.setBounds(0, 0, (tk.getScreenSize().height / 5) * 4, (tk.getScreenSize().height / 5) * 4);
		board.setLocation(tk.getScreenSize().width / 2 - ((2 * tk.getScreenSize().height) / 5),
				tk.getScreenSize().height / 2 - (2 * tk.getScreenSize().height / 5));
		board.setLayout(new GridLayout(8, 8));

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				square[i][j] = new JPanel();
				square[i][j].setBackground(dark);
				if ((i + j) % 2 != 0) {
					square[i][j].setBackground(light);
				}
				board.add(square[i][j]);
			}
		}
		h = board.getHeight() / 8;
		board.addMouseListener(new MouseClickListener());
		add(board);
	}

	class MouseClickListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			// Get the location on board of mouse click.
			int x = (e.getX() / h);
			int y = (e.getY() / h);

			// System.out.println("x = " + x + " y = " + y);
			// System.out.println(occupied(x, y, blkCheckers));
			// System.out.println(occupied(x, y, redCheckers));

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e) {
			initialClick = e.getPoint();
			pX = (e.getX() / h);
			pY = (e.getY() / h);

			if (occupied(pX, pY, redCheckers)) {
				square[pY][pX].getComponent(1).setVisible(false);
				square[pY][pX].getComponent(2).setVisible(true);
				for (Checker c : redCheckers) {
					if (c.getColumn() == pX && c.getRow() == pY) {
						redCheckers.remove(c);
					}
				}
			} else if (occupied(pX, pY, blkCheckers)) {
				square[pY][pX].getComponent(0).setVisible(false);
				square[pY][pX].getComponent(2).setVisible(true);
				for (Checker c : blkCheckers) {
					if (c.getColumn() == pX && c.getRow() == pY)
						blkCheckers.remove(c);
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			rX = (e.getX() / h);
			rY = (e.getY() / h);

			if (occupied(rX, rY, redCheckers) || occupied(rX, rY, blkCheckers)) {
				if (blkCheckers.size() < 12) {
					square[pY][pX].getComponent(0).setVisible(true);
					square[pY][pX].getComponent(2).setVisible(false);
					blkCheckers.add(new Checker(pY, pX));
				} else if (redCheckers.size() < 12) {
					square[pY][pX].getComponent(1).setVisible(true);
					square[pY][pX].getComponent(2).setVisible(false);
					redCheckers.add(new Checker(pY, pX));
				}
			} else if (blkCheckers.size() < blkCount) {
				square[rY][rX].getComponent(0).setVisible(true);
				square[pY][pX].getComponent(2).setVisible(false);
				blkCheckers.add(new Checker(rY, rX));
			} else if (redCheckers.size() < redCount) {
				square[rY][rX].getComponent(1).setVisible(true);
				square[pY][pX].getComponent(2).setVisible(false);
				redCheckers.add(new Checker(rY, rX));
			}
		}
		
	/*	public void mouseDragged(MouseEvent e) {

			JLabel checkerLabel = new JLabel();
			if (occupied(pX, pY, redCheckers)) {
				checkerLabel.setIcon(rChecker);
			} else if (occupied(pX, pY, blkCheckers)) {
				checkerLabel.setIcon(bChecker);
			}
			board.add(checkerLabel);

			// Determine how much the mouse moved since the initial click
			int xMoved = (pX + e.getX()) - (pX + initialClick.x);
			int yMoved = (pY + e.getY()) - (pY + initialClick.y);

			// Move picture to this position
			int X = pX + xMoved;
			int Y = pY + yMoved;
			
			checkerLabel.setLocation(X, Y);
			checkerLabel.repaint();
		}*/
	}

	// Create labels around chessboard.
	public void createLabel() {
		// TO DO...
	}

	// Create buttons.
	public void createButton() {
		// TO DO...
	}

	public void start() {

		bChecker = new ImageIcon(bcRaw.getImage().getScaledInstance(h, h, java.awt.Image.SCALE_SMOOTH));
		bKing = new ImageIcon(bkRaw.getImage().getScaledInstance(h, h, java.awt.Image.SCALE_SMOOTH));
		rChecker = new ImageIcon(rcRaw.getImage().getScaledInstance(h, h, java.awt.Image.SCALE_SMOOTH));
		rKing = new ImageIcon(rkRaw.getImage().getScaledInstance(h, h, java.awt.Image.SCALE_SMOOTH));

		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				// Component 0: Black Checker
				JLabel checkerLabelBlack = new JLabel();
				square[x][y].add(checkerLabelBlack);
				checkerLabelBlack.setIcon(bChecker);
				checkerLabelBlack.setVisible(false);

				// Component 1: Red Checker
				JLabel checkerLabelRed = new JLabel();
				square[x][y].add(checkerLabelRed);
				checkerLabelRed.setIcon(rChecker);
				checkerLabelRed.setVisible(false);
				
				// Component 2: Red Color
				JLabel colorLabelRed = new JLabel();
				square[x][y].add(colorLabelRed);
				colorLabelRed.setBackground(red);
				colorLabelRed.setOpaque(true);
				
				// Component 3: Green Color
				JLabel colorLabelGreen = new JLabel();
				square[x][y].add(colorLabelGreen);
				colorLabelGreen.setBackground(green);
				colorLabelGreen.setVisible(false);
			}
		}

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j < 8; j++) {
				// Add black checker.
				if ((i + j) % 2 != 0) {
					Checker c = new Checker(i, j);
					square[i][j].getComponent(0).setVisible(true);
					blkCheckers.add(c);
					blkCount++;
				}
			}
		}
		for (int i = 5; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				// Add red checker.
				if ((i + j) % 2 != 0) {
					Checker c = new Checker(i, j);
					square[i][j].getComponent(1).setVisible(true);
					redCheckers.add(c);
					redCount++;
				}
			}
		}

	}

	public Checker select(int x, int y, ArrayList<Checker> ary) {
		int index = 0;
		for (int i = 0; i < ary.size(); i++) {
			if (ary.get(i).getRow() == x && ary.get(i).getColumn() == y) {
				index = i;
				break;
			}
		}
		return ary.get(index);
	}

	public void move(int x, int y) {

	}

	public boolean occupied(int x, int y, ArrayList<Checker> ary) {
		boolean result = false;
		for (int i = 0; i < ary.size(); i++) {
			if (ary.get(i).getColumn() == x && ary.get(i).getRow() == y)
				result = true;
		}
		return result;
	}

}
