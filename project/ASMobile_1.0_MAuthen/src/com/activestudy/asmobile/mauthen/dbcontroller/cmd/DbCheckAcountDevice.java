package com.activestudy.asmobile.mauthen.dbcontroller.cmd;

import com.activestudy.Utitity.db.DbConnectionExtra;
import java.sql.CallableStatement;
import java.sql.Types;

import com.activestudy.Utitity.db.oracle.DbProcess;
import com.activestudy.asmobile.mauthen.dbcontroller.OracleConnection;

public class DbCheckAcountDevice extends DbProcess {

	private final String accountID;

	private final String deviceID;

	public DbCheckAcountDevice(String accountID, String deviceID) {
		this.accountID = accountID;
		this.deviceID = deviceID;
	}

	@Override
	public void execute(DbConnectionExtra conn) throws Exception {
		CallableStatement ctm = ((OracleConnection)conn).getStmCheckAcountDevice();
		ctm.registerOutParameter(1, Types.INTEGER);
		ctm.setString(2, accountID);
		ctm.setString(3, deviceID);
		
		ctm.execute();
        
        result = ctm.getByte(1);
	}

}
