// Given an String, Write a java method that returns the
// decimal value for the given binary string.
import java.util.Scanner;
/**
 * @author madhuri.
 */
public final class Solution {
	/**
	Do not modify this main function.
	*/
	private Solution(){
		//constructor not used
	}

	/**
	 * { function_description }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < n; i++) {
			String s = sc.nextLine();
			String res = binaryToDecimal(s);
			System.out.println(res);
		}	
	}
	/**
	 * { function_description }.
	 *
	 * @param      s     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static String binaryToDecimal(final String s) {
		double res = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int number = Character.getNumericValue(c);
			res = res + (number * Math.pow(2, (s.length() - 1) - i));
		}
		int result1 = (int) res;
		String res2 = Integer.toString(result1);
		return res2;
	}
}
