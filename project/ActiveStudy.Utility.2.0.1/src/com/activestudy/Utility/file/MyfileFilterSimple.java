/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activestudy.Utility.file;
import java.io.File;
import java.io.FilenameFilter;
/**
 *
 * @author tanhai
 */
public class MyfileFilterSimple implements FilenameFilter{

    String[] filterString;    
    public MyfileFilterSimple(String filterString){
        this.filterString = filterString.split(",");
    }
    @Override
    public boolean accept(File dir, String name) {
        for(String e:filterString){
            if(name.endsWith(e)){
                return true;
            }
        }
        return false;
    }
    
}

