enum Apple{
	Johnatan, Goldendel, RedDel, WineSap,Cortland
}

class EnumDemo{
	public static void main(String[] args) {
		Apple ap;

		ap=Apple.WineSap;

		System.out.println("Value of ap: "+ap);

		ap=Apple.Johnatan;

		System.out.println("Value of ap: "+ap);

		if(ap==Apple.Johnatan)
			System.out.println("ap contains Johnatan");


		switch(ap){
			case Johnatan:
			System.out.println("Johnatan is red");
			break;

			case Goldendel:
			System.out.println("Goldendel is yellow");
			break;

			case RedDel:
			System.out.println("RedDel is red");
			break;

			case WineSap:
			System.out.println("WineSap is red");
			break;

			case Cortland:
			System.out.println("Cortland is red");
			break;
		}

		Apple allApples[]=Apple.values();

		for(var a:allApples)
			System.out.println(a);

	}
}