import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/*
 * This method contains the code for authenticating the user with showing the master password dialog box
 */
public class PasswordAuthentication extends JDialog {
	/**
	 *
	 */
	private static final long serialVersionUID = -3810938356512600725L;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JButton okButton;
	/**
	 * Create the dialog.
	 */
	public PasswordAuthentication() {
		setTitle("Login");
		setBounds(100, 100, 252, 160);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblNewLabel = new JLabel("Enter master password");
		}
		{
			passwordField = new JPasswordField();
			passwordField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {
					if(arg0.getKeyChar()=='\n'){
						okButton.doClick();
						okButtonPressed();
					}
					else if(arg0.getKeyCode()==27){
						MainWindow.newPdDialog.dispose();
					}
				}
			});
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
					.addGap(14))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				{
					JButton cancelButton = new JButton("Cancel");
					cancelButton.addKeyListener(new KeyAdapter() {
						@Override
						public void keyPressed(KeyEvent e) {
							if(e.getKeyCode()==27 || e.getKeyChar()=='\n' || e.getKeyChar()==' '){
								MainWindow.newPdDialog.dispose();
							}
						}
					});
					cancelButton.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							MainWindow.newPdDialog.dispose();
						}
					});
					okButton = new JButton("OK");
					okButton.addKeyListener(new KeyAdapter() {
						@Override
						public void keyPressed(KeyEvent e) {
							if(e.getKeyCode()==27){
								MainWindow.newPdDialog.dispose();
							}
							else if(e.getKeyChar()=='\n' || e.getKeyChar()==' '){
								okButtonPressed();
							}
						}
					});
					okButton.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
								okButtonPressed();
						}
					});
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
					cancelButton.setActionCommand("Cancel");
					buttonPane.add(cancelButton);
				}
			}
		}
	}

	//Decode the master password from the file by using the password given by user
	public static String decodeMyPassword(int password[],char guestPassword[]){
		int cumulative=0;
		StringBuilder userDecryptedPassWord= new StringBuilder("");
		for(int i=0;i<guestPassword.length;i++){
				cumulative+=guestPassword[i];
				int posnToShift = guestPassword[i]%10;
				int shiftDir = guestPassword[i]%2;
				int intToDecode=0;

				if(shiftDir==0){
					intToDecode = (int)password[cumulative]+posnToShift;
				}
				else{
					intToDecode = (int)password[cumulative]-posnToShift;
				}
				userDecryptedPassWord.append((char)intToDecode);
		}
		return userDecryptedPassWord.toString();
	}

	//This method is invoked when the OK button is clicked
	public void okButtonPressed(){
		try{
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\settings.dat");
	        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	        MasterPasswordDTO mp = (MasterPasswordDTO) objectInputStream.readObject();
	        int password[]=mp.getPassword();
	        if(mp.getLength()==decodeMyPassword(password,passwordField.getPassword()).length() && decodeMyPassword(password,passwordField.getPassword()).equals(String.valueOf(passwordField.getPassword()))){
	        	PmStarter.isAuthenticated=true;
	        	PmStarter.pd=String.valueOf(passwordField.getPassword());
	        	MainWindow.loadMyCredentials();
	        	MainWindow.newPdDialog.dispose();
	        }
	        else{
	        	JOptionPane.showMessageDialog(null, "Sorry, password did not match");
	        }
	        fileInputStream.close();
	        objectInputStream.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

}
