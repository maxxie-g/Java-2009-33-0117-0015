package Prime;

import javax.swing.JApplet;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JProgressBar;

public class window extends JApplet {
	private JTextField textField;

	/**
	 * Create the applet.
	 */
	public window() {
		getContentPane().setEnabled(false);
		getContentPane().setLayout(new MigLayout("", "[grow][][][][][][][][][][][][]", "[][][][][][][][][][]"));
		
		textField = new JTextField();
		getContentPane().add(textField, "cell 0 0 12 1,growx");
		textField.setColumns(10);
		
		JButton btnTest = new JButton("test");
		getContentPane().add(btnTest, "cell 12 0");
		
		JProgressBar progressBar = new JProgressBar();
		getContentPane().add(progressBar, "cell 0 9 13 1");

	}

}
