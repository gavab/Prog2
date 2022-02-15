class TwoD{

	int x,y;

	TwoD(int x, int y){
		this.x=x;
		this.y=y;
	}
}

class ThreeD extends TwoD{
	int z;

	ThreeD(int x, int y, int z){
		super(x,y);
		this.z=z;
	}
}

class FourD extends ThreeD{

	int t;

	FourD(int x,int y, int z, int t){
		super(x,y,z);
		this.t=t;
	}
}

class Coords<T extends TwoD>{
	T[] coords;

	Coords(T[] o){ coords=o; }


}

class BoundedWildCard{

	static void showXY(Coords<?> c){
		System.out.println("Coords X Y: ");
		for (int i=0;i<c.coords.length ;i++ ) {
			System.out.println(c.coords[i].x+" "+c.coords[i].y);
		}
	}

	static void showXYZ(Coords<? extends ThreeD> c){
		System.out.println("Coords X Y Z: ");
		for (int i=0;i<c.coords.length ;i++ ) {
			System.out.println(c.coords[i].x+" "+c.coords[i].y+" "+c.coords[i].z);
		}
	}

	static void showAll(Coords<? extends FourD> c){
		System.out.println("Coords X Y Z T: ");
		for (int i=0;i<c.coords.length ;i++ ) {
			System.out.println(c.coords[i].x+" "+c.coords[i].y+" "+c.coords[i].z+" "+c.coords[i].t);
		}
	}

	public static void main(String[] args) {
		
		TwoD td[]={
			new TwoD(0,0),
			new TwoD(5,9),
			new TwoD(10,10),
			new TwoD(7,6),
		};

		Coords<TwoD> tdChoords=new Coords<TwoD>(td);

		showXY(tdChoords);


		FourD fd[]={
			new FourD(0,0,0,0),
			new FourD(5,9,1,4),
			new FourD(10,10,10,10),
			new FourD(7,6,7,6),
		};

		Coords<FourD> fdChoords=new Coords<FourD>(fd);

		showAll(fdChoords);
	}
}