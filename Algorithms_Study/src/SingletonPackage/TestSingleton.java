package SingletonPackage;

public class TestSingleton {
	public static void main(String args[]){
		Singleton mySingleton = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
	}
}
