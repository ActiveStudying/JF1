package vn.edu.activestudy.activestudy.util;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AsyncTaskTools {
	public static <P, T extends AsyncTask<P, ?, ?>> void execute(T task) {
        execute(task, (P[]) null);
    }

    @SuppressLint("NewApi")
    public static <P, T extends AsyncTask<P, ?, ?>> void execute(T task, P... params) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
        	//Set number Thread in Pool
        	Executor myExecutor = Executors.newFixedThreadPool(10);
//            task.executeOnExecutor(myExecutor, params);
        	task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
        } else {
            task.execute(params);
        }
    }
}
