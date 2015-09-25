package com.activestudy.Utitity.db;


public interface IDBModule extends DBLogicIF
{
	public int execute(DBCommand cmd) throws DBException;
	
	public int getDbConnState();
}
