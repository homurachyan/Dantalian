package com.seele.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "lalala";
        
        WeakReference<String> wr = new WeakReference<String>(s);
        
        s = null;
        
        System.out.println(wr.get());
        
        System.gc();
        
        System.runFinalization();
        
        System.out.println(wr.get());       
	}

}
