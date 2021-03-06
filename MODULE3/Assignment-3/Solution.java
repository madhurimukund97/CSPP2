import java.util.Scanner;
/**
 * @author madhuri
*/
public final class Solution {
    /**
     * @constructor
    */
    private Solution() {
        //I am not using this constructor
    }
    /**
    Do not modify this main function.
    @param      args  The arguments
    */
    private static int gcd = 1;

    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**
         Main function
        */
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        gcd(n1, n2);
    }
    /**.
     * { function_description }
     *
     * @param      n1    The n 1
     * @param      n2    The n 2
     */
    static void gcd(final int n1, final int n2) {
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        System.out.println(gcd);
    }
}

