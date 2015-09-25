package com.activestudy.asmobile.mauthen.dbcontroller;

//import com.activestudy.asmobile.mauthen.dbcontroller.OracleConnectionRefactory;
import com.activestudy.Utitity.db.DBCommand;
import com.activestudy.Utitity.db.DBException;
import com.activestudy.Utitity.db.DBLogicException;
import com.activestudy.Utitity.db.IDBModule;
import com.activestudy.Utitity.db.oracle.DBLogicImpl;
//import com.elcom.mhss.common.MHSSException;
//import com.elcom.mhss.config.CoreConfig;
//import com.elcom.mhss.config.DBConfig;
//import com.elcom.utils.DebugUtil;
//import com.activestudy.asmobile.mauthen.dbcontroller.OracleConnectionRefactory;

public class DbModuleImpl extends DBLogicImpl implements IDBModule {
	private static DbModuleImpl instance;

	private DbModuleImpl() throws Exception {
		super("../../config/mauthen/db.properties", new OracleConnectionRefactory());
	}

	public static synchronized IDBModule getInstance() {
		if (instance == null) {
			try {
				instance = new DbModuleImpl();
			} catch (Exception e) {
//				.printStackTrace(e);
			}
		}

		return instance;
	}

	public int execute(DBCommand cmd) throws DBException {
		try {
			executeCommand(cmd, getTimeOut());
		} catch (DBLogicException e) {
			throw new DBException(e);
		} catch (Exception e) {
			throw new DBException(e);
		}

		return cmd.getResult();
	}

	public int getDbConnState() {
		return 0;
	}
}
