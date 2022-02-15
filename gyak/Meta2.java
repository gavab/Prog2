import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)

@interface MyAnno{
	String str();
	int val();
}

class Meta2{

	@MyAnno(str="annotation example", val=100)

	public static void MyMethod(String s, int v){
		Meta2 ob=new Meta2();

		try{
			Class<?> c=ob.getClass();

			Method m=c.getMethod("MyMethod" String.class, int.class);

			MyAnno anno=m.getAnnotation(MyAnno.class);

			System.out.println(anno.str()+" "+anno.val());
		}catch(NoSuchMethodException e){
			System.out.println("Method not found");
		}
	}

	public static void main(String[] args) {
		MyMethod("test", 10);
	}
}