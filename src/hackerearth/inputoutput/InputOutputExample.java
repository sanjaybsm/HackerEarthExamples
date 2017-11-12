package hackerearth.inputoutput;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Sanjay_Shivanna on 11/4/2017.
 */
public class InputOutputExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       ArrayList<String> elements = new ArrayList<>();
        int count = 0;
        do{
            elements.add(scanner.next());
            count++;
        }while(count < 2);
        scanner.close();
        System.out.println((Integer.valueOf(elements.get(0)) * 2));
        String word = elements.get(1);
        if(word.length() < 15){
            System.out.println(word);
        }
    }
}
