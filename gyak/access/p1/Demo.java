package p1;

class Demo{
	public static void main(String[] args) {
		
		System.out.println("Protection");
		Protection ob1=new Protection();
		
		System.out.println("Derived");
		Derived ob2=new Derived();

		System.out.println("Same Package");
		SamePackage ob3=new SamePackage();
	}
}