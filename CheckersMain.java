import javax.swing.JFrame;

/**CSE201 Project
 * @author JinkaiZeng
 * main for checker game
 * 2/10/2018
 */
public class CheckersMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OpeningScreen os = new OpeningScreen();
		JFrame frame = os.create();
		//JFrame frame = new Chessboard();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
