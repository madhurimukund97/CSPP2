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
    /* Fill the main function to print resultant of addition of matrices*/
    public static void main(final String[] args) {
        int m, n, o, p;
        int[][] array1, array2, sum;
        Scanner s = new Scanner(System.in);
        m = s.nextInt();
        n = s.nextInt();
        array1 = new int[m][n];
        for (int c = 0; c < m; c++) {
            for (int d = 0; d < n; d++) {
                array1[c][d] = s.nextInt();
            }
        }
        o = s.nextInt();
        p = s.nextInt();
        array2 = new int[o][p];
        for (int c = 0; c < o; c++) {
            for (int d = 0; d < p; d++) {
                array2[c][d] = s.nextInt();
            }
        }
        sum = new int[m][n];
        if (m == o && n == p) {
            for (int c = 0; c < o; c++) {
                for (int d = 0; d < p; d++) {
                    sum[c][d] = array1[c][d] + array2[c][d];
                }
            }
            for (int c = 0; c < o; c++) {
                for (int d = 0; d < p; d++) {
                    if (d != n - 1) {
                        System.out.print(sum[c][d] + " "); }
                    else {
                    	System.out.print(sum[c][d]); }
                } System.out.println();
            }
        }
        else {
        	System.out.println("not possible");
        }
    }
}
