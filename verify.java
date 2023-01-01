package loginProject;

/**
 * @author Jack Waslen 12/2022
 *
 */
public class verify {
    /**
     * Takes a LoginInfo object and checks the username and password for validity.
     * 
     * @param LoginInfo: login
     * @return boolean: true if both conditions met, false otherwise
     */
    public static boolean login(LoginInfo login) {

	return username(login.getUsername()) && password(login.getPassword());
    }

    /**
     * Validates the given password. All passwords must have be at least 6
     * characters long, have one uppercase letter, two digits and one special
     * character.
     * 
     * 
     * @param String: password
     * @return boolean: true if all conditions met, false otherwise
     */
    public static boolean password(String password) {
	boolean output = false;
	boolean upper = false;
	boolean special = false;
	int digit_count = 0;
	if (password.length() >= 6) {
	    for (int i = 0; i < password.length(); i++) {
		char chr = password.charAt(i);
		if (Character.isDigit(password.charAt(i))) {
		    digit_count += 1;
		} else if (!(Character.isLetter(chr)) && (!(Character.isWhitespace(chr)))) {
		    special = true;
		}

	    }
	    if ((digit_count >= 2) && (special)) {
		output = true;
	    }

	}

	return output;
    }

    /**
     * Validates given user name. User name must have have at least six characters,
     * one upper case, and one digit.
     * 
     * @param username
     * @return boolean: true if all conditions met, false otherwise
     */
    public static boolean username(String username) {
	boolean digit = false;
	boolean upper = false;
	if (username.length() >= 6) {
	    for (int i = 0; i < username.length(); i++) {
		char chr = username.charAt(i);
		if (Character.isDigit(username.charAt(i))) {
		    digit = true;
		} else if (Character.isUpperCase(chr)) {
		    upper = true;
		}
	    }

	}
	return (digit && upper);
    }
}