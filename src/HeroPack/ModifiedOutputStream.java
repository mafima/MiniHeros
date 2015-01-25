package HeroPack;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class ModifiedOutputStream extends OutputStream {
	
	private JEditorPane textarea;
	
	public ModifiedOutputStream(JEditorPane textarea) {
		this.textarea = textarea;
	}

	@Override
	public void write(int b) throws IOException {
		// TODO Auto-generated method stub
		
		//textarea.append(String.valueOf((char)b));
		Document doc = textarea.getDocument();	
        try {
			doc.insertString(doc.getLength(), String.valueOf((char)b), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textarea.setCaretPosition(textarea.getDocument().getLength());
		
	}
	

}
