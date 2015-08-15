/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activestudy.pattern.behavioral.command;

import com.activestudy.Utility.AbsQProcessor;
import com.activestudy.Utility.ActionQueue;

/**
 *
 * @author tanhai
 */
public abstract class AbsCommandProcessor extends AbsQProcessor{

    public AbsCommandProcessor(String name, ActionQueue inputQueue) {
        super(name, inputQueue);

    }

    //---------------------------------------------------------------------------------------------
    @Override
    protected void action() throws Exception {        
        ICommand command = null;
        try {
            command = (ICommand)inputQueue.remove();      
            if (command != null) {
                  command.execute();
            }                  
        } finally {
           
        }
    }
//---------------------------------------------------------------------------------------------
    @Override
    protected void onExecuting() throws Exception {
        
    }

    @Override
    protected void onKilling() {
        
    }
       
    @Override
    protected long sleeptime() throws Exception {
        return 1;
    }
    
    
}
