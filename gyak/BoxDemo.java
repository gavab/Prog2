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

class BoxDemo{
	public static void main(String[] args) {
		
		Box myBox1 =new Box();

		myBox1.width=10;
		myBox1.length=30;
		myBox1.height=20;

		double vol=myBox1.volume();

		System.out.println("MyBox1 volume is "+vol);

		Box myBox2=new Box(myBox1);
		
		System.out.println("MyBox2 volume is "+myBox2.volume());

		Box myBox3=new Box(10.0);

		System.out.println("MyBox3 volume is "+myBox3.volume());

		Box myBox4=new Box(10.0, 20.0, 30.0);

		System.out.println("MyBox4 volume is "+myBox4.volume());

		myBox4.setDim(10.0);
		System.out.println("MyBox4(1 param) volume is "+myBox4.volume());

		myBox4.setDim(10.0, 20.0, 30.0);
		System.out.println("MyBox4(3 param) volume is "+myBox4.volume());

		myBox4.getDim();

	}
}