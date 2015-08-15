/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//comment

package com.activestudy.asmobile.mauthen;


import com.activestudy.asmobile.mauthen.command.ActiveCmd;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.sun.jersey.spi.resource.Singleton;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author tanhai
 */
@Produces("application/json")
@Path("mapp")
@Singleton
public class MappWSAPI {

    private Log logger = null;

    public MappWSAPI() {
        System.out.print("MappWSAPI INIT \n");
        logger = LogFactory.getLog(this.getClass());
        logger.info("Started Web Service for Mapp !!!!");
        
    }

    @POST
    @Path("activate")
    public String activate(String content) {       
        
        String email = "";
        String deviceID = "";
        String deviceName = "";
        String osName = "";
        String osVersion = "";
        String cloudKey = "";
        String devOther = "";
        
        ActiveCmd activeCmdObj = new ActiveCmd();
        activeCmdObj.execute();

        logger.debug("[" + email + "," + deviceID
                + "] - Activate response = " + activeCmdObj.getResponse());

        return activeCmdObj.getResponse();
    }

}
