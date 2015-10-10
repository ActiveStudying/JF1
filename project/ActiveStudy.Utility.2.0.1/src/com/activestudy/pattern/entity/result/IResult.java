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
public interface IResult {
    public int getErrorCode() ;

    public void setErrorCode(int errorCode) ;

    public String getErrorDesc() ;

    public void setErrorDesc(String errorDesc);
    
    public String toString();
}
