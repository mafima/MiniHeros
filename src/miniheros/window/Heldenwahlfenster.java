package miniheros.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Heldenwahlfenster  extends JFrame implements ActionListener,KeyListener{
	
	private JButton nachrechts;
	private JButton nachlinks;
	private JButton fertig;
	
	public static JScrollPane scroll;
	
	public Heldenwahlfenster() {
		this.setTitle("Heldenwahl");
		this.setSize(300,700);
		this.setLayout(null);
		scroll.setBounds(10,10,200,100);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

}
