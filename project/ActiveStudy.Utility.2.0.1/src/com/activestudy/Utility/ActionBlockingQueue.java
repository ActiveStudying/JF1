/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.activestudy.Utility;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author tanhai
 */
public class ActionBlockingQueue implements java.util.Queue {

    BlockingQueue mQueue;    
    private int maxQueue = 2048;

    public ActionBlockingQueue(int maxQueue) {
        this.maxQueue = maxQueue;
        this.mQueue = new LinkedBlockingQueue();
    }

    public ActionBlockingQueue() {
        this.mQueue = new LinkedBlockingQueue();
    }

    public int getMaxQueue() {
        return maxQueue;
    }

    @Override
    public boolean add(Object e) {
        mQueue.add(e);
        return true;
    }

    @Override
    public boolean offer(Object e) {
        //tanth: Synch and notify;
        mQueue.offer(e);
        return true;
    }

    @Override
    public Object remove() {
        //tanth: Synch and throw exception if queue empty;
        return mQueue.remove();
    }

    public Object take() {
//tanth: Synch and wait;
        try {
            return mQueue.take();
        } catch (InterruptedException ex) {
            return null;
        }

    }

    @Override
    public Object poll() {
        return mQueue.poll();
    }

    @Override
    public Object element() {
        return mQueue.element();
    }

    @Override
    public Object peek() {
        return mQueue.peek();
    }

    @Override
    public int size() {
        return mQueue.size();
    }

    @Override
    public boolean isEmpty() {
        return mQueue.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return mQueue.contains(o);

    }

    @Override
    public Iterator iterator() {
        return mQueue.iterator();
    }

    @Override
    public Object[] toArray() {
        return mQueue.toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return mQueue.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return mQueue.remove(o);
    }

    @Override
    public boolean containsAll(Collection c) {
        return mQueue.containsAll(c);
    }

    @Override
    public boolean addAll(Collection c) {
        return mQueue.addAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        return mQueue.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection c) {
        return mQueue.retainAll(c);
    }

    @Override
    public void clear() {
        mQueue.clear();
    }

}
