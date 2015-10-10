package com.activestudy.asmobile.mauthen.dbcontroller.cmd;

import com.activestudy.Utitity.db.DbConnectionExtra;
import java.sql.CallableStatement;
import java.sql.Types;

import com.activestudy.Utitity.db.oracle.DbProcess;
import com.activestudy.asmobile.mauthen.dbcontroller.OracleConnection;

public class DbUpdateDeviceInfo extends DbProcess {
	private final String deviceID;
	private final String deviceName;
	private final String osName;
	private final String osVersion;
	private final String cloudKey;
	private final String devOther;

	public DbUpdateDeviceInfo(String deviceID, String deviceName,
			String osName, String osVersion, String cloudKey, String devOther) {
		this.deviceID = deviceID;
		this.deviceName = deviceName;
		this.osName = osName;
		this.osVersion = osVersion;
		this.cloudKey = cloudKey;
		this.devOther = devOther;
	}

	@Override
	public void execute(DbConnectionExtra conn) throws Exception {
		CallableStatement ctm = ((OracleConnection)conn).getStmUpdateDeviceInfo();
		ctm.registerOutParameter(1, Types.INTEGER);
		ctm.setString(2, deviceID);
		ctm.setString(3, deviceName);
		ctm.setString(4, cloudKey);
		ctm.setString(5, osName);
		ctm.setString(6, osVersion);
		ctm.setString(7, devOther);

		ctm.execute();

		result = ctm.getByte(1);
	}

}
