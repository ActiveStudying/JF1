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
    
    public final static int MAUTHEN_ACCOUNTID_INVALIDFORMAT = 2;
    public final static int MAUTHEN_DEVICEID_EMPTY = 3;

}
