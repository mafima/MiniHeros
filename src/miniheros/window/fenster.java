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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import main.Game;
import main.Textarena;
import miniheros.hero.Hero;
import miniheros.hero.Itembox;
import miniheros.util.*;

public class Fenster extends JFrame implements ActionListener, KeyListener {

    // Fenster wird initialisiert
    private static ModifiedJEditorPane consolePane;
    private JTextField consoleInputBox;
    private JLabel Logo;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton itemchance;

    /**
     * Objects for the main frame
     *
     * e.g. all JPanels, Textbars, etc.
     *
     */
    private JPanel hero1Panel;
    private JPanel hero2Panel;
    private JPanel mainConsole;

    private JTextPane hero1Text;
    private JTextPane hero2Text;

    /**
     * end of main frame objects...
     */
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

        this.consolePane = new ModifiedJEditorPane();
        consolePane.setSize(50, 20);
        this.consoleInputBox = new JTextField();

        System.setIn(inPipe);
        try {
            System.setOut(new PrintStream(new PipedOutputStream(outPipe), true));
            inWriter = new PrintWriter(new PipedOutputStream(inPipe), true);
        } catch (IOException e) {
            Help.p("MiniHeros Error: " + e);
            return;
        }
        PrintStream printstream = new PrintStream(new ModifiedOutputStream(consolePane));
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

                    Document doc = consolePane.getDocument();
                    try {
                        doc.insertString(doc.getLength(), line.trim() + "\n", null);
                    } catch (BadLocationException e) {
                        e.printStackTrace();
                    }

