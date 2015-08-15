package com.elcom.db.common;

import com.elcom.mhss.common.MHSSException;
import com.elcom.mhss.config.CoreConfig;
import com.elcom.mhss.config.DBConfig;
import com.elcom.utils.DebugUtil;

public class DbModuleImpl extends DBLogicImpl implements IDBModule {
	private static DbModuleImpl instance;

	private DbModuleImpl() throws Exception {
		super(DBConfig.DB_CONFIG_FILE, new OracleConnectionRefactory());
	}

	public static synchronized IDBModule getInstance() {
		if (instance == null) {
			try {
				instance = new DbModuleImpl();
			} catch (Exception e) {
				DebugUtil.printStackTrace(e);
			}
		}

		return instance;
	}

	public int execute(DBCommand cmd) throws MHSSException {
		try {
			executeCommand(cmd, CoreConfig.getDbWait());
		} catch (DBLogicException e) {
			throw new MHSSException(e);
		} catch (Exception e) {
			throw new MHSSException(e);
		}

		return cmd.getResult();
	}

	public int getDbConnState() {
		return 0;
	}
}
