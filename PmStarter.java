import java.io.File;
import java.io.IOException;
import javax.swing.JDialog;

/*
 * This class contains the main() function. It opens the MainWindow.
 */
import java.awt.*;
import javax.swing.*;
public class PmStarter{
	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static boolean isAuthenticated = false;
	public static String pd="";
	public static MainWindow mainFrame;

	public static void main(String[] args) throws IOException, ClassNotFoundException , Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		mainFrame = new MainWindow();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        File pdFile = new File(System.getProperty("user.dir")+"\\settings.dat");
		if(!pdFile.exists()){
			AddUpdatePassword d1 = new AddUpdatePassword();
			AddUpdatePassword.oldPassword.setVisible(false);
			AddUpdatePassword.lblOldPassword.setVisible(false);
			MainWindow.newPdDialog = new JDialog(PmStarter.mainFrame,"Jozlan Master Password", true);
			MainWindow.newPdDialog.setSize(d1.getSize());
			MainWindow.newPdDialog.setContentPane(d1.getContentPane());
			MainWindow.newPdDialog.setLocationRelativeTo(PmStarter.mainFrame);
			MainWindow.newPdDialog.setVisible(true);
		}
		else if(!PmStarter.isAuthenticated){
			PasswordAuthentication d1 = new PasswordAuthentication();
			MainWindow.newPdDialog = new JDialog(PmStarter.mainFrame,"Login", true);
			MainWindow.newPdDialog.setSize(d1.getSize());
			MainWindow.newPdDialog.setContentPane(d1.getContentPane());
			MainWindow.newPdDialog.setLocationRelativeTo(PmStarter.mainFrame);
			MainWindow.newPdDialog.setVisible(true);
			MainWindow.loadMyCredentials();
		}
		MainWindow.btnNewButton.requestFocus();
	}

}
