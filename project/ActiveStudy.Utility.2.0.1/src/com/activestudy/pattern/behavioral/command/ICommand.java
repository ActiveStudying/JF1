/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activestudy.pattern.behavioral.command;

import com.activestudy.Utility.IExcecuteAble;

/**
 *
 * @author tanhai
 */
public interface ICommand extends IExcecuteAble{    
    long getCommandID();
    void setCommandID(long commandID);    
}
