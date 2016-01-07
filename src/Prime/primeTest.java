package Prime;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import useFiles.ReadFile;
import useFiles.WriteFile;

public class primeTest {

	List<Integer> primeInts = new ArrayList<Integer>();
	boolean prime = true;

	/*
	 * pseudocode:
	 * 		testNumber(originalNumber);
	 * 		newNumber = reverseNumber(originalNumber);
	 * 		restNumber(newNumber);
	 * testNumber: all of the logic for prime testing
	 * orginalNumber: the number read from the file
	 * reverseNumber: reverses numbers
	 * newNumber: the reverse of originalNumber
	 */

	public primeTest(String inputPath, String outPutPath) throws IOException {
		try {

			Scanner	s = new Scanner(new BufferedReader(new FileReader(inputPath)));
			WriteFile wF = new WriteFile(outPutPath, false);
			ReadFile file = new ReadFile(inputPath);
			String[] textFile = file.OpenFile();
			int j = textFile.length;

			for (int i = 0; i < j; i++) {
				// This iterates for the length of the file
				prime = true;
				int n = s.nextInt();

				if (n == 0) {
					// If n is 0, the program terminates
					break;
				} else {
					for (int k = 2; k < (n / 2); k++) { // This is prime testing
						/*
						 * This iterates from 2 to one less than half the number
						 * scanned
						 */
						if (n % k == 0) {
							/*
							 * The if statement finds if the remainder of n
							 * divided by k is zero. If it is, then it will set
							 * prime to false and print "n is not prime" where n
							 * is the read number. Else, it prints "n is prime."
							 */
							prime = false;
							wF.writeToFile(n + " is not prime");
							System.out.println(n + " is not prime");
							break;
						} else {
							prime = true;
						}
					}
				}
				if (prime) {
					wF.writeToFile(n + " is prime");
					System.out.println(n + " is prime");
					for (int index = 0; index < j; index++) {
						primeInts.add(n);
					}
				}
			}
			s.close();
		} catch (IOException e) {
			System.out.println("Here's what went wrong, bud: " + e.getMessage());
		}
	}
}
