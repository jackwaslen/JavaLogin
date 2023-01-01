package loginProject;

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

public class LoginPage implements ActionListener {

    private JLabel userLabel;
    private JTextField userText;
    private JLabel passwordLabel;
    private JLabel createUser;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JButton createButton;
    private JButton loginPageButton;
    private JLabel loginPopup;
    private JLabel createPopup;
    private JPanel panel;
    private LoginInfo userInput;
    

    JFrame frame = new JFrame();
    
    LoginPage() {
	
	frame.setTitle("Login Page");
	frame.setSize(300, 200);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(panel);

	panel.setLayout(null);
	userLabel = new JLabel("Username: ");
	userLabel.setBounds(10, 25, 80, 25);
	panel.add(userLabel);

	userText = new JTextField(20);
	userText.setBounds(100, 20, 190, 35);
	panel.add(userText);

	passwordLabel = new JLabel("Password: ");
	passwordLabel.setBounds(10, 75, 80, 25);
	panel.add(passwordLabel);

	passwordText = new JPasswordField();
	passwordText.setBounds(100, 70, 190, 35);
	panel.add(passwordText);

	loginButton = new JButton("Enter");
	loginButton.setBounds(60, 125, 175, 35);
	loginButton.addActionListener(new GUI());
	panel.add(loginButton);

	loginPopup = new JLabel("");
	loginPopup.setBounds(10, 110, 300, 25);
	panel.add(loginPopup);

	frame.setVisible(true);

	userInput = new LoginInfo(userText.toString(), passwordText.toString());

    }



    @Override
    public void actionPerformed(ActionEvent e) {
	Object source = e.getSource();
	if (source == loginPageButton) {
	    frame.dispose();
	} else if (source == loginButton) {
	    System.out.println("LOgin butt");
	} else if (source == createButton) {
	    System.out.println("Create User");
	}
	LoginInfo userinfo = new LoginInfo();
	userinfo.setUsername(userText.getText());
	userinfo.setPassword(new String(passwordText.getPassword()));
	try {
	    if (DataConnection.Connect(userinfo)) {
		JOptionPane.showMessageDialog(loginPopup, "Your Login was Successful!");
	    } else {
		JOptionPane.showMessageDialog(loginPopup, "Incorrect Login!", "Error Message: ",
			JOptionPane.ERROR_MESSAGE);
	    }
	} catch (SQLException e1) {
	    e1.printStackTrace();
	}

    }

}

}
