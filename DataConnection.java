package loginProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jack Waslen 12/2022
 *
 */
public class DataConnection {
    // Number of observations in sample dataset, gets updated on every insert
    private static int primaryKey = 7;

    /**
     * @param login|LoginInfo: LoginInfo object that contains username and password
     *                         attributes
     * @param query|String:    SQL query needed to be executed
     * @return output|Boolean: True if result set not empty, (query successful)
     * @throws SQLException
     */
    public static boolean connect(LoginInfo login, String query) throws SQLException {
	boolean output = false;
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Database", "root", "Laurier89");
	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    if (rs.next()) {
		output = true;
	    }
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} catch (SQLException e1) {
	    e1.printStackTrace();
	}

	return output;

    }

    /**
     * @param login|LoginInfo: LoginInfo object that contains username and password
     *                         attributes
     * @return output|Boolean: True if username is taken, false otherwise
     * @throws SQLException
     */
    public static boolean usernameTaken(LoginInfo login) throws SQLException {
	String username = login.getUsername();
	String query = "SELECT username FROM LoginInfo WHERE '" + username + "' = LoginInfo.username";
	boolean output = connect(login, query);
	return output;
    }

    /**
     * @param login|LoginInfo: LoginInfo object that contains username and password
     *                         attributes
     * @return output|Boolean: True if username and password found, false otherwise
     * @throws SQLException
     */
    public static boolean loginSuccessful(LoginInfo login) throws SQLException {
	String username = login.getUsername();
	String password = login.getPassword();
	String query = "SELECT username, password FROM LoginInfo WHERE '" + username + "' = LoginInfo.username AND"
		+ " LoginInfo.password = '" + password + "'";
	boolean output = connect(login, query);
	return output;
    }

    /**
     * @param login|LoginInfo: LoginInfo object that contains username and password
     *                         attributes
     * @return output|Boolean: True if user successfully inserted, false otherwise
     * @throws SQLException
     */
    public static boolean insertUser(LoginInfo login) throws SQLException {
	String username = login.getUsername();
	String password = login.getPassword();
	Boolean output = false;
	primaryKey += 1;
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Database", "root", "Laurier89");
	    Statement stmt = con.createStatement();
	    String query = "INSERT INTO LoginInfo " + "VALUES('" + primaryKey + "', '" + username + "', '" + password
		    + "')";
	    stmt.executeUpdate(query);
	    output = true;
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} catch (SQLException e1) {
	    e1.printStackTrace();
	}
	return output;
    }

}
