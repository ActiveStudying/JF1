/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.Utility;

import org.apache.commons.logging.Log;

/**
 *
 * @author tanhai
 */
public class RuntimeThread extends ActionThread{
    Log logger = null;
    long sleepTime = 60000;
    public RuntimeThread(Log logger, long sleepTime) {
        super("Runtime");
        this.logger = logger;
        this.sleepTime = sleepTime;
    }
    public RuntimeThread(Log logger) {
        super("Runtime Thread");
        this.logger = logger;        
    }

    @Override
    protected void onExecuting() throws Exception {
        logger.info("Starting thread + " + getName());
    }

    @Override
    protected void onKilling() {
        logger.info("Killing thread + " + getName());
    }

    @Override
    protected void onException(Exception e) {
        logger.info("Exception thread + " + getName() + " : " + e.getMessage(),e);
    }

    @Override
    protected long sleeptime() throws Exception {
        return this.sleepTime;
    }

    @Override
    protected void action() throws Exception {
        logger.info(MCommonUtils.getCurrentMemInfo());
    }
    
}
