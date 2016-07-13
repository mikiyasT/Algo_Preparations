package ThreadExample;

public class ThreadClassTest {
		public static void main(String args[]){
			Thread thread = new Thread(new MyThread());
			thread.start();
			for(int j=0; j<=10;j++){
				System.out.println("Main thread");
				
				try {
					
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
} 


