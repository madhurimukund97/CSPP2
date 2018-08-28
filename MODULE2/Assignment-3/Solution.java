/*
   Power class
*/
import java.util.Scanner;

public class Solution {
    /*
    Do not modify this main function.
    */
    public static void main(String[] args) {
        /*
          Main function
        */
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /*
    Need to write the power function and print the output.
    */
    static long power(int b, int e) {
        /*
          Long Power
        */
        if (e > 0) {
            return b * power(b, e - 1);
        }
        return 1;
    }
}
