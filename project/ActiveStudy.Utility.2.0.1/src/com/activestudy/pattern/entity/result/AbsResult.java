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
    private String errorDesc;

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getErrorDesc() {
        return errorDesc;
    }

    @Override
    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }
    @Override
    public String toString(){
        return " errorCode: " + errorCode + " errorDesc: " + errorDesc;
    }
}
