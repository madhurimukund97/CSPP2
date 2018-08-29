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
    public static void main(final String[] args) {
    /**
     Main function
    */
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i = 0, j = 1;
        int count = 0;
        final int a = 10;
        final int b = 7;
        for (i = 1; i <= n; i++) {
            j = i;
            while (j != 0) {
                if (j % a == b) {
                    count++;
                }
                j /= a;
            }
        }
        System.out.println(count);
    }
}


