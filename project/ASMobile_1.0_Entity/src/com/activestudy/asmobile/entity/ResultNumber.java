/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.entity;

import com.activestudy.pattern.entity.result.AbsResult;

/**
 *
 * @author PC
 */
public class ResultNumber extends AbsResult {

    public final static int SUCCESS = 0;
    public final static int SYSTEM_ERROR = -1;
    
    public final static int MAUTHEN_SESSIONID_INVALIDFORMAT = 1;
    public final static int MAUTHEN_ACCOUNTID_INVALIDFORMAT = 2;
    public final static int MAUTHEN_ACCOUNTID_NOTEXIST = 3;
    public final static int MAUTHEN_OTPCODE_INVALIDFORMAT = 4;
    public final static int MAUTHEN_AUTHENID_INVALIDFORMAT = 5;
    public final static int MAUTHEN_DEVICEID_EMPTY = 8;

    public final static int SERVICEID_INVALIDFORMAT = 6;
    public final static int OVER_NUMBERRETRY_OTPCODE = 7;
    
    
    
}
