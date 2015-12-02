import java.io.Serializable;

public class MyCredentialsDTO implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = -2481852837679611318L;
	public MyCredentialsDTO(int[] website, int[] username, int[] password) {
		super();
		this.website = website;
		this.username = username;
		this.password = password;
	}
	int website[];
	int username[];
	int password[];
	public int[] getWebsite() {
		return website;
	}
	public void setWebsite(int[] website) {
		this.website = website;
	}
	public int[] getUsername() {
		return username;
	}
	public void setUsername(int[] username) {
		this.username = username;
	}
	public int[] getPassword() {
		return password;
	}
	public void setPassword(int[] password) {
		this.password = password;
	}

}
