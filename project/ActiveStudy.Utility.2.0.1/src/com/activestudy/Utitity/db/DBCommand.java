package com.activestudy.Utitity.db;

import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public abstract class DBCommand
{
	protected int result;

	public abstract void invoke(DbConnectionExtra conn) throws Exception;
	/**
	 * call it in the worker' run to signal that this job has been solved
	 * Dont call it any where
	 * @return the done
	 */
	public final void closeItem(ResultSet resultSet)
	{
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (Exception e) {
		}		
	}
	
	public final void closeItem(CallableStatement callable)
	{
		try {
			if (callable != null)
				callable.close();
		} catch (Exception e) {
		}
		
	}
	
	public final void closeItem(Statement statement)
	{
		try {
			if (statement != null)
				statement.close();
		} catch (Exception e) {
		}		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return getClass().getSimpleName();
	}

	public int getResult() 
	{
		return this.result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(int result) {
		this.result = result;
	}
}

