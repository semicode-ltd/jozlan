import java.io.Serializable;

public class MasterPasswordDTO implements Serializable{
/**
	 *
	 */
	private static final long serialVersionUID = -3153967243456316797L;
int password[]= new int[1880];
int length;

public MasterPasswordDTO(int[] password, int length) {
	super();
	this.password = password;
	this.length = length;
}

public int getLength() {
	return length;
}

public void setLength(int length) {
	this.length = length;
}

public int[] getPassword() {
	return password;
}
public void setPassword(int[] password) {
	this.password = password;
}
}
