/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mauthen;

import com.activestudy.Utitity.db.IDBModule;
import com.activestudy.asmobile.mauthen.dbcontroller.DbModuleImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.xml.DOMConfigurator;

/**
 *
 * @author tanhai
 */
public class Processor {

    private IDBModule dbCtrl;
    private static Processor instance = null;

    public static Processor getInstance() {
        if (instance == null) {
            instance = new Processor();
        }
        String xmlfile = "../../config/mauthen/log4j.mauthen.xml";
        DOMConfigurator.configure(xmlfile);

        return instance;
    }

    public Processor() {
        Log logger = LogFactory.getLog("mauthen");
        logger.info("Started Mauthen!");

        try {
            logger.info("dbCtrl start get instance");
            dbCtrl = DbModuleImpl.getInstance();
            logger.info("dbCtrl get instance success");

            dbCtrl.initialize();
            logger.info("dbCtrl initialize");
        } catch (Exception ex) {
            logger.error("dbCtrl initial error: " + ex.getMessage(), ex);
            return;
        } 
    }

    public IDBModule getDbCtrl() {
        return dbCtrl;
    }
}
