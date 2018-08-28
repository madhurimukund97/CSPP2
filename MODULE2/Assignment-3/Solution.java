import java.util.Scanner;
/**
 * @author     madhuri
 */
public final class Solution {
    private Solution() {
        //I am not using this constructor
    }
    /**
    Do not modify this main function.
    @param      args  The arguments
    */
    public static void main(final String[] args) {
        /**
         Main function
        */
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
    Need to write the power function and print the output.
    @param      b     { parameter_description }
    @param      e     { parameter_description }
    @return     { description_of_the_return_value }
    */
    static long power(final int b, final int e) {
        /**
         Long Power
        */
        if (e > 0) {
            return b * power(b, e - 1);
        }
        return 1;
    }
}
