class Gen<T>{

	T ob;

	Gen(T o){ ob =o;}

	T getOb() {return ob;}

	void showType(){
		System.out.println("Type of ob is "+ob.getClass().getName());
	}
}

class GenDemo{
	public static void main(String[] args) {
		
		Gen<Integer> iOb;

		iOb=new Gen<Integer>(88);

		iOb.showType();

		int i = iOb.getOb();

		System.out.println("Value of i: "+i);

		Gen<String> sOb=new Gen<String>("string type");

		sOb.showType();

		String str=sOb.getOb();

		System.out.println("Value of str: "+str);
	}
}