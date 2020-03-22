
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class MenuBar extends Rules implements ActionListener {

	JFrame tempframe;
	
	public JMenuBar createMenuBar(JFrame frame) {

		tempframe = frame;
		
		JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
 
        //Create the menu bar.
        menuBar = new JMenuBar();
 
        //Build the first menu.
        menu = new JMenu("A Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program");
        menuBar.add(menu);
 
        //a group of JMenuItems
        menuItem = new JMenuItem("Rules",KeyEvent.VK_T);
        menuItem.addActionListener(this);
        menuItem.setActionCommand("openFrame");
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Close",KeyEvent.VK_T);
        menuItem.addActionListener(this);
        menuItem.setActionCommand("end");
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Restart",KeyEvent.VK_T);
        menuItem.addActionListener(this);
        menuItem.setActionCommand("restart");
        menu.add(menuItem);

        return menuBar;

	}
	
	public JMenuBar createMenuBar() {
		
		JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
 
        //Create the menu bar.
        menuBar = new JMenuBar();
 
        //Build the first menu.
        menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program");
        menuBar.add(menu);
 
        //a group of JMenuItems
        menuItem = new JMenuItem("Rules",KeyEvent.VK_T);
        menuItem.addActionListener(this);
        menuItem.setActionCommand("openFrame");
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Close",KeyEvent.VK_T);
        menuItem.addActionListener(this);
        menuItem.setActionCommand("end");
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Restart",KeyEvent.VK_T);
        menuItem.addActionListener(this);
        menuItem.setActionCommand("restart");
        menu.add(menuItem);

        return menuBar;

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "openFrame")
		{
			JFrame yeet = createFrame();
			yeet.setVisible(true);
		}
		if (e.getActionCommand() == "end")
		{
			tempframe.dispose();
			tempframe = null;
			OpeningScreen os = new OpeningScreen();
			JFrame frame = new JFrame();
			frame = os.create();
			frame.setVisible(true);
		}
		if (e.getActionCommand() == "restart")
		{
			tempframe.dispose();
			tempframe = null;
			tempframe = new Chessboard();
			tempframe.setJMenuBar(createMenuBar());
			tempframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			tempframe.setVisible(true);
		}
		
		
	}
	
	
}
