package Prime;

import java.io.IOException;

import useFiles.WriteFile;

public class Main {

	static String path = "C:/Users/Max G/Documents/Java/competition.txt";
	
	public static void main(String[] args) {
		try {
			primeTest pT = new primeTest(path);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
