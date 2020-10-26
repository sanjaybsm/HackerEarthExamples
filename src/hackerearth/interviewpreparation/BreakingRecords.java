package hackerearth.interviewpreparation;

import java.io.IOException;
import java.util.Scanner;

public class BreakingRecords {


	// Complete the breakingRecords function below.
	static int[] breakingRecords(int[] scores) {
		int highest = 0;
		int lowest = 0;
		int countHighest = 0;
		int countLowest = 0;
		for (int i = 0; i < scores.length; i++) {
			int temp = scores[i];
			if(i == 0){
				highest = temp;
				lowest = temp;
				continue;
			}
			//logic for checking highest number
			if(temp >= highest ){
				//increase the count of countHighest
				if(temp > highest){
					highest = temp;
					countHighest++;
				}
				continue;
			}
			//
			//logic for checking highest number
			if(temp <= lowest){
				//increase the count of countHighest
				if(temp < lowest){
					lowest = temp;
					countLowest++;
				}
			}


		}

		int[] result  = {countHighest, countLowest};

		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
	//	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\sanja\\Documents\\sanjay\\learning\\hackerrank"));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] scores = new int[n];

		String[] scoresItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int scoresItem = Integer.parseInt(scoresItems[i]);
			scores[i] = scoresItem;
		}

		int[] result = breakingRecords(scores);

//		for (int i = 0; i < result.length; i++) {
//			bufferedWriter.write(String.valueOf(result[i]));
//
//			if (i != result.length - 1) {
//				bufferedWriter.write(" ");
//			}
//		}
//
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();

		scanner.close();
	}
}
