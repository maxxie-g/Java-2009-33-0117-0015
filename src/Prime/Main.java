package Prime;

import java.io.IOException;

public class Main {

	static String path = "./competition.txt";
	static String outPutPath = "./output340.txt";

	public static void main(String[] args) throws IOException {
		primeTest pT = new primeTest();
		pT.original_number(path);
		pT.intTest(outPutPath);
	}
}
