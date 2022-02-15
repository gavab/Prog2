class AutoBox{

	static int m(Integer v){
		return v;
	}

	public static void main(String[] args) {
		int a =6;

		double s=1.5;

		double sa=s*a;

		Integer iOb=Integer.valueOf(a);

		Integer iOb2=Integer.valueOf(100);

		Integer iOb3=100;

		System.out.println(sa);

		System.out.println(iOb.intValue());
		System.out.println(iOb2.intValue());
		System.out.println(iOb3);

		System.out.println(m(420));

	}
}