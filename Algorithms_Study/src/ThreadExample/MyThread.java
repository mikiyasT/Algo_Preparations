package ThreadExample;

public class MyThread implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 10 ; i++){
			System.out.println("In thread");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}


