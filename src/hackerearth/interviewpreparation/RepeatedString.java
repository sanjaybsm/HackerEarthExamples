package hackerearth.interviewpreparation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {

	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {
		char[] stringToCount;
		long occurance = 0;
		if(s.length() <= 0 && s.equalsIgnoreCase("a")){
			return s.length();
		}else if(s.length() == 1 && s.equalsIgnoreCase("a")){
			return n;
		} else {
			stringToCount = s.toCharArray();
			occurance = getOccurance(stringToCount, occurance, stringToCount.length);
			long quotient = n / stringToCount.length;
			long remainder = n % stringToCount.length;
			occurance = occurance * quotient;
			occurance = getOccurance(stringToCount, occurance, remainder);
			return  occurance;
		}
	}

	private static long getOccurance(char[] stringToCount, long occurance, long length) {
		for (int i = 0; i < length; i++) {
			if (stringToCount[i] == 'a') {
				occurance++;
			}
		}
		return occurance;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		long n = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = repeatedString(s, n);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}

