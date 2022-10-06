package sideProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel popup;

    public static void main(String[] args) {
	String arg1 = "Hello12*";
	String arg2 = "ello1*";
	String arg3 = "__#d";
	String arg4 = "helOoo1_2";
	System.out.println(verify.username(arg1));
	System.out.println(verify.username(arg2));
	System.out.println(verify.username(arg3));
	System.out.println(verify.username(arg4));

	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	frame.setTitle("Enter Login Details");
	frame.setSize(400, 250);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(panel);

	panel.setLayout(null);
	userLabel = new JLabel("Username: ");
	userLabel.setBounds(10, 20, 80, 25);
	panel.add(userLabel);

	userText = new JTextField(20);
	userText.setBounds(100, 20, 175, 25);
	panel.add(userText);

	passwordLabel = new JLabel("Password: ");
	passwordLabel.setBounds(10, 50, 80, 25);
	panel.add(passwordLabel);

	passwordText = new JPasswordField();
	passwordText.setBounds(100, 50, 175, 25);
	panel.add(passwordText);

	button = new JButton("Enter");
	button.setBounds(10, 80, 80, 25);
	button.addActionListener(new GUI());
	panel.add(button);

	popup = new JLabel("");
	popup.setBounds(10, 110, 300, 25);
	panel.add(popup);

	frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
	String user = userText.getText();
	String password = new String(passwordText.getPassword());
	if (verify.password(password)) {
	    JOptionPane.showMessageDialog(popup, "Your Login was Successful!");
	} else {
	    JOptionPane.showMessageDialog(popup, "Incorrect Login!", "Error Message: ", JOptionPane.ERROR_MESSAGE);
	}
	System.out.println(user + password);

    }

}
