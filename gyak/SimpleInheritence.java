class A{
	int i, j;

	void showij(){
		System.out.println("i== "+i+" j== "+j);
	}
}
class B extends A{
	int k;

	void showk(){
		System.out.println("k== "+k);
	}

	void sum(){
		System.out.println("i+j+k== "+(i+j+k));
	}
}

class SimpleInheritence{

	public static void main(String[] args) {
		
		A superOb=new A();
		B subOb=new B();

		superOb.i=10;
		superOb.j=20;

		System.out.println("Contents of superOb: ");
		superOb.showij();


		subOb.i=20;
		subOb.j=25;
		subOb.k=30;

		System.out.println("Contents of subOb: ");
		subOb.showij();
		subOb.showk();

		System.out.println("Sum: ");
		subOb.sum();

	}
}