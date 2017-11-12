package hackerearth.basicimpl;

import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collector;

/**
 * Created by Sanjay_Shivanna on 11/4/2017.
 */
public class CountDigit {

    public static void main(String[] args) {
        /*https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/tutorial/*/
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        char[] charValues = value.toCharArray();

        HashMap<Integer,Integer> countDigit = new HashMap<>();

        for (int i = 0; i < 10 ; i++) {
            countDigit.put(i,0);
        }


        for (int i = 0; i <charValues.length ; i++) {
            Integer intvalue = Character.getNumericValue(charValues[i]);
            if(countDigit.containsKey(intvalue)){
                int existingValue = countDigit.get(intvalue);
                countDigit.put(intvalue,existingValue+1);
            }
        }

        countDigit.forEach((k,v)-> System.out.println(+k+" "+v));

        scanner.close();

    }
}
