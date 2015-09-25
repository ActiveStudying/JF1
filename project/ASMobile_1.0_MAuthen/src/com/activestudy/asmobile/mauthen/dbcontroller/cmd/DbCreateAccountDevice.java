package com.activestudy.asmobile.mauthen.dbcontroller.cmd;

import com.activestudy.Utitity.db.DbConnectionExtra;
import java.sql.CallableStatement;
import java.sql.Types;

import com.activestudy.Utitity.db.oracle.DbProcess;
import com.activestudy.asmobile.mauthen.dbcontroller.OracleConnection;

public class DbCreateAccountDevice extends DbProcess {

	private final String accountID;
	private final String password;
	private final String msisdn;
	private final String deviceID;

	public DbCreateAccountDevice(String accountID, String password,
			String msisdn, String deviceID) {
		this.accountID = accountID;
		this.password = password;
		this.msisdn = msisdn;
		this.deviceID = deviceID;
	}

	@Override
	public void execute(DbConnectionExtra conn) throws Exception {
		CallableStatement ctm = ((OracleConnection)conn).getStmCreateAcountDevice();
		ctm.registerOutParameter(1, Types.INTEGER);
		ctm.setString(2, accountID);
		ctm.setString(3, password);
		ctm.setString(4, msisdn);
		ctm.setString(5, deviceID);

		ctm.execute();

		result = ctm.getInt(1);
	}

}
