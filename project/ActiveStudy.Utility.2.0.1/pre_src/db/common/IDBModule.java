package com.elcom.db.common;

import com.elcom.mhss.common.MHSSException;

public interface IDBModule extends DBLogicIF
{
	public int execute(DBCommand cmd) throws MHSSException;
	
	public int getDbConnState();
}
