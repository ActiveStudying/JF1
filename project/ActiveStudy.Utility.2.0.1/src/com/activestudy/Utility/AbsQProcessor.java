/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activestudy.Utility;

import com.activestudy.Utility.Define.AbsDefine;

/**
 *
 * @author tanhai
 * Queue Processor thread
 */

public abstract class AbsQProcessor extends ActionThread{
    protected ActionQueue inputQueue;    
    private String name = AbsDefine.NAME_NO_DEFINE;
    
     public AbsQProcessor(String name, ActionQueue inputQueue){
        super(name);
        this.name = name;
        this.inputQueue = inputQueue;        
    }       

    public ActionQueue getInputQueue() {
        return inputQueue;
    }

    public void setInputQueue(ActionQueue inputQueue) {
        this.inputQueue = inputQueue;
    }

    //---------------------------------------------------------------------------------------------
    
}
