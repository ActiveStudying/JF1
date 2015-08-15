/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activestudy.asmobile.mauthen.dbcontroller;


import com.activestudy.Utitity.db.DbConnectionExtra;
import java.sql.SQLException;
import com.elcom.db.DbConnection;
import com.elcom.db.DbConnectionRefactory;

/**
 *
 */
public class OracleConnectionRefactory implements DbConnectionRefactory {

	public DbConnection refactory(int index, DbConnection conn)
			throws SQLException {
		return new OracleConnection(index, conn);
	}

}
