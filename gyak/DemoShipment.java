class Box{
	private double width;
	private double height;
	private double length;

	Box(){
		width=0;
		length=0;
		height=0;
		System.out.println("BoxWeight() constructor");
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
		weight=0;
		System.out.println("BoxWeight() constructor");
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

class Shipment extends BoxWeight{

	double cost;

	Shipment(Shipment ob){
		super(ob);
		cost=ob.cost;
	}

	Shipment(){
		cost=0;
		System.out.println("Shipment() constructor");	
	}
	Shipment(double w, double h, double l, double m, double c){
		super(w,h,l,m);
		cost=c;
	}

	Shipment(double len, double m, double c){
		super(len,m);
		cost=c;
	}
}


class DemoShipment{
	public static void main(String[] args) {
		
		Shipment ship1=new Shipment(10,20,15,10,3.41);
		Shipment ship2=new Shipment(10,20,30,40,42);

		double vol=ship1.volume();
		
		System.out.println("Ship1 vol: "+vol);
		System.out.println("Ship1 weight: "+ship1.weight);
		System.out.println("Ship1 cost: "+ship1.cost);		

		vol=ship2.volume();

		System.out.println("Ship2 vol: "+vol);
		System.out.println("Ship2 weight: "+ship2.weight);
		System.out.println("Ship2 cost: "+ship2.cost);

		Shipment ship3=new Shipment();

		ship3=ship2;

		vol=ship3.volume();

		System.out.println("Ship3 vol: "+vol);
		System.out.println("Ship3 weight: "+ship3.weight);
		System.out.println("Ship3 cost: "+ship3.cost);

		Shipment ship4=new Shipment(ship3);

		vol=ship4.volume();

		System.out.println("Ship4 vol: "+vol);
		System.out.println("Ship4 weight: "+ship4.weight);
		System.out.println("Ship4 cost: "+ship4.cost);

	}
}