class Stats<T extends Number>{

	T[] numb;

	Stats(T[] o){numb=o;}

	double average(){

		double sum=0.0;

		for(int i=0;i<numb.length;i++)
			sum+=numb[i].doubleValue();

		return sum/numb.length;
	} 

	boolean sameAvg(Stats<?> ob){

		if(average()==ob.average())
			return true;

		return false;
	}

}

class BoundDemo{

	public static void main(String[] args) {
		
		Integer inums[]={1,2,3,4,5,6};

		Stats<Integer> iStats=new Stats<Integer>(inums);

		double iAvg= iStats.average();

		System.out.println("iAvg= "+iAvg);


		Integer inums2[]={1,2,3,4,5,6};

		Stats<Integer> iStats2=new Stats<Integer>(inums2);

		double iAvg2= iStats2.average();

		System.out.println("iAvg2= "+iAvg2);


		Double dnums[]={1.3,2.6,3.7,4.1,5.4,6.2};

		Stats<Double> dStats=new Stats<Double>(dnums);

		double dAvg= dStats.average();

		System.out.println("dAvg= "+dAvg);


		Float fnums[]={1.3F,2.6F,3.7F,4.1F,5.4F,6.2F};

		Stats<Float> fStats=new Stats<Float>(fnums);

		double fAvg= fStats.average();

		System.out.println("fAvg= "+fAvg);


		if(fStats.sameAvg(dStats))
			System.out.println("Averages are the same");
		else
			System.out.println("The Averages are not the same");

		if(iStats.sameAvg(iStats2))
			System.out.println("Averages are the same");
		else
			System.out.println("The Averages are not the same");
	}
}