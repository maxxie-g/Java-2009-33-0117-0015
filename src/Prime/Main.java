package Prime;

import java.io.IOException;

public class Main {

	static String path = "C:/Users/Max G/Documents/Java/competition.txt";
	static String outPutPath = "C:/Users/Max G/Documents/Java/output340.txt";
	
	public static void main(String[] args) {
		try {
			@SuppressWarnings("unused")
			primeTest pT = new primeTest(path, outPutPath);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
