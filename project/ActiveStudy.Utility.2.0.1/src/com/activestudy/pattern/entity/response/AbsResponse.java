/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activestudy.pattern.entity.response;

import com.activestudy.Utility.Define.AbsDefine;
import com.activestudy.pattern.entity.request.IRequest;
import com.activestudy.pattern.entity.result.IResult;

/**
 *
 * @author tanhai
 */
public abstract class AbsResponse implements IResponse{
    private IRequest request;
    private IResult result;
    
    private long        responseID =AbsDefine.KEY_NO_DEFINE;
    private String      responseName = AbsDefine.NAME_NO_DEFINE;    

    public IRequest getRequest() {
        return request;
    }

    public void setRequest(IRequest request) {
        this.request = request;
    }

    public IResult getResult() {
        return result;
    }

    public void setResult(IResult result) {
        this.result = result;
    }

    public long getResponseID() {
        return responseID;
    }

    public void setResponseID(long responseID) {
        this.responseID = responseID;
    }

    public String getResponseName() {
        return responseName;
    }

    public void setResponseName(String responseName) {
        this.responseName = responseName;
    }

   
}
