/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activestudy.pattern.entity.result;

/**
 *
 * @author tanhai
 */
public abstract class AbsResult implements IResult{
    private int errorCode = -1;
    private int errorDesc;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(int errorDesc) {
        this.errorDesc = errorDesc;
    }
    @Override
    public String toString(){
        return " errorCode: " + errorCode + " errorDesc: " + errorDesc;
    }
}
