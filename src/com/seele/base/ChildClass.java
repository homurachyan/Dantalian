package com.seele.base;

import java.util.Vector;

public class ChildClass extends FatherClass {
    static Vector<Integer> v = new Vector<Integer>();
	final int x;  //实例变量
	int i = 3;  //实例变量
	String st; //实例变量
	
	public ChildClass(String name){
		this.name = name;
		System.out.println("child构造函数·····");
	}	
	public void ChildClass(){
		System.out.println("与构造函数同名的方法·····");
	}
	static {
		
		System.out.println("child静态初始化块·····");
	}
	
	{
		x = 3;//fianl变量初始化
		System.out.println("child非静态初始化块·····");
	}
	{
		System.out.println("child非静态初始化块2 s=" + st);
	}
    public static void doPost(){
    	System.out.println("invoke child methed");
    }

    public void doGet(){
    	System.out.println(super.i);
    }
    public static void changeRef(String s){
    	s = "b";
    }    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ChildClass cc = new ChildClass("123");
		cc.doPost();
		cc.doGet();
		/*			String str1 = "hello";
		String str2 = "he" + new String("llo");
		System.err.println(str1 == str2);
		
		String s1 = new String("1");
	    s1.intern();
	    String s2 = "1";
	    System.out.println(s1 == s2);

	    String s3 = new String("1") + new String("1");
	    s3.intern();
	    String s4 = "11";
	    System.out.println(s3 == s4);
	    
	    String s = null;

        System.out.println("s=" + s);*/
/*        final String len = "1";//宏替换
        String s5 = "11";
        String s6 = "1" + len;
        System.out.println(s5 == s6);
        System.out.println(System.identityHashCode(s5));
        System.out.println(System.identityHashCode(s6));
        System.out.println(s5.hashCode());
        System.out.println(s6.hashCode());
        
        changeRef(s5);
        System.out.println(System.identityHashCode(s5));
        
        String s7 = "com.seele.test";
        String[] sarray = s7.split("\\.");
        for(String s:sarray){
        	System.out.println(s);
        }*/
/*        for(int i=0;i<10000;i++){
        	v.add(i);
        }
        Thread t1 = new Thread(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
		        for(int i=0;i<v.size();i++){
		        	v.remove(i);
		        }
			}
        	
        });
        Thread t2 = new Thread(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
		        for(int i=0;i<v.size();i++){
		        	System.out.println(v.get(i));
		        }
			}
        	
        });
        t1.start();
        t2.start();
        while(Thread.activeCount()>100);*/
        
        StringBuffer sb;
        
        
        
	}
}