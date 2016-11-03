import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by emilybutte on 11/3/16.
 */
public class Main {
    String[] numNames = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    String[] tensNames = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    String[] largeNumNames = {"", "thousand",  "million", "billion", "trillion", "quadrillion", "quintillion"};


    public String convertLessThanOneThousand(int number) {
        String current;
        if (number % 100 < 20) {
            current = numNames[number % 100];
            number /= 100;
        } else {
            current = numNames[number % 10];
            number /= 10;

            current = tensNames[number % 10] + current;
            number /= 10;
        }

        if (number == 0) return current;
        return numNames[number] + "hundred" + current;
    }

    public String convert(int number){

        if (number == 0) { return "zero"; }

        String prefix = "";

        if (number < 0) {
            number = -number;
            prefix = "negative";
        }

        String current = "";
        int place = 0;

        do {
            int n = number % 1000;
            if (n != 0){
                String s = convertLessThanOneThousand(number);
                current = s + largeNumNames[place] + current;
            }
            place++;
            number /= 1000;
        } while (number > 0);

        return (prefix + current).trim();
    }

    private static String capitalize(String answer) {
        return Character.toUpperCase(answer.charAt(0)) + answer.substring(1);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int number;
        String s;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number.");

        while ((s = in.readLine()) != null) {
            number = Integer.parseInt(s);
            System.out.println(capitalize(main.convert(number)) + "Dollars");
        }
    }
}


