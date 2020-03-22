import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpeningScreen extends JFrame implements ActionListener{
	public Toolkit tk = Toolkit.getDefaultToolkit();
	
	public JFrame thisFrame;
	
	public JFrame create()
	{
		
		
		JFrame frame = new JFrame();
		JPanel panel1 = new JPanel(new GridLayout(3,1,20,20));

		
		
		Dimension dim = tk.getDefaultToolkit().getScreenSize();
		frame.setBounds(40, 40, (tk.getScreenSize().height/5)*4, (tk.getScreenSize().height/5)*4);
		frame.setLocation(tk.getScreenSize().width/2-((2*tk.getScreenSize().height)/5),tk.getScreenSize().height/2-(2*tk.getScreenSize().height/5));
		panel1.setBackground(Color.LIGHT_GRAY);
		
		
		
		Box box = Box.createVerticalBox();
		
		
		JButton button1 = new JButton("Rules");
		button1.setFont(new Font("Times New Roman",Font.BOLD, 60));
		JButton button2 = new JButton("Start Game");
		button2.setFont(new Font("Times New Roman",Font.BOLD, 60));
		JButton button3 = new JButton("Close");
		button3.setFont(new Font("Times New Roman",Font.BOLD, 60));
		
		
		box.add(button1);
		button1.addActionListener(this);
		button1.setActionCommand("Rules");
		box.add(button2);
		button2.addActionListener(this);
		button2.setActionCommand("Start Game");
		box.add(button3);
		button3.addActionListener(this);
		button3.setActionCommand("Close");
		
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		
		
		frame.add(panel1);
		thisFrame = frame;
		
		
		
		return frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Rules")
		{
			Rules rules = new Rules();
			JFrame frame = new JFrame();
			frame = rules.createFrame();
			frame.setVisible(true);
		}
		if (e.getActionCommand() == "Start Game")
		{
			JFrame tempframe = new JFrame();
			MenuBar menu = new MenuBar();
			tempframe = new Chessboard();
			tempframe.setJMenuBar(menu.createMenuBar(tempframe));
			tempframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			tempframe.setVisible(true);
			thisFrame.dispose();
			thisFrame = null;
		}
		if (e.getActionCommand() == "Close")
		{
			thisFrame.dispose();
			thisFrame = null;
			System.exit(0);
		}
	}
	
}
