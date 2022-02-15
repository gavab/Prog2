class Two<T, V>{

	T ob1;
	V ob2;

	Two(T o1,V o2){ 
		ob1 = o1;
		ob2 = o2;
	}

	T getOb1() {return ob1;}

	V getOb2() {return ob2;}

	void showType(){
		System.out.println("Type of ob1 is "+ob1.getClass().getName());
		System.out.println("Type of ob2 is "+ob2.getClass().getName());
	}
}

class SimpGen{
	public static void main(String[] args) {
		
		Two<Integer,String> iOb=new Two<Integer,String>(88,"string type");

		iOb.showType();

		int i = iOb.getOb1();

		System.out.println("Value of i: "+i);

		String str=iOb.getOb2();

		System.out.println("Value of str: "+str);
	}
}