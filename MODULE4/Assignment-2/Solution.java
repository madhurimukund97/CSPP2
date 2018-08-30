import java.util.*;
public class Solution {
	/* Fill the main function to print resultant of addition of matrices*/
	public static void main(String[] args) {
    int m, n;
    Scanner s = new Scanner(System.in);
    m = s.nextInt();
    n = s.nextInt();
 
    int array1[][] = new int[m][n];
    int array2[][] = new int[m][n];
    int sum[][] = new int[m][n];
 
 
    for (int c = 0 ; c < m ; c++) {
        for (int d = 0 ; d < n ; d++) {
            array1[c][d] = s.nextInt();
        }
    }
    for (int c = 0 ; c < m ; c++) {
        for (int d = 0 ; d < n ; d++) {
            array2[c][d] = s.nextInt();
        }
    }
 
    for (int c = 0 ; c < m ; c++) {
        for (int d = 0 ; d < n ; d++) {
            sum[c][d] = array1[c][d] + array2[c][d]; 
        }
    }
 
    for (int c = 0 ; c < m ; c++) {
        for (int d = 0 ; d < n ; d++) {
            System.out.print(sum[c][d]);
        }
        System.out.println();
    }
    }
}