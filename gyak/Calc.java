import java.util.*;
import java.lang.Math.*;
import java.lang.Character.*;
import java.io.Reader;
import java.io.InputStream;
import java.util.Scanner;


class Input {
	java.io.BufferedReader br = new java.io.BufferedReader(
			new java.io.InputStreamReader(System.in));
}

class CharSet extends Input{

	public static final char chnumber='8';
	public static final char chquit='q';
	public static final char chprint=';';
 	public static final char chresult='=';
	public static final char chlet='L';
	public static final char chname='a';
	public static final char chsquare_root='@';
	public static final char chpow_calc='#';
}

class stringSet extends CharSet{

	public static final String declkey="let";
	public static final String sqrtkey="sqrt";
	public static final String powkey="pow";
	 
}

class Variable extends stringSet {

	public static String name;
	public static double value;


	Variable(){
		name="";
		value=0;
	}

	Variable(String n, double val){
		name=n;
		value=val;
	}

};

class Control extends Variable{

	static Vector<Variable> var_table=new Vector<Variable>(10,10*2);

	Variable ob=new Variable("n",9);

	static boolean is_declared(String str){
		for(var v:var_table)
			if(v.name==str) return true;

		return false;
	}

	static double define_name(String str, double val){
		if(is_declared(str))System.out.println("Variable is declared"+str);
		var_table.add(new Variable(str,val));
		return val;
	}

	static double getValue(String s){
		for(var v:var_table)
			if(v.name==s)return v.value;
		System.out.println("Variable not defined");
		return 0;
	}

	static void setValue(String s, double d){
		for (var v:var_table ) 
			if(v.name==s){
				v.value=d;
				return;
			}

		System.out.println("set: Variable not defined");
	}

}

class Token extends Control{
	public static char kind;
	public static double value;
	public static String name;
	public Token(){
		kind=0;
	}
	public Token(char ch){
		kind=ch;
		value=0;
	}

	public Token(char ch, double val){
		kind=ch;
		value=val;
	}

	public Token(char ch, String s){
		kind=ch;
		name=s;
	}

}

class TokenStream extends Token{
	Token token_obj=new Token();

	java.io.BufferedReader br = new java.io.BufferedReader(
			new java.io.InputStreamReader(System.in));

	

	private static boolean full;
	private static Token buffer=new Token();

	public TokenStream(){
		full=false;
		Token buff=new Token();
		buffer=buff;
	}
	public Token get(){
		if(full){
			full=false;
			return buffer;
		}

	char ch;
	ch=(char)br.read();

		switch(ch){
			case chquit:
			case chprint:
			case '(':
			case ')':
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
			case '=':
			case ',':
				return new Token(ch);

			case '.':
			case '0': case '1': case '2': case '3': case '4': case '5': 
			case '6': case '7': case '8': case	'9':{

				//putback(ch);
				double val=0;
				val=br.read();
				return new Token(chnumber,val);
			}
			default:{
				java.io.BufferedReader br = new java.io.BufferedReader(
			new java.io.InputStreamReader(System.in));

				Character kar=(char)br.read();

				if(Character.isLetter(ch)){
					String s;
					s+=ch;
					while((Character.isLetter(ch)||Character.isDigit(ch))) s+=ch;
					kar.putback(ch);

					if(s==declkey)return new Token(chlet);
					else if(s==sqrtkey)return new Token(chsquare_root);
					else if(s==powkey)return new Token(chpow_calc);
					else if(is_declared(s))
						return new Token(chnumber, getValue(s));


					return new Token(chname, s);

				}

				System.out.println("Bad Token");
				return new Token() ;
				
			}

		}

	}
	public static void putback(Token t){

		if(full)System.out.println("TokenStream is full");
		buffer=t;
		full=true;

	}
	public static void ignore(char c){

		java.io.BufferedReader br = new java.io.BufferedReader(
			new java.io.InputStreamReader(System.in));

		if(full&& c==buffer.kind){
			full=false;
			return;
		}
		full=false;

		char ch;
		ch=(char)br.read();

		while(ch!=chquit)
			if(ch==c)return;

	}

	

}


