package com.activestudy.Utitity.db;

public class DBException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8850172445156916206L;
	
	public DBException(Exception e)
	{
		super(e);
	}

	public DBException(String e)
	{
		super(e);
	}
}
