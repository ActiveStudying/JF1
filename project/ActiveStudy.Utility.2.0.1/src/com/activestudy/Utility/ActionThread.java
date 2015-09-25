/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.activestudy.Utility;

/**
 *
 * @author tanhai
 */
public abstract class ActionThread {

	/**
	 * sleeptime should return this value to indicate that, no need to sleep
	 */
	public static final int NO_SLEEP = -1;

	/**
	 * Period of time to sleep after an exception is raised
	 */
	public static final int EXCEPTION_SLEEP_TIME = 15000;

	/**
	 * Java standard thread instance
	 */
	private Thread thread = null;

	private String name;

	/**
	 * Constructor with the name of the thread is specified
	 * 
	 * @param name
	 *            String
	 */
	public ActionThread(String name) {
		this.name = name;
	}

	/**
	 * Constructor with no name of thread is specified
	 */
	public ActionThread() {
		this.name = null;
	}

	/**
	 * Get the name of this thread
	 * 
	 * @return String
	 */
	// public synchronized String getName() {
	public String getName() {
		return this.name;
	}

	/**
	 * Set the name of this thread
	 * 
	 * @param name
	 *            String
	 */
	// public synchronized void setName(String name) {
	public void setName(String name) {
		this.name = name;
		if (null != this.thread) {
			this.thread.setName(this.name);
		}
	}

	/**
	 * The parent thread which created this thread
	 */
	private Thread parentThread = null;

	/**
	 * Need-to-die, if this flag is true, the thread is required to stop its
	 * execution
	 */
	private boolean needToDie = false;

	/**
	 * Get need-to-die flag
	 */
	// private synchronized boolean getNeedToDie() {
	private boolean getNeedToDie() {
		return needToDie;
	}

	/**
	 * Start this thread
	 */
	public synchronized void execute() {
		// public void execute() {
		if (null == this.thread) {
			this.thread = new Thread(new ActionThreadImpl(this), this.name);
			parentThread = Thread.currentThread();
			needToDie = false;
			thread.setName(this.name);
			thread.start();
			while (!thread.isAlive())
				Thread.currentThread().yield();
		}
	}

	/**
	 * Require this thread to stop its execution by set the need-to-die flag
	 * equal to true Modified on 09/08/2007
	 */
	public synchronized void kill() {
		needToDie = true;

		try {
			if (Thread.currentThread() != this.thread) {
				while (this.thread.isAlive()) {
					if (!this.thread.isInterrupted()) {
						this.thread.interrupt();
					}
					this.thread.join();
				} // while
			}
		} catch (InterruptedException x) {
		} finally {
			this.thread = null;
		}
	}

	/**
	 * Added on 16/08/2007
	 */
	public boolean needToDie() {
		return needToDie;
	}

	/**
	 * For sleeping synchronize
	 */
	private Object sleepSync = new Object();

	/**
	 * Specifies whether this thread is sleeping
	 */
	private boolean sleeping = false;

	/**
	 * Interrupt the thread execution
	 */
	private void interrupt() {
		// synchronized (sleepSync) {
		// if (sleeping) thread.interrupt();
		thread.interrupt();
		// }
	}

	/**
	 * Wait for thread to die
	 */
	private void waitToDie() {
		try {
			thread.join();
		} catch (InterruptedException e) {
		}
	}

	/**
	 * Sleep to a period of time which is specified by the 'milliseconds'
	 * parameter.
	 * 
	 * @param milliseconds
	 *            long
	 */
	private void sleep(long milliseconds) {
		// synchronized (sleepSync) {
		try {
			sleeping = true;
			thread.sleep(milliseconds);
		} catch (InterruptedException e) {
		} finally {
			sleeping = false;
		}
		// }
	}

	/**
	 * This function is called once when the thread execution is started or
	 * restarted (see onException)
	 */
	protected abstract void onExecuting() throws Exception;

	/**
	 * This function is called once before the thread execution is finished
	 */
	protected abstract void onKilling();

	/**
	 * This function is called when an exception is raised, the implementation
	 * of the thread must be restarted, you should to release all your own
	 * resource in this function before it returns or call the 'kill' function
	 * to terminate this thread Note, after this function return, the thread
	 * implementation is restarted, so the 'onExecuting' function is re-called,
	 * but the 'onKilling' function is not re-called unless the 'kill' function
	 * is appeared in 'onException' function's body (in this case, the thread
	 * implementation will be stoped)
	 * 
	 * @param e
	 *            Exception
	 */
	protected abstract void onException(Exception e);

	/**
	 * Return the period of time to sleep between two actions, if NO_SLEEP is
	 * returned, requirement to sleep is ignored
	 * 
	 * @return long
	 */
	protected abstract long sleeptime() throws Exception;

	/**
	 * Action of this thread
	 */
	protected abstract void action() throws Exception;

	/**
	 * Implementation of an action thread
	 */
	private static class ActionThreadImpl implements Runnable {

		/**
		 * Reference to an action thread
		 */
		private ActionThread ref;

		/**
		 * Constructor with a reference to an action thread
		 * 
		 * @param ref
		 *            ActionThread
		 */
		public ActionThreadImpl(ActionThread ref) {
			this.ref = ref;
		}

		/**
		 * Thread execution
		 */
		public void run() {
			long milliseconds;
			do {
				try {
					ref.onExecuting();
					while (!ref.getNeedToDie()) {
						ref.action();
						if (!ref.getNeedToDie()) {
							milliseconds = ref.sleeptime();
							if (NO_SLEEP != milliseconds)
								ref.sleep(milliseconds);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					ref.onException(e);
					if (!ref.getNeedToDie()) {
						ref.sleep(EXCEPTION_SLEEP_TIME);
					}
				}
			} while (!ref.getNeedToDie());
			ref.onKilling();
		}

	}

}
