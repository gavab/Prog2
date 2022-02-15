class Box{
	private double width;
	private double height;
	private double length;

	Box(){
		width=0;
		length=0;
		height=0;
	}

	Box(Box ob){
		this.length=ob.length;
		this.width=ob.width;
		this.height=ob.height;
	}

	Box(double len){
		length=width=height=len;
	}

	Box(double width,double length,double height){
		this.width=width;
		this.length=length;
		this.height=height;
	}

	double volume(){
		return height*width*length;
	}	


	void setDim(double w, double l, double h){
		width=w;
		height=h;
		length=l;
	}

	void setDim(double len){
		width=length=height=len;
	}

	void getDim(){
		System.out.println("width: "+width+" height: "+height+" length :"+length );
	}

}

class BoxWeight extends Box{
	double weight;


	BoxWeight(){
		super();
		weight=0;
	}

	BoxWeight(BoxWeight ob){
		super(ob);
		weight=ob.weight;
	}

	BoxWeight(double w, double d, double h,double m){
		super(w, h, d);
		weight=m;
	}

	BoxWeight(double len,double m){
		super(len);
		weight=m;
	}

}

class SuperDemo{
	public static void main(String[] args) {
		
		BoxWeight weightBox1=new BoxWeight(10,20,30,5.5);

		double vol= weightBox1.volume();
		System.out.println("weightBox1 vol "+vol);
		System.out.println("weightBox1 weight "+weightBox1.weight);

		BoxWeight weightBox2=new BoxWeight();

		vol= weightBox2.volume();
		System.out.println("weightBox2 vol "+vol);
		System.out.println("weightBox2 weight "+weightBox2.weight);

		BoxWeight weightBox3=new BoxWeight(10,3.5);

		vol= weightBox3.volume();
		System.out.println("weightBox3 vol "+vol);
		System.out.println("weightBox3 weight "+weightBox3.weight);

		BoxWeight weightBox4=new BoxWeight(weightBox1);

		vol= weightBox4.volume();
		System.out.println("weightBox4 vol "+vol);
		System.out.println("weightBox4 weight "+weightBox4.weight);



	}
}