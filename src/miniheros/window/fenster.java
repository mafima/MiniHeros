package miniheros.window;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import main.MiniHeros;
import miniheros.hero.Hero;
import miniheros.util.*;
import miniheros.window.ModifiedJEditorPane;
import miniheros.window.ModifiedOutputStream;

public class Fenster extends JFrame implements ActionListener,KeyListener{
	
	// Fenster wird initialisiert
	private static ModifiedJEditorPane log;
	private JTextField prompt;
	private JLabel Logo;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	
	public static JScrollPane scrollpane;
	
	private final PipedInputStream inPipe = new PipedInputStream();
	private final PipedInputStream outPipe = new PipedInputStream();
	private PrintWriter inWriter;
	
	/*
	 *                          .=========================.
	 *                          |                         |
	 *                          |          FENSTER        |
	 *                          |                         |
	 *                          *=========================*
	 *
	 */
	public Fenster() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		this.log = new ModifiedJEditorPane();//(50, 20);
		log.setSize(50, 20);
		this.prompt = new JTextField();

		System.setIn(inPipe);
		try {
			System.setOut(new PrintStream(new PipedOutputStream(outPipe), true));
			inWriter = new PrintWriter(new PipedOutputStream(inPipe), true);
		} catch (IOException e) {
			Help.p("MiniHeros Error: " + e);
			return;
		}

		PrintStream printstream = new PrintStream(new ModifiedOutputStream(log));
		System.setErr(printstream);

		(new SwingWorker<Void, String>() {
			protected Void doInBackground() throws Exception {
				Scanner s = new Scanner(outPipe);
				while (s.hasNextLine()) {
					String line = s.nextLine();
					publish(line);
				}
				return null;
			}

			@Override
			protected void process(java.util.List<String> chunks) {
				for (String line : chunks) {
					if (line.length() < 1) {
						continue;
					}

					Document doc = log.getDocument();
					try {
						doc.insertString(doc.getLength(), line.trim() + "\n", null);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					//log.append(line.trim() + "\n"); 
				}
			}
		}).execute();

		this.setTitle("MiniHeros 0.22 dev version");
		this.setSize(1035, 500);
		this.setLayout(null);
		// ICON SETZEN: setContentPane(new JLabel(new ImageIcon("C:\\Users\\Manuel\\Documents\\GitHub\\MiniHeros\\src\\HeroPack\\server-icon.png")));
		setContentPane(new JLabel());
		Logo = new JLabel();

		scrollpane = new JScrollPane(log);
		scrollpane.setBounds(10, 10, 1000, 380);
		log.setBackground(Color.DARK_GRAY);
		log.setForeground(Color.white);
		prompt.setBackground(Color.DARK_GRAY);
		prompt.setForeground(Color.cyan);
		this.setBackground(Color.GRAY);

		this.button1 = new JButton("-10% alle Werte!");
		this.button2 = new JButton("+10% alle Werte!");
		this.button3 = new JButton("+20% HEAT");

		this.log.setEditable(false);
		this.log.setBounds(10, 10, 1220, 600);
		this.prompt.setBounds(10, 400, 500, 20);
		this.Logo.setBounds(120, 520, 260, 40);
		this.button1.setBounds(520, 400, 120, 30);
		this.button1.addActionListener(this);
		this.button2.setBounds(660, 400, 120, 30);
		this.button2.addActionListener(this);
		this.button3.setBounds(800, 400, 100, 30);
		this.button3.addActionListener(this);

		this.setVisible(true);
		this.add(Logo);
		this.add(button1);
		this.add(button2);
		this.add(button3);

		prompt.addKeyListener(this);

		this.add(scrollpane);
		this.add(prompt);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void execute() {
		String text = prompt.getText();
		prompt.setText("");
		Help.p(text);
		inWriter.println(text.trim().replaceAll("\r\n", ""));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			Hero held1 = MiniHeros.getHhero1();
			Hero held2 = MiniHeros.getHhero2();
			
			held1.reA(0.9);
			held1.reG(0.9);
			held1.reH(0.9);
			held1.reM(0.9);
			held1.reL(0.9);
			held1.reR(0.9);
			held2.reA(0.9);
			held2.reG(0.9);
			held2.reH(0.9);
			held2.reM(0.9);
			held2.reL(0.9);
			held2.reR(0.9);
			MiniHeros.werteanz(held1);
			MiniHeros.werteanz(held2);
		} else if (e.getSource() == button2) {
			Hero held1 = MiniHeros.getHhero1();
			Hero held2 = MiniHeros.getHhero2();
			
			held1.reA(1.1);
			held1.reG(1.1);
			held1.reH(1.1);
			held1.reM(1.1);
			held1.reL(1.1);
			held1.reR(1.1);
			held2.reA(1.1);
			held2.reG(1.1);
			held2.reH(1.1);
			held2.reM(1.1);
			held2.reL(1.1);
			held2.reR(1.1);
			MiniHeros.werteanz(held1);
			MiniHeros.werteanz(held2);
		} else if (e.getSource() == button3) {
			MiniHeros.heat = MiniHeros.heat*1.2;
			Help.p("HEAT steigt auf: "+MiniHeros.heat);
		}

		/*if(e.getSource() == Logo) {
         log.setText("Jesus");
         } else if(e.getSource() == button2) {
         log.setText("Gott");
         }
		 */
		
		// helden werden importiert;
		
		
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			execute();
		}

	}

	@Override
	public void keyReleased(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			execute();
		}
	}

	@Override
	public void keyTyped(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			execute();
		}
	}
}
