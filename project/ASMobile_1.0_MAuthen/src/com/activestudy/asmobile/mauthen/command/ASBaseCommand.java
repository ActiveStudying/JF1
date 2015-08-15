/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mauthen.command;

import com.activestudy.Utitity.db.IDBModule;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.pattern.behavioral.command.AbsCommand;

/**
 *
 * @author tanhai
 */
public abstract class ASBaseCommand extends AbsCommand {
    
    String email;
    String deviceId;
    AccountInfoEntity account;
    
    protected IDBModule dbCtrl;

    public IDBModule getDbCtrl() {
        return dbCtrl;
    }

    public void setDbCtrl(IDBModule dbCtrl) {
        this.dbCtrl = dbCtrl;
    }
    
    
    public String getResponse(){
        return ""; 
    }
    
}
