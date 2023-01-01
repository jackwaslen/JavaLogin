package loginProject;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Jack Waslen 12/2022
 *
 */
public class GUI implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JLabel createUser;
    private static JPasswordField passwordText;
    private static JButton createButton;
    private static JButton createNavButton;
    private static JButton loginButton;
    private static JButton loginNavButton;
    private static JLabel loginPopup;
    private static JLabel createPopup;
    private static JLabel userLoginLabel;
    private static JLabel userPasswordLabel;
    private static JPanel createPanel = new JPanel();
    private static JFrame createFrame = new JFrame();
    private static JPanel loginPanel = new JPanel();
    private static JFrame loginFrame = new JFrame();

    public static LoginInfo displayUserCreation() {

	createFrame.setTitle("Create Account");
	createFrame.setSize(300, 200);
	createFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	createFrame.add(createPanel);

	createPanel.setLayout(null);
	createUser = new JLabel("Create User:");
	createUser.setBounds(10, 0, 120, 25);
	createUser.setFont(new Font("Arial Bold", Font.BOLD, 17));
	createPanel.add(createUser);

	userLabel = new JLabel("Username: ");
	userLabel.setBounds(10, 30, 80, 25);
	createPanel.add(userLabel);

	userText = new JTextField(20);
	userText.setBounds(100, 25, 190, 35);
	createPanel.add(userText);

	userLoginLabel = new JLabel(
		"<html>*username must have 1 uppercase letter,<br>  1 digit and be 6 or more characters.</html>");
	userLoginLabel.setBounds(105, 55, 220, 25);
	userLoginLabel.setFont(new Font("Arial Bold", Font.ITALIC, 8));
	createPanel.add(userLoginLabel);

	userPasswordLabel = new JLabel(
		"<html>*All passwords must have 1 special character,<br>  2 digits and be 6 or more characters.</html>");
	userPasswordLabel.setBounds(105, 105, 220, 25);
	userPasswordLabel.setFont(new Font("Arial Bold", Font.ITALIC, 8));
	createPanel.add(userPasswordLabel);

	passwordLabel = new JLabel("Password: ");
	passwordLabel.setBounds(10, 80, 80, 25);
	createPanel.add(passwordLabel);

	passwordText = new JPasswordField();
	passwordText.setBounds(100, 75, 190, 35);
	createPanel.add(passwordText);

	createButton = new JButton("Create User");
	createButton.setBounds(30, 125, 115, 35);
	createButton.setFont(new Font("Arial Bold", Font.BOLD, 14));
	createButton.addActionListener(new GUI());
	createPanel.add(createButton);

	loginNavButton = new JButton("Back to Login");
	loginNavButton.setBounds(150, 125, 115, 35);
	loginNavButton.addActionListener(new GUI());
	createPanel.add(loginNavButton);

	createPopup = new JLabel("");
	createPopup.setBounds(10, 110, 300, 25);
	createPanel.add(createPopup);

	createFrame.setVisible(true);
	return new LoginInfo(userText.toString(), passwordText.toString());
    }

    public static LoginInfo displayLoginPage() {

	loginFrame.setTitle("Login Page");
	loginFrame.setSize(300, 200);
	loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	loginFrame.add(loginPanel);

	loginPanel.setLayout(null);
	userLabel = new JLabel("Username: ");
	userLabel.setBounds(10, 25, 80, 25);
	loginPanel.add(userLabel);

	userText = new JTextField(20);
	userText.setBounds(100, 20, 190, 35);
	loginPanel.add(userText);

	passwordLabel = new JLabel("Password: ");
	passwordLabel.setBounds(10, 75, 80, 25);
	loginPanel.add(passwordLabel);

	passwordText = new JPasswordField();
	passwordText.setBounds(100, 70, 190, 35);
	loginPanel.add(passwordText);

	loginButton = new JButton("Login In");
	loginButton.setBounds(30, 125, 115, 35);
	loginButton.setFont(new Font("Arial Bold", Font.BOLD, 14));
	loginButton.addActionListener(new GUI());
	loginPanel.add(loginButton);

	createNavButton = new JButton("Create User");
	createNavButton.setBounds(150, 125, 115, 35);
	createNavButton.addActionListener(new GUI());
	loginPanel.add(createNavButton);

	loginPopup = new JLabel("");
	loginPopup.setBounds(10, 110, 300, 25);
	loginPanel.add(loginPopup);

	loginFrame.setVisible(true);

	return new LoginInfo(userText.toString(), passwordText.toString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
	// Returns source of action event
	Object source = e.getSource();

	// Gets relevant login info, and creates an instance of the info.
	LoginInfo login = new LoginInfo(userText.getText(), new String(passwordText.getPassword()));

	/**
	 * Following code compares the source of the action event to the button, matches
	 * if button // pressed, and performs checks on input/performs what that button
	 * needs to do. try-catch block handles SQLExceptions, ie. errors in the data //
	 * retrieval/insertion.
	 */
	try {
	    if (source == loginNavButton) {
		createFrame.dispose();
		GUI.displayLoginPage();
	    } else if (source == createNavButton) {
		loginFrame.dispose();
		GUI.displayUserCreation();
	    } else if (source == loginButton) {
		if (DataConnection.loginSuccessful(login)) {
		    JOptionPane.showMessageDialog(loginPopup, "Successful Login! With username: " + login.getUsername(),
			    "Success", JOptionPane.INFORMATION_MESSAGE);
		} else {
		    JOptionPane.showMessageDialog(loginPopup, "Wrong Username/Password. Please Try Again.",
			    "Invalid Login", JOptionPane.INFORMATION_MESSAGE);
		}
	    } else if (source == createButton) {
		if (verify.login(login) && !(DataConnection.usernameTaken(login))) {
		    DataConnection.insertUser(login);
		    JOptionPane.showMessageDialog(createPopup, "User Created!" + login.getUsername(), "Success",
			    JOptionPane.INFORMATION_MESSAGE);
		}
	    }
	} catch (SQLException e1) {
	    e1.printStackTrace();
	}

    }

}
