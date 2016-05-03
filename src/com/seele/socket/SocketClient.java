package com.seele.socket;

import java.io.UnsupportedEncodingException;

public class SocketClient {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String str = "兔宝宝";
		
		byte[] a = new byte[3];
		
		byte[] b = str.getBytes("utf-8");
		
/*		for(int i=0;i<a.length;i++){
			a[i] = b[i];
		}*/

		a[0] = b[3];
		a[1] = b[4];
		a[2] = b[7];
		
		System.out.println(new String(a));
	}
}
