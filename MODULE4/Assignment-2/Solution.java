import java.util.Scanner;
/**
 * @author "madhuri"
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
	public static void main(String[] args) {
		int m, n, c, d;
      	Scanner in = new Scanner(System.in);
 
      	m = in.nextInt();
 
      	int array1[][] = new int[m][m];
      	int array2[][] = new int[m][m];
      	int sum[][] = new int[m][m];
 
      	for (  c = 0 ; c < m ; c++ )
         	for ( d = 0 ; d < m ; d++ )
            	array1[c][d] = in.nextInt();
 
      	for ( c = 0 ; c < m ; c++ )
         	for ( d = 0 ; d < m ; d++ )
            	array2[c][d] = in.nextInt();
 
      	for ( c = 0 ; c < m ; c++ )
         	for ( d = 0 ; d < m ; d++ )
             	sum[c][d] = array1[c][d] + array2[c][d]; 
 
      	for ( c = 0 ; c < m ; c++ )
      	{
         	for ( d = 0 ; d < m ; d++ )
            	System.out.print(sum[c][d]+"\t");
 
        System.out.println();
      }
   }
}


