package com.activestudy.Utitity.db.oracle;

import com.activestudy.Utitity.db.DBCommand;
import com.activestudy.Utitity.db.DbConnectionExtra;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DbProcess extends DBCommand {

	protected Log logger = LogFactory.getLog(this.getClass());

    @Override
    public void invoke(DbConnectionExtra conn) throws Exception {
        DbConnectionExtra connection = (DbConnectionExtra) conn;
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

    public abstract void execute(DbConnectionExtra conn) throws Exception;
}
