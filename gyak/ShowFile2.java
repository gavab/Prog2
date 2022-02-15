import java.io.*;

class ShowFile2{
	public static void main(String[] args) {
		
		int i;
		try{
			if(args.length !=2){
				//System.out.println("Usage: ShowFile inputFilename outputFilename");
				throw new Exception("Usage: ShowFile inputFilename outputFilename");
				//return;
			}
		}catch(Exception e){
			System.out.println(e);
			return;
		}

		try(FileInputStream fin=new FileInputStream(args[0]);
		FileInputStream fout=new FileInputStream(args[1])){

			do{
				i=fin.read();
				if(i!=-1)fout.write(i);
			}while(i!=-1);

			fin.close();

		}catch(FileNotFoundException e){
			System.out.println("File not found: "+e);
		}catch(IOException e){
			System.out.println("IOException: "+e);
		}
	}
}