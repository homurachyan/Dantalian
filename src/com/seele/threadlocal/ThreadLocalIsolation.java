package com.seele.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试ThreadLocal线程本地变量是否是拷贝
 * */
public class ThreadLocalIsolation {
	
	private static ThreadLocal<Integer> tlocal = new ThreadLocal<Integer>(){
		public Integer initialValue() {  
            return 0;  
        }  
	};
	
	private static ThreadLocal<Map> tlocal2 = new ThreadLocal<Map>(){
		public Map initialValue() {  
            return null;  
        }  
	};
	
	private static int i = 1; //多线程并发竞争变量
	
	private static Map map = new HashMap();
	static {  
	    map.put("key1", "value1");  
	    map.put("key2", "value2");  
	}  
	
	public int getNextNum() {
		tlocal.set(i+1);
		return tlocal.get();
	}
	
	public Map modifyMap(){
		tlocal2.set(map);
		//Map temp = tlocal2.get();
		//temp.put("key2", "value3");
		return tlocal2.get();
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadLocalIsolation test = new ThreadLocalIsolation();
		
		Thread t1 = new Thread(new MyThread(test));
		Thread t2 = new Thread(new MyThread(test));
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(i);
		System.out.println(map.get("key2").toString());
	}
	
	private static class MyThread implements Runnable {
		
		private ThreadLocalIsolation test;
		
		MyThread(ThreadLocalIsolation test){
			this.test = test;
		}
		@Override
		public void run() {
	        if("Thread-0".equals(Thread.currentThread().getName())){
	        	//test.getNextNum();
	        	Map map2 = test.modifyMap();
	        	System.out.println("thread[" + Thread.currentThread().getName() + "]-->" + map2.get("key2").toString());
	        }
			//System.out.println("thread[" + Thread.currentThread().getName() + "]-->" + test.getNextNum());
		}
	}
	
}
