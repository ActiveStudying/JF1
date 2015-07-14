package jf.person;

import java.util.Date;

import org.omg.CORBA.Request;

import jf.message.Message;
import jf.requestLogin.RequestLogin;

public class PerInfo extends RequestLogin {
	private int id;
	private String name = "perInfo";
	private String perName;
	private Date perBithday;
	private String perAdress;

	public PerInfo() {
		super();
		this.id = idPerInfo;
		this.name = namePerInfo;
		// TODO Auto-generated constructor stub
	}

	public PerInfo(String perName, Date bithday, String perAdress) {
		super();
		this.id = idPerInfo;
		this.name = namePerInfo;
		this.perName = perName;
		this.perBithday = bithday;
		this.perAdress = perAdress;
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

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public Date getPerBithday() {
		return perBithday;
	}

	public void setPerBithday(Date perBithday) {
		this.perBithday = perBithday;
	}

	public String getPerAdress() {
		return perAdress;
	}

	public void setPerAdress(String perAdress) {
		this.perAdress = perAdress;
	}
}
