import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/*
 * This class contains the code for about window.
 */
public class About extends JDialog {

	/**
	 *
	 */
	private static final long serialVersionUID = 6831633305129749469L;
	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public About() {
		setTitle("About");
		setBounds(100, 100, 466, 378);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		{
			JEditorPane dtrpneasyPasswordManager = new JEditorPane();
			dtrpneasyPasswordManager.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==27){
						MainWindow.aboutDialog.dispose(); //Close the dialog on pressing escape button
					}
				}
			});
			dtrpneasyPasswordManager.setContentType("text/html");
			dtrpneasyPasswordManager.setBackground(UIManager.getColor("Button.background"));
			dtrpneasyPasswordManager.setEditable(false);
			//Setting the message to be displayed
			dtrpneasyPasswordManager.setText("<div style=\"font-family:Arial;font-size:10px;border-bottom:1px solid #c0c0c0;padding-bottom:3px;\">\r\n<b>Jozlan Password Manager 1.0</b><br/>\r\nA free and open source tool written purely in JAVA. It solves the purpose of managing dozens of online usernames and passwords. <br/>\r\nCopyright \u00A9 2016  SemiCode Inc.\r\n<br/><br/>\r\n<b>License</b><br/>\r\nThis program is free software; you can redistribute it and/or modify\r\nit under the terms of the GNU General Public License as published by\r\nthe Free Software Foundation; either version 1, or (at your option)\r\nany later version.\r\n\r\n<br/><br/>This program is distributed in the hope that it will be useful,\r\nbut WITHOUT ANY WARRANTY; without even the implied warranty of\r\nMERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\r\nGNU General Public License for more details.<br/><br/>\r\n<b>Contact Details</b><br/>\r\nAuthor: Mohamed Saif Eldeen <br/>\r\nEmail: mscoder12@gmail.com<br/>\r\nWebsite: www.semicode.org\r\n</div>");
			contentPanel.add(dtrpneasyPasswordManager);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent arg0) {
						if(arg0.getKeyChar()=='\n' || arg0.getKeyChar()==' ' || arg0.getKeyCode()==27){
							MainWindow.aboutDialog.dispose(); //Do actions on pressing ENTER, SPACE and ESCAPE
						}
					}
				});
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						MainWindow.aboutDialog.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
