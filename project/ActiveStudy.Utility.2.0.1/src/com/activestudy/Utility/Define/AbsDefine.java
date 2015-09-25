/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activestudy.Utility.Define;

/**
 *
 * @author tanhai
 */
public abstract class AbsDefine implements IDefine{
    public final static int KEY_NO_DEFINE         = -1000;        
    public final static int KEY_SUCCESS           = 0;    
    public final static int KEY_UNSUCCESS         = -1;    
    
    public final static String NAME_NO_DEFINE         = "NoName";
    public final static String NAME_SUCCESS           = "Success";    
    public final static String NAME_UNSUCCESS         = "Unsuccess";    

    @Override
    public String getName(int key) {
        switch(key){            
            case KEY_SUCCESS: return NAME_SUCCESS;
            case KEY_UNSUCCESS: return NAME_UNSUCCESS;
            case KEY_NO_DEFINE: return NAME_NO_DEFINE;
            default:
                return "";
        }        
    }

    @Override
    public int getKey(String name) {
        if( name.equalsIgnoreCase(NAME_SUCCESS)) return KEY_SUCCESS;
        if( name.equalsIgnoreCase(NAME_UNSUCCESS)) return KEY_UNSUCCESS;
        if( name.equalsIgnoreCase(NAME_NO_DEFINE)) return KEY_NO_DEFINE;
        return KEY_NO_DEFINE;
    }
}

