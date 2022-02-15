package appstart.mymodappdemo;

import appfuncs.simplefunc.SimpleMathFuncs;
import appsupport.supportfuncs.SupportFuncs;

public class MyModAppDemo{

	public static void main(String[] args) {
		
		if(SupportFuncs.isFactor(2,10))
			System.out.println("2 is a factor 10");

		System.out.println(
			"Smallest factor common 35 and 105 is "+ SimpleMathFuncs.lcf(35,105));
		
		System.out.println(
			"Largest factor common 35 and 105 is "+ SimpleMathFuncs.gcf(35,105));

	}
}