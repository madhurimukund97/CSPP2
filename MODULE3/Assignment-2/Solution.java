import java.util.Scanner;
/*
 Do not modify this main function.
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
/*
 * Fill the main function to print the number of 7's between 1 to n
 *
 * @param      args  The arguments
 */
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
    	int i = 0, j = 1;
    	int count = 0;
    	for (i = 1; i <= n; i++) {
        	j = i;
        	while (j != 0) {
            	if (j % ((2 * 2 + 1) * 2) == ((2 + 1) * 2 + 1)) {
                	count++;
            	}
            	j /= ((2 * 2 + 1) * 2);
        	}
    	}
    	System.out.println(count);
	}
}
