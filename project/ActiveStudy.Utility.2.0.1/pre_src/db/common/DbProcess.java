package com.elcom.db.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DbProcess extends DBCommand {

	protected Log logger = LogFactory.getLog(this.getClass());

    @Override
    public void invoke(DbConnectionExtra conn) throws Exception {
        OracleConnection connection = (OracleConnection) conn;
        synchronized (connection) {
            try {
                execute(connection);
            } catch (Exception e) {
                throw e;
            } finally {
                connection.connection().commit();
            }
        }
    }

    public abstract void execute(OracleConnection conn) throws Exception;
}
