package SingletonPackage;

public class Singleton {
	
	private static Singleton INSTANCE;
	
	private Singleton(){
		System.out.println("Instance created");
	}
	
	public static Singleton getInstance(){
		
		if(INSTANCE == null){
			
			INSTANCE = new Singleton();
			return INSTANCE;
			
		}else{
			
			System.out.println("Already created");
			return INSTANCE;
		}
	}
	public void updateStudetnRecord(){};
	public void updateDeptREc(){}

}
