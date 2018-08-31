
// Given an String, Write a java method that returns the decimal value for the given binary string.
import java.util.Scanner;
public class Solution {
	/**
	 Do not modify the main function 
	*/
	/**
     * @constructor
    */
    static String reverse = "";
    private Solution() {
        //I am not using this constructor
    }
    /**.
    Do not modify this main function.
    @param      args  The arguments
    */
    /**.
     * Fill the main function to print resultant of addition of matrices
     *
     * @param      args  The arguments
     */
	public static void main(String[] args) {
	/**.
     * main
    */
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		reverse = reverseString(s);	
		System.out.println(reverse);	
	}

	/**
	 * { function_description }
	 *
	 * @param      s     { parameter_description }
	 */
	public static String reverseString(final String s) {
		char[] array = s.toCharArray();
        int strlength = array.length;
        for (int i = strlength - 1; i >= 0; i--) {
        	reverse += array[i];
        }
        return reverse;
	}
}

