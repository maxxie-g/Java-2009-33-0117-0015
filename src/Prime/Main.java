package Prime;

import java.io.IOException;
import java.util.List;

public class Main {

	static String path = "./competition.txt";
	static String outPutPath = "./output340.txt";

	public static void main(String[] args) throws IOException {
		primeTest pT = new primeTest();
		List<Integer> originalNumber = pT.original_number(path);

		pT.intTest(outPutPath, originalNumber, false);
		List<Integer> reverseNumber = pT.reverseNumber();
		pT.intTest(outPutPath, reverseNumber, true);
	}
}
