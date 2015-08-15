/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mauthen;

import com.activestudy.Utitity.db.IDBModule;
import com.activestudy.asmobile.mauthen.dbcontroller.DbModuleImpl;

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

        return instance;
    }

    public Processor() {

        dbCtrl = DbModuleImpl.getInstance();
        try {
            dbCtrl.initialize();
        } catch (ClassNotFoundException ex) {
            //logger.error("", ex);
            return;
        }
    }
}
