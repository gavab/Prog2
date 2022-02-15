package p1;

class Derived extends Protection{

	Derived(){
		System.out.println("Derived constuctor");

		System.out.println("n=="+n);
		//System.out.println("n_private=="+n_private);
		System.out.println("n_prot=="+n_prot);
		System.out.println("n_pub=="+n_pub);
	}
}