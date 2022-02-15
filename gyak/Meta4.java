import java.lang.annotation.*;
import java.lang.reflect.*;



@Retention(RetentionPolicy.RUNTIME)
@interface What{
	String description();
}



@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
	String str() default "Testing";
	int val() default 9999;
}

@What(description="An annotation test class")
@MyAnno()

class Meta4{

	@What(description="An annotation test method")
	@MyAnno(str="annotation example")

	public static void MyMethod(String s, int v){
		Meta4 ob=new Meta4();

		try{
			
			Annotation annos[]=ob.getClass().getAnnotations();

			System.out.println("Annotations for Meta4: ");

			for(var a:annos)
				System.out.println(a);


			Method m=ob.getClass().getMethod("MyMethod", String.class,int.class);

			annos=m.getAnnotations();

			System.out.println("Annotations for MyMethod: ");

			for (var a:annos) {
				System.out.println(a);
			}


		}catch(NoSuchMethodException e){
			System.out.println("Method not found");
		}
	}

	public static void main(String[] args) {
		MyMethod("test", 10);
	}
}