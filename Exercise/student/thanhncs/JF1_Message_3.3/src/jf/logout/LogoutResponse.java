package jf.logout;

import jf.message.Message;
import jf.responseLogin.ResponseLogin;
import jf.result.Result;

public class LogoutResponse extends ResponseLogin {
	private int id;
	private String name;
	private String username;
	private Result result;

	public LogoutResponse() {
		super();
		this.id = idLogoutResponse;
		this.name = nameLogoutResponse;
		// TODO Auto-generated constructor stub
	}

	public LogoutResponse(String username, Result result) {
		super();
		this.id = idLogoutResponse;
		this.name = nameLogoutResponse;
		this.username = username;
		this.result = result;
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

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