                    //log.append(line.trim() + "\n");
                }
            }
        }).execute();

        initMainPanes();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ICON SETZEN: setContentPane(new JLabel(new ImageIcon("C:\\Users\\Manuel\\Documents\\GitHub\\MiniHeros\\src\\HeroPack\\server-icon.png")));#
    }

    private void addConsoleToFrame() {
        this.removeAll();

        setContentPane(new JLabel());
        Logo = new JLabel();

        scrollpane = new JScrollPane(consolePane);
        scrollpane.setBounds(10, 10, 1300, 480);
        consolePane.setBackground(Color.DARK_GRAY);
        consolePane.setForeground(Color.WHITE);
        consoleInputBox.setBackground(Color.DARK_GRAY);
        consoleInputBox.setForeground(Color.cyan);
        this.setBackground(Color.GRAY);

        this.button1 = new JButton("-10% alle Werte!");
        this.button2 = new JButton("+10% alle Werte!");
        this.button3 = new JButton("+20% HEAT");
        this.itemchance = new JButton("+10% ITEMCHANCE");

        this.consoleInputBox.setBounds(10, 500, 500, 30);
        this.Logo.setBounds(100, 620, 260, 40);
        this.button1.setBounds(520, 500, 120, 30);
        this.button1.addActionListener(this);
        this.button2.setBounds(660, 500, 120, 30);
        this.button2.addActionListener(this);
        this.button3.setBounds(800, 500, 120, 30);
        this.button3.addActionListener(this);
        this.itemchance.setBounds(940, 500, 150, 30);
        this.itemchance.addActionListener(this);

        this.setVisible(true);
        this.add(Logo);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(itemchance);

        consoleInputBox.addKeyListener(this);

        this.add(scrollpane);
        this.add(consoleInputBox);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void execute() {
        String text = consoleInputBox.getText();
        consoleInputBox.setText("");
        Help.p(text);
        inWriter.println(text.trim().replaceAll("\r\n", ""));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            Hero held1 = Textarena.getHhero1();
            Hero held2 = Textarena.getHhero2();

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
            Anzeigen.stats(held1);
            Anzeigen.stats(held2);
        } else if (e.getSource() == button2) {
            Hero held1 = Textarena.getHhero1();
            Hero held2 = Textarena.getHhero2();

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
            Anzeigen.stats(held1);
            Anzeigen.stats(held2);
        } else if (e.getSource() == button3) {
        	Game.heat += 0.2;
            Help.p("HEAT steigt auf: " + Game.heat);
        } else if (e.getSource() == itemchance) {
            Itembox.chance += 0.1;
            Help.p("Itemchance steigt auf: " + Game.heat);
        }

        /*if(e.getSource() == Logo) {
         log.setText("Jesus");
         } else if(e.getSource() == button2) {
         log.setText("Gott");
         }
         */
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

    private void initMainPanes() {

        //Stuff for the main frame
        this.setTitle("Textarena v0.105 made by Mafima");
        this.setSize(1500, 700);
        this.setLayout(null);

        //Panels...
        this.hero1Panel = new JPanel();
        this.hero2Panel = new JPanel();
        this.mainConsole = new JPanel();

        this.hero1Panel.setSize(300, 640);
        this.hero1Panel.setBounds(10, 10, 300, 640);
        this.hero1Panel.setLayout(null);
        hero1Panel.setBackground(Color.DARK_GRAY);
        hero1Panel.setForeground(Color.WHITE);

        //init hero1 text field
        this.hero1Text = new JTextPane();
        this.hero1Text.setLayout(null);
        this.hero1Text.setSize(290, 640);
        this.hero1Text.setEditable(false);
        this.hero1Text.setBorder(new TitledBorder("Spieler 1"));
        hero1Text.setBackground(Color.DARK_GRAY);
        hero1Text.setForeground(Color.WHITE);

        this.hero2Panel.setSize(300, 640);
        this.hero2Panel.setBounds(1100, 10, 300, 640);
        this.hero2Panel.setLayout(null);
        hero2Panel.setBackground(Color.DARK_GRAY);
        hero2Panel.setForeground(Color.WHITE);

        //init hero1 text field
        this.hero2Text = new JTextPane();
        this.hero2Text.setLayout(null);
        this.hero2Text.setSize(290, 640);
        this.hero2Text.setEditable(false);
        this.hero2Text.setBorder(new TitledBorder("Spieler 2"));
        hero2Text.setBackground(Color.DARK_GRAY);
        hero2Text.setForeground(Color.WHITE);

        for (int i = 0; i < 6; i++) {
            switch (i) {
                default:
                    break;
                case 0:
                    this.hero1Text.setText("Name: -");
                    this.hero2Text.setText("Name: -");
                    break;
                case 1:
                    this.hero1Text.setText(this.hero1Text.getText() + "\n" + "Held: -");
                    this.hero2Text.setText(this.hero2Text.getText() + "\n" + "Held: -");
                    break;
                case 2:
                    this.hero1Text.setText(this.hero1Text.getText() + "\n" + "Angriff: -");
                    this.hero2Text.setText(this.hero2Text.getText() + "\n" + "Angriff: -");
                    break;
                case 3:
                    this.hero1Text.setText(this.hero1Text.getText() + "\n" + "Geschick: -");
                    this.hero2Text.setText(this.hero2Text.getText() + "\n" + "Geschick: -");
                    break;
                case 4:
                    this.hero1Text.setText(this.hero1Text.getText() + "\n" + "Hirn: -");
                    this.hero2Text.setText(this.hero2Text.getText() + "\n" + "Hirn: -");
                    break;
                case 5:
                    this.hero1Text.setText(this.hero1Text.getText() + "\n" + "Magie: -");
                    this.hero2Text.setText(this.hero2Text.getText() + "\n" + "Magie: -");
                    break;
                case 6:
                    this.hero1Text.setText(this.hero1Text.getText() + "\n" + "Leben: -");
                    this.hero2Text.setText(this.hero2Text.getText() + "\n" + "Leben: -");
                    break;
            }

        }
        this.hero1Panel.add(this.hero1Text);
        this.hero2Panel.add(this.hero2Text);

        this.mainConsole.setBounds(330, 10, 750, 630);
        this.mainConsole.setLayout(null);
        mainConsole.setBackground(Color.lightGray);

        setContentPane(new JLabel());
        Logo = new JLabel();

        scrollpane = new JScrollPane(consolePane);
        scrollpane.setBounds(340, 10, 730, 580);
        scrollpane.setBackground(Color.DARK_GRAY);
        scrollpane.setForeground(Color.WHITE);
        consolePane.setBackground(Color.DARK_GRAY);
        consolePane.setForeground(Color.WHITE);
        consoleInputBox.setBackground(Color.DARK_GRAY);
        consoleInputBox.setForeground(Color.cyan);
        this.setBackground(Color.GRAY);

        this.consoleInputBox.setBounds(340, 600, 730, 30);
        this.Logo.setBounds(100, 620, 260, 40);

        this.add(Logo);
        consoleInputBox.addKeyListener(this);

        this.add(scrollpane);
        this.add(consoleInputBox);

        //adding main panes...
        this.add(this.hero1Panel);
        this.add(this.hero2Panel);
        this.add(this.mainConsole);

        this.setVisible(true);

    }
}
