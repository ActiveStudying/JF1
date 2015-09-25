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
public interface ISynchDispatcher<E> extends IDispatcher<E>{
    
        E dispatch(Object item);
        //Object excecute();
}
