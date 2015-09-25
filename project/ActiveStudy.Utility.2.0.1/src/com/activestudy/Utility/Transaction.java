/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.Utility;

import java.util.Date;

/**
 *
 * @author tanhai
 */
public class Transaction {

    protected static final long nLimit = Long.parseLong("1000000000000");
    protected static long mModuleID = 1;
    protected static int mSequentID = 0;
    static long request_id = 0;

    private synchronized static long GetRequestID() {
        mSequentID = (mSequentID + 1) % 0x3E8;
        return (new Date().getTime()) % nLimit + (((mModuleID % 0x3E8) * 0x3E8) + mSequentID) * nLimit;
    }

    public synchronized static long GetRequestID(int moduleID) {
        mSequentID = (mSequentID + 1) % 0x3E8;
        return (new Date().getTime()) % nLimit + (((moduleID % 0x3E8) * 0x3E8) + mSequentID) * nLimit;
    }

    public long getmModuleID() {
        return Transaction.mModuleID;
    }

    public static void setmModuleID(int moduleID) {///ModuleID (0-99)
        Transaction.mModuleID = moduleID % 0x3E8;
        request_id = GetRequestID();
    }

}
