import java.io.*;

class ShowFile{
	public static void main(String[] args) {
		
		int i;

		if(args.length !=1){
			System.out.println("Usage: ShowFile filename");
			return;
		}

		try(FileInputStream fin=new FileInputStream(args[0])){

			do{
				i=fin.read();
				if(i!=-1)System.out.println((char)i);
			}while(i!=-1);

			fin.close();

		}catch(FileNotFoundException e){
			System.out.println("File not found: "+e);
		}catch(IOException e){
			System.out.println("IOException: "+e);
		}
	}
}