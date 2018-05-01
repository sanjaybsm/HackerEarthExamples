package hackerearth.codemonk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class codemonk_coderland {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> elements = new ArrayList<>();
        int count = 0;
        do{
            String line = scanner.nextLine();
            List<String> testcases =  Arrays.asList(line.split(" "));
            testcases.forEach(i -> System.out.println("values" + i));
            count++;
        }while(count < 4);
        scanner.close();
    }


}
