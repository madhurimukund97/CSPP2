import java.util.Scanner;
/**
 * @author madhuri
 */
class Solution {
/**.
Fill this main function to print maximum of given array

@param      args  The arguments
*/
    public static void main(final String[] args) {

        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        int max = a[0];
        for (int i = 0; i < n; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        System.out.println(max);
    }
}
