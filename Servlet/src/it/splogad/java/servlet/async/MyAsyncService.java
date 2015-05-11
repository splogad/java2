package it.splogad.java.servlet.async;

import javax.servlet.AsyncContext;

public class MyAsyncService implements Runnable{
	AsyncContext asc;
	
	public MyAsyncService(AsyncContext asc) {
    	this.asc = asc;
        // TODO Auto-generated constructor stub
    }
	public void run(){
		//Thread.sleep(3000);
		asc.complete();
	}	
}

