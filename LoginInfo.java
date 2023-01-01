package loginProject;

/**
 * @author Jack Waslen 12/2022 LoginInfo bundles the username and password
 *         together, aswell as a URL attribute that will be used in a future
 *         project. It contains relevant setters/getters and two constructors:
 *         one for no-arguments and one for a username and password.
 */
public class LoginInfo {
    private String username;
    private String password;
    private String url;

    public LoginInfo(String username, String password) {
	this.username = username;
	this.password = password;
    }

    public LoginInfo() {
	this.username = null;
	this.password = null;
    }

    public String getUsername() {
	return this.username;
    }

    public String getPassword() {
	return this.password;
    }

    public String getURL() {
	return this.url;
    }

    public void setURL(String url) {
	this.url = url;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public void setPassword(String password) {
	this.password = password;
    }
}
