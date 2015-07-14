package jf.login;

import jf.message.Message;
import jf.responseLogin.ResponseLogin;
import jf.result.Result;

public class LoginResponse extends ResponseLogin {
	private int id;
	private String name;
	private String username;
	private Result result;

	public LoginResponse() {
		super();
		this.id = idLoginResponse;
		this.name = nameLoginResponse;
		// TODO Auto-generated constructor stub
	}

	public LoginResponse(String username, Result result) {
		super();
		this.id = idLoginResponse;
		this.name = nameLoginResponse;
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

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
