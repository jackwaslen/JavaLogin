package sideProject;

public class verify {
    /**
     * Validates the given password. All passwords must have be at least 6
     * characters long, have one uppercase letter, two digits and one special
     * character.
     * 
     * 
     * @param String: password
     * @return
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
		} else if (Character.isUpperCase(password.charAt(i))) {
		    upper = true;
		} else if (!(Character.isLetter(chr)) && (!(Character.isWhitespace(chr)))) {
		    special = true;
		}

	    }
	    if ((digit_count >= 2) && (special) && (upper)) {
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
     * @return
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