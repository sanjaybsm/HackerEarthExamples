package geeksofgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;



class Result {

	/*
	 * Complete the 'processLogs' function below.
	 *
	 * The function is expected to return a STRING_ARRAY.
	 * The function accepts following parameters:
	 *  1. STRING_ARRAY logs
	 *  2. INTEGER threshold
	 */

	public static List<String> processLogs(List<String> logs, int threshold) {
		HashMap<String,Integer> finalMap = new HashMap<>();
		for(int i=0;i<logs.size();i++){
			String values = logs.get(i);
			String[] splittedNumbers = values.split(" ");
			String value = null;
			for (int j = 0; j < splittedNumbers.length; j++) {
				 if(!(value != null && value.equalsIgnoreCase(splittedNumbers[j]))) {
					String element = splittedNumbers[j];
					if(finalMap.containsKey(splittedNumbers[j])){
						int repeatedCount = finalMap.get(element);
						finalMap.replace(splittedNumbers[j],++repeatedCount);
					}else{
						finalMap.put(splittedNumbers[j],1);
					}
				}
				value = splittedNumbers[j];
			}
		}
		List<String> resultList = new ArrayList<>();

		for (Map.Entry<String, Integer> entry : finalMap.entrySet()) {
			if (entry.getValue() >= threshold) {
				resultList.add(entry.getKey());
			}
		}
		System.out.println(resultList);
		return resultList;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int logsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> logs = IntStream.range(0, logsCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		})
				.collect(toList());

		int threshold = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> result = Result.processLogs(logs, threshold);

		/*bufferedWriter.write(
				result.stream()
						.collect(joining("\n"))
						+ "\n"
		);*/

		bufferedReader.close();
		//bufferedWriter.close();
	}
}
