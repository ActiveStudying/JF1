package com.activestudy.Utitity.db;

public interface DBLogicIF {

	public int initialize() throws ClassNotFoundException;
	
	public int exit();

	public void executeCommand(DBCommand command, long waitWorker) throws Exception;
}