class GenMethodDemo{

	static <T extends Comparable<T>,V extends T> boolean isIn(T x, V[] v){

		for(int i=0;i<v.length;i++)
			if(x.equals(v[i]))
				return true;

		return false;
	}


	public static void main(String[] args) {
		Integer iNums[]={1,2,3,4,5};

		if(isIn(2,iNums))
			System.out.println("2 is in nums");


		if(isIn(6,iNums))
			System.out.println("6 is in iNums");
		else
			System.out.println("6 is not in iNums");

		String strNums[]={"one", "two", "three", "four"};

		if(isIn("two",strNums))
			System.out.println("Two is in strnums");



		if(isIn("six",strNums))
			System.out.println("Two is in strnums");
		else
			System.out.println("Six is not in strnums");

	}
}