package p1;

class SamePackage{
	SamePackage(){
		Protection p=new Protection();

		System.out.println("SamePackage constructor");
		
		System.out.println("n=="+p.n);
		//System.out.println("n_private=="+p.n_private);
		System.out.println("n_prot=="+p.n_prot);
		System.out.println("n_pub=="+p.n_pub);
	}
}