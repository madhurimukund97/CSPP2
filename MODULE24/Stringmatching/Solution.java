import java.util.*;
import java.io.*;

/**
 * Class for stringmatch.
 */
class Stringmatch {
	/**
	 * Constructs the object.
	 */

	Stringmatch() {
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @param      filename  The filename
	 *
	 * @return     String representation of the object.
	 */
	public static String toString(File filename) {
		String str = "";
		try {
			Scanner input = new Scanner(new FileReader(filename));
			StringBuilder sb = new StringBuilder();
			while(input.hasNext()) {
				sb.append(input.next());
				sb.append(" ");
			}
			input.close();
			str = sb.toString();
		} catch (FileNotFoundException e) {
			System.out.println("no file");
		}
		return str;
	}
	/**
	 * Removes all.
	 *
	 * @param      text  The text
	 *
	 * @return     { description_of_the_return_value }.
	 */
	public static Map removeAll(String text) {
		String[] word1 = text.replaceAll("[^a-zA-Z. ]","").toLowerCase().split(" ");

		//System.out.println(Arrays.toString(wordList1));
		//return Arrays.toString(wordList1);
		Map<String, Integer> map = new HashMap<>();
		int f = 0;
		for (int i = 0; i < word1.length; i++) {
			if (!map.containsKey(word1[i])) {
				map.put(word1[i], 1);
			} else {
				map.put(word1[i], map.get(word1[i]) + 1);
			}
		}
		//System.out.println(map);
		return map;
	}
	/**
	 * { function_description }.
	 *
	 * @param      s1    The s 1
	 * @param      s2    The s 2
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static double similarString(String s1, String s2) {
		int rows = s1.length();
		int columns = s2.length();
		double strLength = rows + columns;
		int[][] max = new int[rows+1][columns+1];
		int res = 0;
		double sim = 0;
		for (int i = 0; i <= rows; i++) {
			for (int j = 0; j <= columns; j++) {
				if (i == 0 || j == 0) {
					max[i][j] = 0;
				} else if (s1.charAt(i-1) == s2.charAt(j-1)) {
					max[i][j] = max[i-1][j-1]+1;
					//result = max(result, maximum[i][j]);
				} else {
					max[i][j] = 0;
				}
				if (res < max[i][j]) {
					res = max[i][j];
				}
			}
		}
		//System.out.println(result);
		sim = Math.round(((res*2)/strLength)*100D)/100D;
		//System.out.println(stringLength);
		return (sim*100);
		}
}
/**
 * Class for solution.
 */

class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		// default constructor.
	}
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {

		try {
		Stringmatch f = new Stringmatch();
		Scanner sc = new Scanner(System.in);
		// String line = sc.next();
		File inp = new File(sc.next());
		File[] listoffiles = inp.listFiles();
		// for (File name:listoffiles) {
		// 	System.out.println(name);
		// }
		double max = 0;
		String res1 = "";
		int length = listoffiles.length;
		double[][] res = new double[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i == j) {
					res[i][j] = 100;
				} else {
				res[i][j] = Stringmatch.similarString(Stringmatch.toString(listoffiles[i]),
					Stringmatch.toString(listoffiles[j]));
				if (max < res[i][j]) {
					max = res[i][j];
					res1 = "Maximum similarity is in between "
					+ listoffiles[i].getName() + " and " + listoffiles[j].getName();
				}
			}
			}
		}
		System.out.print("\t");
		for (int i = 0; i < length; i++) {
			System.out.print("\t" + listoffiles[i].getName());
		}
		System.out.println();
		for (int i = 0; i < length; i++) {
			System.out.print(listoffiles[i].getName() + "\t");
			for (int j = 0; j < length; j++) {
				System.out.print(res[i][j] + "\t\t");
			}
			System.out.println();
		}
		System.out.println(res1);


	} catch (NoSuchElementException e) {
		System.out.println("Empty Directory");
	}

		// String stext1 = sc.nextLine().toLowerCase();
		// String stext2 = sc.nextLine().toLowerCase();
		// Stringmatch feq = new Stringmatch();
	}
}