/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activestudy.pattern.behavioral.dispatcher;
//import java.lang;
import java.lang.Object;
import java.util.Collection;
/**
 *
 * @author tanhai
 * @param <E>
 */
public interface IDispatcher<E> {
        
    enum STRATEGY{
        STRATEGY_LOADBALANCE,
        STRATEGY_RANDOM,
        STRATEGY_KEY
    }

}
