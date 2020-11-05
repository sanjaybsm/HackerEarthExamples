package hackerearth.algorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class MigratoryBirds {

	// Complete the migratoryBirds function below.
	static int migratoryBirds(List<Integer> arr) {

		HashMap<Integer,Integer> migrationBirdsCount = new HashMap<>();

		for (int i = 0; i < arr.size(); i++) {
				Integer value = arr.get(i);
				if(migrationBirdsCount.containsKey(value)){
					int insertedValue = migrationBirdsCount.get(value);
					insertedValue++;
					migrationBirdsCount.put(value,insertedValue);
				} else{
					migrationBirdsCount.put(value,1);
				}
		}

		System.out.println(migrationBirdsCount);
		int keyWithHighestValue = 0;
		int value = -1;
		for (Map.Entry<Integer, Integer> entry : migrationBirdsCount.entrySet()) {
			if (value < 0 ){
					value = entry.getValue();
					keyWithHighestValue = entry.getKey();
				} else {
					if(entry.getValue() > value){
						value = entry.getValue();
						keyWithHighestValue = entry.getKey();
					} else if (entry.getValue() == value && entry.getKey() < keyWithHighestValue){
						value = entry.getValue();
						keyWithHighestValue = entry.getKey();
					}
				}
			System.out.println("Key = " + keyWithHighestValue + ", Value = " + value);
		}
		return keyWithHighestValue;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		int result = migratoryBirds(arr);

		//bufferedWriter.write(String.valueOf(result));
		/*bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();*/
	}
}
