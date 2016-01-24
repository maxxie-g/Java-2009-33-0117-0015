package Prime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import useFiles.ReadFile;
import useFiles.WriteFile;

public class primeTest {

	List<Integer> primeInts = new ArrayList<Integer>();
	List<Integer> originalNumber = new ArrayList<Integer>();
	List<Integer> reverseNumber = new ArrayList<Integer>();
	boolean prime = true;

	/*
	 * pseudocode: testNumber(originalNumber); newNumber =
	 * reverseNumber(originalNumber); restNumber(newNumber); testNumber: all of
	 * the logic for prime testing orginalNumber: the number read from the file
	 * reverseNumber: reverses numbers newNumber: the reverse of originalNumber
	 */

	public List<Integer> original_number(String inputPath) throws IOException {
		ReadFile file = new ReadFile(inputPath);
		String[] textFile = file.OpenFile();
		int j = textFile.length;

		for (int i = 0; i < j; i++) {
			originalNumber.add(Integer.parseInt(textFile[i]));
		}

		return originalNumber;
	}

	public List<Integer> intTest(String outputPath, List<Integer> testInts, boolean emirp) throws IOException {
		/*
		 * outputPath: path specified for WriteFile class
		 * testInts: List specified for testing
		 * emirp: True: will print "n is an emirp."
		 * 		  False: will print "n is prime."
		 */
		WriteFile wF = new WriteFile(outputPath, true);
		int n = 0;

		for (int i = 0; i < testInts.size(); i++) {
			n = testInts.get(i);
			if (n == 0) {
				break;
			} else {
				for (int k = 2; k < (n / 2); k++) { // This is prime testing
					/*
					 * This iterates from 2 to one less than half the number
					 * scanned
					 */
					if (n % k == 0) {
						/*
						 * The 'if' statement finds if the remainder of n divided
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
			}
			if (prime) {
				/*
				 * This is the code for prime handling
				 */
				if (emirp) {
					/*
					 * This is where the emirp boolean is used
					 * If it is set to true, than it will write "n is an emirp."
					 */
					wF.writeToFile(n + " is an emirp");
					System.out.println(n + " is an emirp");
				} else {
					/*
					 * If emirp isn't true, than it will be prime and print
					 * "n is prime."
					 */
					wF.writeToFile(n + " is prime");
					System.out.println(n + " is prime");
					primeInts.add(n);
				}
			}
		}
		return primeInts;
	}

	public List<Integer> reverseNumber() throws IOException {
		int reverse = 0, q;

		for (int i = 0; i < primeInts.size(); i++) {
			q = primeInts.get(i);
			reverse = 0;
			while (q != 0) {
				reverse = reverse * 10;
				reverse = reverse + q % 10;
				q = q / 10;
			}
			reverseNumber.add(reverse);
		}
		System.out.println("Reversed numbers:");
		
		return reverseNumber;
	}
}