package com.seele.thread;

public class WorkerThread implements Runnable {
	
	private String command;
	
	WorkerThread(String commend){
		this.command = commend;
	}
	
	@Override
	public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.");
	}
	
	private void processCommand() {
        try {
            Thread.sleep(5000); //模拟业务执行时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public String toString(){
        return this.command;
    }
}
