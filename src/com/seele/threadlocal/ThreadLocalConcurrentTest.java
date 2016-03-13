package com.seele.threadlocal;
/**
 * 测试ThreadLocal不具备解决共享变量问题
 * */
public class ThreadLocalConcurrentTest {

	private static ThreadLocal<Integer> tlocal = new ThreadLocal<Integer>(){
		public Integer initialValue() {  
            return 0;  
        }  
	};
	
	private static int i = 1; //多线程并发竞争变量
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new MyThread());
		Thread t2 = new Thread(new MyThread());
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(i);
	}

	
	private static class MyThread implements Runnable {
		@Override
		public void run() {
			System.out.println("thread[" + Thread.currentThread().getName() + "]-->" + i);
			if(i>0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i--;
			}	
			System.out.println("thread[" + Thread.currentThread().getName() + "]-->" + i);
		}
	}

}
