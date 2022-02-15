enum Apple{
	Johnatan(10), Goldendel(9), RedDel, WineSap(15),Cortland(8);

	private int price;

	Apple(int p){
		price=p;
	}

	Apple(){
		price=-1;
	}

	int getPrice(){return price;}
}

class EnumDemo2{
	public static void main(String[] args) {

		System.out.println("Price of WineSap: "+Apple.WineSap.getPrice());

		for(var a:Apple.values())
			System.out.println(a+" costs "+a.getPrice()+" cents");

	}
}