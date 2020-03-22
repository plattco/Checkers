import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Rules extends JFrame {
	public Toolkit tk = Toolkit.getDefaultToolkit();
	
	public Rules() {
		setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		createFrame();
	}
	
	public JFrame createFrame() {
		JFrame rules = new JFrame();
		JTextArea text = new JTextArea(
				"Checkers is a board game played between two players, who alternate moves. The player who cannot move, because he has no pieces, or because all of his pieces are blocked, loses the game." +

				"The board is square, with sixty-four smaller squares, arranged in an 8x8 grid. The smaller squares are alternately light and dark colored, in the famous checker-board pattern. The game of checkers is played on the dark squares. Each player has a dark square on his far left and a light square on his far right." +

				"The pieces are Red and Black. The pieces are placed on the dark squares of the board." +

				"The starting position is with each player having twelve pieces, on the twelve dark squares closest to his edge of the board." +

				"\n\nMoving: A piece which is not a king can move one square, diagonally, forward. A king can move diagonally, forward or backward. A piece (piece or king) can only move to a vacant square. A move can also consist of one or more jumps (next paragraph)." +

				"\n\nJumping: You capture an opponents piece by jumping over it, diagonally, to the adjacent vacant square beyond it. A king can jump diagonally, forward or backward. A piece which is not a king, can only jump diagonally forward. You can make a multiple jump, with one piece only, by jumping to empty square to empty square. You can only jump one piece, with any given jump. But you can jump several pieces, with a move of several jumps. " +
				
				"You remove the jumped pieces from the board. You cannot jump your own piece. You cannot jump the same piece twice, in the same move. If you can jump, you must. " +
				
				"And, a multiple jump must be completed. You cannot stop part way through a multiple jump. If you have a choice of jumps, you can choose among them, regardless of whether some of them are multiple, or not. A piece, whether it is a king or not, can jump a king." +

				"\n\nKinging: When a piece reaches the last row (the King Row), it becomes a King. A second checker is place on top of that one, by the opponent. A piece that has just kinged, cannot continue jumping pieces, until the next move." +

				"\n\nRed moves first. The players take turns moving. You can make only one move per turn. You must move. If you cannot move, you lose. Players normally choose colors at random, and then alternate colors in subsequent games.");
		
		text.setFont(new Font("Times New Roman",Font.PLAIN,60));
		
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(text);
		Dimension dim = tk.getDefaultToolkit().getScreenSize();
		rules.setBounds(40, 40, (tk.getScreenSize().height/5)*4, (tk.getScreenSize().height/5)*4);
		rules.setLocation(tk.getScreenSize().width/2-((2*tk.getScreenSize().height)/5),tk.getScreenSize().height/2-(2*tk.getScreenSize().height/5));
		rules.add(scroll);
		return rules;
	}
}
