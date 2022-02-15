package mypack;

public class Balance{
	String name;
	double bal;

	public Balance(String name,double bal){
		this.name=name;
		this.bal=bal;
	}

	public void show(){
		if(bal<0)
			System.out.println("-->");

		System.out.println(name+": $"+bal);

	}
}

public class AccountTest{

	public static void main(String[] args) {
		Balance current[]=new Balance[3];

		current[0]=new Balance("Endre",100.32);
		current[1]=new Balance("János",54.01);
		current[2]=new Balance("István",12.40);

		for (int i=0;i<3 ;++i )current[i].show(); 
			
	}
}