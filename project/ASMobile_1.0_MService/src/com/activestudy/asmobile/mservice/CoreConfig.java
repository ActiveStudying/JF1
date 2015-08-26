/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.asmobile.mservice;

import com.activestudy.Utility.AbsConfig;

/**
 *
 * @author tanhai
 */
public class CoreConfig extends AbsConfig {

    private static CoreConfig instance;
    public static String CONFIG_PATH = "../../config/mhss/";
    private static final String CORE_CONFIG = CONFIG_PATH + "core.properties";

    public CoreConfig() {
        super();
        loadConfig();
    }

    @Override
    public boolean loadConfig() {
        return true;
    }

    public static synchronized CoreConfig getInstance() {
        if (instance == null) {

            instance = new CoreConfig();

        }
        return instance;
    }

}
