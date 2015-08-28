/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mservice.command;

import com.activestudy.asmobile.mservice.dbcontroller.cmd.DbGetListClass;
import com.activestudy.Utitity.db.DBException;
import com.activestudy.asmobile.entity.AccountInfoEntity;
import com.activestudy.asmobile.entity.ClassInfoEntity;
import com.activestudy.asmobile.entity.DeviceInfoEntity;
import com.activestudy.asmobile.mservice.Processor;
import com.activestudy.pattern.behavioral.command.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.RandomStringUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author tanhai
 */
public class GetListClassCmd extends ASBaseCommand {

    ArrayList<Class> lstClass = new ArrayList<>();
//    DbGetListClass dbGetListClassCmd = new DbGetListClass();

    @Override
    public void parse(String content) {
        super.parse(content); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void execute() {
//
//        try {
//            Processor.getInstance().getDbCtrl().execute(dbGetListClassCmd);
//
//            //lay dc lstClass roi sau gui di ntn? Đóng vào Json.
//            //dong response
//        } catch (DBException ex) {
//            Logger.getLogger(GetListClassCmd.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    public String getResponse() {
        try {
            super.getResponse();
            resultDataJson.put("listClass", lstClass);

            outJson.put("resultDataJson", resultDataJson);
        } catch (JSONException ex) {
            Logger.getLogger(GetListClassCmd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return outJson.toString();
    }

}
