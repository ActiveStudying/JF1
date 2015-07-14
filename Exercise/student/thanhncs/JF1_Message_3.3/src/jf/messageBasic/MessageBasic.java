package jf.messageBasic;

public interface MessageBasic {
	int idLogin = 1;
	int idLogout = 2;
	int idPerInfo = 3;
	int idLoginResponse = 4;
	int idLogoutResponse = 5;
	String nameLogin = "login";
	String nameLogout = "logout";
	String namePerInfo = "perInfo";
	String nameLoginResponse = "loginResponse";
	String nameLogoutResponse = "logoutResponse";

	public int getId();

	public void setId(int id);

	public String getName();

	public void setName(String name);
}
