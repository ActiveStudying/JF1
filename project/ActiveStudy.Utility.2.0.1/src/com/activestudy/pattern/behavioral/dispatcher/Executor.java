/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activestudy.pattern.behavioral.dispatcher;

/**
 *
 * @author tanhai
 */
public class Executor {
    Object excecuter = null;
    long count = 0;
    public Executor(Object excecuter){
        this.excecuter = excecuter;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Object getExcecuter() {
        return excecuter;
    }

    public void setExcecuter(Object excecuter) {
        this.excecuter = excecuter;
    }
    
    
}
