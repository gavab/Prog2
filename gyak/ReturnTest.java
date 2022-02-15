class Test{
	int a;

	Test(int i){
		a=i;
	}	

	Test incByTen(){
		Test temp=new Test(a+10);
		return temp;
	}

}

class RetOb{
	public static void main(String[] args) {
		
		Test ob1=new Test(10);

		Test ob2;

		ob2=ob1.incByTen();

		System.out.println("ob1.a "+ ob1.a);

		System.out.println("ob2.a "+ ob2.a);


	}
}