package com.elcom.db.common;

public interface DBLogicIF {

	public int initialize() throws ClassNotFoundException;
	
	public int exit();

	public void executeCommand(DBCommand command, long waitWorker) throws Exception;
}