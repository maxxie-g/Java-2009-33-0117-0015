package Prime;

import java.io.IOException;

public class Main {

	static String path = "./competition.txt";
	static String outPutPath = "./output340.txt";

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			primeTest pT = new primeTest(path, outPutPath);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
