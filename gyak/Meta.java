import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)

@interface MyAnno{
	String str();
	int val();
}

class Meta{

	@MyAnno(str="annotation example", val=100)

	public static void MyMethod(){
		Meta ob=new Meta();

		try{
			Class<?> c=ob.getClass();

			Method m=c.getMethod("MyMethod");

			MyAnno anno=m.getAnnotation(MyAnno.class);

			System.out.println(anno.str()+" "+anno.val());
		}catch(NoSuchMethodException e){
			System.out.println("Method not found");
		}
	}

	public static void main(String[] args) {
		MyMethod();
	}
}