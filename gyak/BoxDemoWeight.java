class Box{
	double width;
	double height;
	double length;

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

	BoxWeight(double w, double d, double h,double m){
		super(w,h,d);
		weight=m;
	}

}

class BoxDemoWeight{
	public static void main(String[] args) {
		
		BoxWeight weightBox=new BoxWeight(10,20,30,5.5);
		
		Box plainBox=new Box();

		double vol= weightBox.volume();

		System.out.println("box1 vol "+vol);
		System.out.println("box1 weight "+weightBox.weight);

		plainBox=weightBox;

		vol=plainBox.volume();

		System.out.println("plainBox vol "+vol);
		//System.out.println("plainBox weight "+plainBox.weight);
	}
}