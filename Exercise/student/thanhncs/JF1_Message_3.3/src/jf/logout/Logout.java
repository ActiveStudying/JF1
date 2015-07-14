package jf.logout;

import jf.message.Message;

public class Logout extends Message {
	private int id;
	private String name;
	private String username;

	public Logout() {
		super();
		// TODO Auto-generated constructor stub
		this.id = idLogout;
		this.name = nameLogout;
	}

	public Logout(String username) {
		super();
		this.id = idLogout;
		this.name = nameLogout;
		this.username = username;
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

}