class Funcs extends TokenStream {

	public static TokenStream ts=new TokenStream();


	public static double calc_sqrt(){

		java.io.BufferedReader br = new java.io.BufferedReader(
			new java.io.InputStreamReader(System.in));

		java.io.InputStreamReader isr = new java.io.InputStreamReader(System.in);

		char ch;
		ch=(char)br.read();


		if(ch !='(')System.out.println("'(' expected");
		//isr.putback(ch);
		double d=expression();
		if(d<0)System.out.println("sqrt: negative value");
		return Math.sqrt(d);

	}

	public static double calc_pow(){
		Token t=new Token();
		t=ts.get();

		if(t.kind!='(')System.out.println("'(' expected");
		double d=expression();

		if(t.kind!=',')System.out.println("',' expected");
		double d2=expression();
		t=ts.get();
		if(t.kind!=')')System.out.println("')' ");


		return Math.pow(d,d2);
	}


	public static double primary(){

		Token t= new Token();

		t=ts.get();

		switch(t.kind){

			case '(':
			{
				double d=expression();
				t=ts.get();
				if(t.kind!=')')System.out.println("')' expected");
				return d;
			}

			case chnumber:
				return t.value;
			case '-':
				return - primary();
			case '+':
				return primary();
			case chsquare_root:
				return calc_sqrt();
			case chpow_calc:
				return calc_pow();
			default:
				System.out.println("primary expected");
				return 0;
		}
	}


	public static double term(){
		double left =primary();

		Token t=new Token();
		t=ts.get();

		while(true){
			switch(t.kind){
				case '*':
					left*=primary();
					t=ts.get();
					break;

				case '/':{
					double d=primary();
					if(d==0){
						System.out.println("divided by zero");
					}
					left/=d;
					t=ts.get();
					break;
				}

				/*case '%':
				{
					double d=primary();
					if(d==0)System.out.println("%: zero divider");
					left=mod(left,d);
					t=ts.get();
					break;
				}*/

				default:
					ts.putback(t);
					return left;
			}

		}
	}


	public static double expression(){

		double left=term();
		Token t=new Token();
		t=ts.get();

		while(true){
			switch(t.kind){
				case '+':
					left+=term();
					t=ts.get();
					break;

				case '-':
				left-=term();
				t=ts.get();
				break;

				default:
					ts.putback(t);
					return left;
			}
		}
	}

	public static void CleanUpMess(){
		ts.ignore(chprint);
	}

	public static double declaration(){
		Token t=new Token();
		t=ts.get();

		if(t.kind!=chname)System.out.println("Name expected in declaration");
		String var_name=t.name;

		Token t2=new Token();

		t2=ts.get();
		if(t2.kind!='=')System.out.println("= expected in declaration");

		double d=expression();

		define_name(var_name, d);
		return d;
	}

	public static double statement(){
		Token t=new Token(); 
		t=ts.get();

		switch(t.kind){
			case chlet:
				return declaration();
			default:
				ts.putback(t);
				return expression();
		}
	}

	public static void calculate(){

		java.io.BufferedReader cr = new java.io.BufferedReader(
			new java.io.InputStreamReader(System.in));

		java.io.InputStreamReader isr = new java.io.InputStreamReader(System.in);

		while(isr.ready())
			try{
				Token t=new Token();
				t=ts.get();

				while(t.kind==chprint)t=ts.get();
				if(t.kind==chquit) return;

				ts.putback(t);

				System.out.println(chresult+statement());

			}catch(Exception e){
				System.out.println("Exception"+e);
				CleanUpMess();
			}
	}
}



class Calc extends Funcs{

	
		public static void main(String[] args) throws java.io.IOException{
		try{
			
			System.out.println("Welcome to Java Calulator");

			define_name("pi", 3.14159);
			define_name("e", 2.71828);

			calculate();


		}catch(RuntimeException e){
			System.out.println("RuntimeException "+e);
		}
	}
}