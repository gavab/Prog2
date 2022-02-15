class CurrentThreadDemo{
	public static void main(String[] args) {
		
		Thread t=Thread.currentThread();

		System.out.println("Current thread: "+t);

		t.setName("My first thread");

		System.out.println("After change: "+t);

		try{
			for(int i=5;i>0;i--){
				System.out.println(i);
				t.sleep(1000);
			}
		}catch(InterruptedException e){
			System.out.println("Main thread interrupted");
		}
	}
}