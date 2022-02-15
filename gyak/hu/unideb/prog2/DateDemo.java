package hu.unideb.prog2;

class Date implements Comparable<Date>{

	private int year;
	private int month;
	private int day;

	Date(){
		year=2001;
		month=1;
		day=1;
	}

	Date(int y, int m, int d){
		year=y;
		month=m;
		day=d;
	}

	int getYear(){return year;}
	int getMonth(){return month;}
	int getDay(){return day;}

	void setYear(int y){year=y;}
	void setMonth(int m){month=m;}
	void setDay(int d){day=d;}

	@Override
	public String toString(){
		return year+". "+month+". "+day+".";
	}

	@Override
	public boolean equals(Object obj){

		
		if(obj == this) return true;

		if(!(obj instanceof Date))return false;

		Date dd=(Date) obj;

		return dd.year==year&& dd.month==month&& dd.day==day;
	}


	@Override
	public int compareTo(Date o){
		if(year!=o.year) return year-o.year;
		if(month!=o.month) return month-o.month;
		if(day!=o.day) return day-o.day;

		return 0;

	}

}

public class DateDemo{

	public static void main(String[] args) {
		Date today=new Date(2021,11,9);
		Date def=new Date();

		Date tomorrow=new Date(2021,11,10);

		System.out.println(today);
		System.out.println(today);

		if(today.equals(tomorrow))
			System.out.println("Equals");
		else
			System.out.println("Not equal");


		java.util.ArrayList<Date> dates=new java.util.ArrayList<>();

		dates.add(new Date(14700,10,8));
		dates.add(new Date(22000,3,1));
		dates.add(today);
		dates.add(tomorrow);
		

		System.out.println("Print dates unsorted");
		for(var date:dates)
			System.out.println(date);

		java.util.Collections.sort(dates);

		System.out.println("Print dates sorted");
		for(var date:dates)
			System.out.println(date);


		java.util.Iterator<Date> it= dates.iterator();


		System.out.println("Print dates sorted with iterator");
		while(it.hasNext())
			System.out.println(it.next());



		java.util.HashSet<Date> dateSet=new java.util.HashSet<>();

		dateSet.add(today);
		dateSet.add(tomorrow);
		dateSet.add(today);

		System.out.println("dateSet");

		for(var date:dateSet)
			System.out.println(date);

	}
}