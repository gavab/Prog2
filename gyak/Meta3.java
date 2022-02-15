import java.lang.annotation.*;
import java.lang.reflect.*;



@Retention(RetentionPolicy.RUNTIME)
@interface What{
	String description();
}



@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
	String str();
	int val();
}

@What(description="An annotation test method")
@MyAnno(str="Meta3", val=91)

class Meta3{

	@What(description="An annotation test method")
	@MyAnno(str="annotation example", val=100)

	public static void MyMethod(String s, int v){
		Meta3 ob=new Meta3();

		try{
			
			Annotation annos[]=ob.getClass().getAnnotations();

			System.out.println("Annotations for Meta3: ");

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