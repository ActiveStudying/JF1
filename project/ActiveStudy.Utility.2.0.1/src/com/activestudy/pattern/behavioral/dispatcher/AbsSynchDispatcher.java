/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.pattern.behavioral.dispatcher;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Iterator;
import com.activestudy.Utility.ActionCache;

/**
 *
 * @author tanhai
 */
public class AbsSynchDispatcher<E> implements ISynchDispatcher<E> {

    private STRATEGY strategy = STRATEGY.STRATEGY_LOADBALANCE;
    Collection<Executor> ExecutorList = new LinkedList<Executor>();

    //-------------------------------------------------------------------------------------

    public AbsSynchDispatcher(Collection<? extends E> m, STRATEGY strategy) {
        for (Iterator<? extends E> iter = m.iterator(); iter.hasNext();) {
            E element = iter.next();
            Executor dispatcherObj = new Executor(element);
            ExecutorList.add(dispatcherObj);

        }
        this.strategy = strategy;

    }

    private AbsSynchDispatcher() {

    }

    //------------------------------------------------------------------------------------

    @Override
    public E dispatch(Object item) {
        switch (strategy) {
            case STRATEGY_LOADBALANCE:
                return dispatchLoadBalance(item);
            case STRATEGY_RANDOM:
                return dispatchLoadBalance(item);
            case STRATEGY_KEY:
                return dispatchLoadBalance(item);
            default:
                return dispatchLoadBalance(item);
        }
    }

    //-------------------------------------------------------------------------------------

    public E dispatchLoadBalance(Object item) {
        Executor result = null;
        long minCount = 0;
        for (Executor e : ExecutorList) {
            if (result == null) {
                result = e;
                minCount = e.count;
            } else {
                if (e.count < minCount) {
                    result = e;
                    minCount = e.count;
                }
            }        
        }
        result.count++;
        return (E) result.excecuter;
    }

    //------------------------------------------------------------------------------------

    public STRATEGY getStrategy() {
        return strategy;
    }

    public void setStrategy(STRATEGY strategy) {
        this.strategy = strategy;
    }

}
