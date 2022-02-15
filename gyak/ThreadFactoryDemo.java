class NewThread implements Runnable{

	Thread t1;

	NewThread(){
		t1=new Thread(this,"Demo thread");
		System.out.println("Child thread"+t1);
	}

	public static NewThread createAndstart(){
		
		NewThread myNewThr=new NewThread();
		myNewThr.t1.start();
		return myNewThr;

	}

	public void run(){
		try{
			for(int i=5;i>0;i--){
				System.out.println(i);
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			System.out.println("Child thread interrupted");
		}
		System.out.println("Child thread exiting");
	}
}

class ThreadFactoryDemo{
	public static void main(String[] args) {
		
		NewThread nt=NewThread.createAndstart();
		NewThread nt1=NewThread.createAndstart();

		try{
			for(int i=5;i>0;i--){
				System.out.println(i);
				Thread.sleep(500);
			}
		}catch(InterruptedException e){
			System.out.println("Main thread interrupted");
		}
		System.out.println("Main thread exiting");
	}
}