/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author tanhai
 */
public abstract class AbsConfig {

    private Properties properties;
    protected String configPath = "./config/core.properties";
    //public abstract boolean loadConfig();

    public AbsConfig() {
        load();
        
    }

    public AbsConfig(String configPath) {
        this.configPath = configPath;
        load();        
    }

    public abstract boolean loadConfig();

    public void load() {
        try {
            properties = new Properties();
            FileInputStream pin = new FileInputStream(configPath);
            properties.load(pin);
            
        } catch (Exception e) {
            //setDefault();
            //store();
            e.printStackTrace();
        }
    }

    protected String getComment() {
        return "#" + new Date();
    }

    public void store() {
        try {
            FileOutputStream pin = new FileOutputStream(configPath);
            properties.store(pin, getComment());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void setDefault() {
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getConfigPath() {
        return configPath;
    }

    public void setConfigPath(String configPath) {
        this.configPath = configPath;
    }

    public final String getKey(String category, String valuename) {
        if (category != null) {
            return properties.getProperty(category + "." + valuename);
        } else {
            return properties.getProperty(valuename);
        }
    }

    public final String getKey(String category, String valuename, String defaultvalue) {
        if (category != null) {
            return properties.getProperty(category + "." + valuename, defaultvalue);
        } else {
            return properties.getProperty(valuename, defaultvalue);
        }
    }

    public final void setKey(String category, String valuename, String value) {
        if (category != null) {
            properties.setProperty(category + "." + valuename, value);
        } else {
            properties.setProperty(valuename, value);
        }
    }

    public final int getKeyInt(String category, String valuename) {
        return Integer.parseInt(getKey(category, valuename));
    }

    public final int getKeyInt(String category, String valuename, int defaultvalue) {
        try {
            return Integer.parseInt(getKey(category, valuename, Integer.toString(defaultvalue)));
        } catch (Exception e) {
            return defaultvalue;
        }
    }

    public final void setKeyInt(String category, String valuename, int value) {
        setKey(category, valuename, Integer.toString(value));
    }

    public final long getKeyLong(String category, String valuename) {
        return Long.parseLong(getKey(category, valuename));
    }

    public final long getKeyLong(String category, String valuename, long defaultvalue) {
        try {
            return Long.parseLong(getKey(category, valuename, Long.toString(defaultvalue)));
        } catch (Exception e) {
            return defaultvalue;
        }
    }

    public final void setKeyLong(String category, String valuename, long value) {
        setKey(category, valuename, Long.toString(value));
    }

    public final boolean getKeyBoolean(String category, String valuename) {
        return "TRUE".equalsIgnoreCase(getKey(category, valuename));
    }

    public final boolean getKeyBoolean(String category, String valuename, boolean defaultvalue) {
        try {
            return "TRUE".equalsIgnoreCase(getKey(category, valuename, Boolean.toString(defaultvalue)));
        } catch (Exception e) {
            return defaultvalue;
        }
    }

    public final void setKeyBoolean(String category, String valuename, boolean value) {
        setKey(category, valuename, Boolean.toString(value));
    }
}
