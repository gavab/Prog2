package p2;

class OtherPackage{
	OtherPackage(){
		p1.Protection p=new p1.Protection();

		System.out.println("OtherPackage constructor"); 
		//System.out.println("n=="+p.n);
		//System.out.println("n_private=="+p.n_private);
		//System.out.println("n_prot=="+p.n_prot);
		System.out.println("n_pub=="+p.n_pub);
	}
}