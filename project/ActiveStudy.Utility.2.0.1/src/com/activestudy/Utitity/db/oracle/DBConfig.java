package com.activestudy.Utitity.db.oracle;

import com.activestudy.Utility.AbsConfig;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class  DBConfig extends AbsConfig {
	//public static String DB_CONFIG_FILE = CoreConfig.CONFIG_PATH
	//		+ "db.properties";
        
     public DBConfig() {
        super("./config/db.properties");       
    }    

    public DBConfig(String filename) {
        super(filename);        
    }

	public String getDriver() {
		return getKey("db", "driver", "oracle.jdbc.driver.OracleDriver");
	}

	public void setDriver(String newvalue) {
		setKey("db", "driver", newvalue);
	}

	public String getDSStrategy() {
		return getKey("db", "dsstrategy", "BasicDataSource");
	}

	public void setDSStrategy(String newvalue) {
		setKey("db", "dsstrategy", newvalue);
	}

	public String getDBUrl() {
		return getKey("db", "url");
	}

	public void setDBUrl(String newvalue) {
		setKey("db", "url", newvalue);
	}

	public String getUsername() {
		return getKey("db", "username");
	}

	public int getThreadCount() {
		return getKeyInt("dblogic", "threadcount", 32);
	}

	public void setThreadCount(int newvalue) {
		setKeyInt("dblogic", "threadcount", newvalue);
	}

	public String getPassword() {
		return getKey("db", "password");
	}

	public void setPassword(String newvalue) {
		setKey("db", "password", newvalue);
	}

	public boolean isAutocommit() {
		return getKeyBoolean("db", "autocommit", true);
	}

	public void setAutocommit(boolean newvalue) {
		setKeyBoolean("db", "autocommit", newvalue);
	}

	public String getThreadModel() {
		return getKey("dblogic", "threadmodel", "DIRECT");
	}

	public void setThreadModel(String newvalue) {
		setKey("dblogic", "threadmodel", newvalue);
	}

	
//	protected String getComment() {
//		ByteArrayOutputStream s = new ByteArrayOutputStream();
//		PrintStream writer = new PrintStream(s);
//		writer.println("#db.driver = oracle.jdbc.driver.OracleDriver");
//		writer.println("#db.dsstrategy = BasicDataSource");
//		writer.println("#db.url=jdbc\\:oracle\\:thin\\:@192.168.2.219\\:1521\\:mca");
//		writer.println("#db.username=GPHONE");
//		writer.println("#DBLogic.ThreadCount = 32");
//		writer.println("#db.password=GPHONE");
//		writer.println("#db.autocommit=TRUE");
//		writer.println("#DBLogic.ThreadModel=DIRECT");
//		writer.println("#DBLogic.ThreadModel=ThreadPool");
//		return s.toString();
//	}

	
	protected void setDefault() {
		setKey("db", "driver", "oracle.jdbc.driver.OracleDriver");
		setKey("db", "dsstrategy", "BasicDataSource");
		setKey("db", "url","jdbc\\:oracle\\:thin\\:@192.168.2.219\\:1521\\:mca");
		setKey("db", "username", "");
		setKey("db", "password", "");
		setKeyBoolean("db", "autocommit", true);
		setKeyInt("dblogic", "threadcount", 32);
		setKey("dblogic", "threadmodel", "DIRECT");
	}

    @Override
    public boolean loadConfig() {
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
