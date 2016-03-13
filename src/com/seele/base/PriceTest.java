package com.seele.base;

public class PriceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(Price.instance.currentPrice);
        
        Price p = new Price(2.8);
        
        System.out.println(p.currentPrice);
	}

}
class Price{
	
	final static Price instance = new Price(2.8);
	
	static double initPrice = 20;
	
	double currentPrice;
	
    public Price(double discount){
    	currentPrice = initPrice - discount;
    }
}