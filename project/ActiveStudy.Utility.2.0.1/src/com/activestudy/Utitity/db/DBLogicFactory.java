/**
 * 
 */
package com.activestudy.Utitity.db;

import com.activestudy.Utitity.db.oracle.DBLogicImpl;
import com.elcom.db.DbConnectionRefactory;

/**
 * @author longnd
 * @create 9:17:55 AM
 * @purpose
 */
public class DBLogicFactory {
	public DBLogicIF createInstance(DbConnectionRefactory connFactory)
			throws Exception {
		return createInstance("./config/db.properties", connFactory);
	}

	public DBLogicIF createInstance(String configfile,
			DbConnectionRefactory connFactory) throws Exception {
		if (configfile == null)
			configfile = "./config/db.properties";

		return new DBLogicImpl(configfile, connFactory);
	}
}
