/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mauthen;

import com.activestudy.Utility.AbsConfig;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *
 * @author tanhai
 */
public class DbConfig extends AbsConfig {
    private String driver = "";
    private String dBUrl = "";
    private String username = "";
    private String threadCount = "";
    private String password = "";
    private String autocommit = "";
                    
    @Override
    public boolean loadConfig() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }
    public static final String DB_CONFIG_FILE = CoreConfig.CONFIG_PATH + "db.properties";

    public DbConfig(String filename) {
        super(filename);
        loadConfig();
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

    @Override
    protected String getComment() {
        ByteArrayOutputStream s = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(s);
        writer.println("#db.driver = oracle.jdbc.driver.OracleDriver");
        writer.println("#db.dsstrategy = BasicDataSource");
        writer.println("#db.url=jdbc\\:oracle\\:thin\\:@192.168.2.219\\:1521\\:mca");
        writer.println("#db.username=GPHONE");
        writer.println("#DBLogic.ThreadCount = 32");
        writer.println("#db.password=GPHONE");
        writer.println("#db.autocommit=TRUE");
        writer.println("#DBLogic.ThreadModel=DIRECT");
        writer.println("#DBLogic.ThreadModel=ThreadPool");
        return s.toString();
    }

    @Override
    protected void setDefault() {
        setKey("db", "driver", "oracle.jdbc.driver.OracleDriver");
        setKey("db", "dsstrategy", "BasicDataSource");
        setKey("db", "url",
                "jdbc\\:oracle\\:thin\\:@192.168.2.219\\:1521\\:mca");
        setKey("db", "username", "GPHONE");
        setKey("db", "password", "GPHONE");
        setKeyBoolean("db", "autocommit", true);
        setKeyInt("dblogic", "threadcount", 32);
        setKey("dblogic", "threadmodel", "DIRECT");
    }

}
