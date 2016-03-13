package com.seele.base;

public class MoreUseful extends Useful {
	
	public void d(){System.out.println("More.d()") ;}
    public void f(){System.out.println("More.f()") ;}
    public void u(){}
    public void g(){}
    
	public static void main(String[] args) {
		Useful[] x = {new Useful() , new MoreUseful()} ;
        x[0].f() ;
        x[1].d() ;
        ((MoreUseful)x[1]).u() ;
        ((MoreUseful)x[0]).g() ;    //编译时通过,运行时会产生ClassCastException
	}

}
