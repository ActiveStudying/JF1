/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.Utitity.db;


import java.sql.SQLException;

import com.elcom.db.DbConnection;

/**
 *
 */
public class DbConnectionExtra extends DbConnection {

    public DbConnectionExtra(int index, DbConnection conn) throws SQLException 
    {
        super(index, conn.connection());
        conn.connection().setAutoCommit(false); 

    }
}
