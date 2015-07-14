package jf.login;

import jf.message.Message;
import jf.requestLogin.RequestLogin;

public class Login extends RequestLogin {
	private int id;
	private String name;
	private String username;
	private String password;

	public Login() {
		super();
		this.id = idLogin;
		this.name = nameLogin;
		// TODO Auto-generated constructor stub
	}

	public Login(String username, String password) {
		super();
		this.id = idLogin;
		this.name = nameLogin;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
