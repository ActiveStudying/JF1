package com.elcom.db.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;

import com.elcom.db.DbConnectionPool;
import com.elcom.db.DbConnectionRefactory;
import com.elcom.mhss.common.MHSSResult;
import com.elcom.mhss.config.DBConfig;

// import com.elcom.gphone.locreg.core.dblogic.DBLogicException;

public class DBLogicImpl implements DBLogicIF {
	private final DbConnectionPool dbPool;

	interface DBServiceCommand {
		abstract void deligateCommand(DBCommand command, long wait)
				throws Exception;
	}

	class ServiceDirect implements DBServiceCommand {
		public void stop() {

		}

		public void deligateCommand(DBCommand command, long wait)
				throws Exception {
			DbConnectionExtra dbConn = null;

			try {
				dbConn = (DbConnectionExtra) dbPool
						.getConnectionTimedWait(wait);
				if (dbConn == null) {
					command.setResult((byte) MHSSResult.MHSS_SYSTEM_BUSY);
					return;
				}

				command.invoke(dbConn);
			} catch (Exception e) {
				throw e;
			} finally {
				if (dbConn != null)
					dbPool.freeConnection(dbConn);
			}
		}
	}

	private Log logger = LogFactory.getLog(DBLogicImpl.class);
	protected final DBConfig config;

	private ServiceDirect commandService = null;

	public synchronized int initialize() throws ClassNotFoundException {

		logger.info("Start DBLogic");
		if (commandService == null) {
			commandService = new ServiceDirect();
		}

		return 0;
	}

	public synchronized int exit() {
		if (commandService != null) {
			commandService.stop();
			commandService = null;
		}

		/*
		 * if (connector != null) connector.exit();
		 */

		if (dbPool != null) {
			dbPool.destroy();
			// dbPool = null;
		}

		return 0;
	}

	/**
	 * @param command
	 * @param wait
	 * @return
	 * @throws Exception
	 */
	public void executeCommand(DBCommand command, long wait) throws Exception {
		commandService.deligateCommand(command, wait);
	}

	/**
	 * @throws Exception
	 */
	public DBLogicImpl(String configfile, DbConnectionRefactory connFactory)
			throws Exception {
		config = new DBConfig(configfile);
		dbPool = new DbConnectionPool(LoggerFactory.getLogger(this.getClass()),
				config.getDriver(), config.getDBUrl(), config.getUsername(),
				config.getPassword(), config.getThreadCount(), connFactory);
	}
}
