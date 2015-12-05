package Prime;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import useFiles.ReadFile;
import useFiles.WriteFile;

public class primeTest {

	/* TODO Emirp testing */
	Scanner s = null;

	public primeTest(String path, String outPutPath) throws IOException {
		try {

			WriteFile wF = new WriteFile(outPutPath, true);
			s = new Scanner(new BufferedReader(new FileReader(path)));
			boolean prime = true;
			ReadFile file = new ReadFile(path);
			String[] textFile = file.OpenFile();
			int j = textFile.length;

			for (int i = 0; i < j; i++) {
				// This iterates for the length of the file
				prime = true;
				int n = s.nextInt();

				if (n == 0) {
					break;
				}
				for (int k = 2; k < n - 1; k++) { // This is prime testing
					/*
					 * This iterates from 2 to one less than the number scanned
					 * It also sets k to an int to be used later for modulus
					 */
					if (n % k == 0) {
						/*
						 * The if statement finds if the remainder of n divided
						 * by k is zero. If it is, then it will set prime to
						 * false and print "n is not prime" where n is the read
						 * number. Else, it prints "n is prime."
						 */
						prime = false;
						wF.writeToFile(n + " is not prime");
						System.out.println(n + " is not prime");
						break;
					} else {
						prime = true;
					}
				}
				if (prime == true) { // This is emirp testing
					for (int l = j; l >= 2; l--) {
						if (n % l == 0) {
							String stringEmirp = n + " is an emirp";
							System.out.println(stringEmirp);
							wF.writeToFile(stringEmirp);
							break;
						} else {
							String stringPrime = n + " is prime";
							System.out.println(stringPrime);
							wF.writeToFile(stringPrime);
						}
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Here's what went wrong, bud: " + e.getMessage());
		}
	}
}
