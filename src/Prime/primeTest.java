package Prime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import useFiles.ReadFile;
import useFiles.WriteFile;

public class primeTest {

	List<Integer> primeInts = new ArrayList<Integer>();
	List<Integer> originalNumber = new ArrayList<Integer>();
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

	public List<Integer> intTest(String outputPath) throws IOException {
		WriteFile wF = new WriteFile(outputPath, false);
		int n = 0;
		
		for (int i = 0; i < originalNumber.size(); i++) {
			n = originalNumber.get(i);
		}

		for (int k = 2; k < (n / 2); k++) { // This is prime testing
			/*
			 * This iterates from 2 to one less than half the number scanned
			 */
			if (n % k == 0) {
				/*
				 * The if statement finds if the remainder of n divided by k
				 * is zero. If it is, then it will set prime to false and
				 * print "n is not prime" where n is the read number. Else,
				 * it prints "n is prime."
				 */
				prime = false;
				wF.writeToFile(n + " is not prime");
				System.out.println(n + " is not prime");
				break;
			} else {
				prime = true;
			}
		}

		if (prime) {
			wF.writeToFile(n + " is prime");
			System.out.println(n + " is prime");
			for (int index = 0; index < originalNumber.size(); index++) {
				primeInts.add(n);
			}
		}
		return primeInts;
	}

	public void reverseNumber(int number) {
		
	}
	
	public primeTest() throws IOException {
		intTest(null);
		original_number(null);
	}
}