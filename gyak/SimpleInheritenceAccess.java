class A{
	int i;
	private int j;

	void setij(int a, int b){
		i=a;
		j=b;
	}

	int getj(){
		return j;
	}

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
		System.out.println("i+j+k== "+(i+getj()+k));
	}
}

class SimpleInheritenceAccess{

	public static void main(String[] args) {
		
		A superOb=new A();
		B subOb=new B();

		superOb.setij(10,20);
		

		System.out.println("Contents of superOb: ");
		superOb.showij();


		subOb.setij(20,25);
		subOb.k=30;

		System.out.println("Contents of subOb: ");
		subOb.showij();
		subOb.showk();

		System.out.println("Sum: ");
		subOb.sum();

	}
}