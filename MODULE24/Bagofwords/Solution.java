import java.util.Scanner;
// import java.lang.StringBuilder;
import java.util.HashMap;
import java.util.Map;
// import java.util.Scanner;
// import java.lang.Math;

import java.io.FileReader;
import java.io.File;

/**
 * Class for bagofwords.
 */
class Bagofwords {
	/**
	 * Constructs the object.
	 */
	Bagofwords() {
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
		} catch (Exception e) {
			System.out.println("no file");
		}
		return str;
	}
	/**
	 * Removes all.
	 *
	 * @param      text  The text
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static Map removeAll(String text) {
		String[] wList = text.replaceAll("[^a-zA-Z. ]","").toLowerCase().split(" ");

		//System.out.println(Arrays.toString(wordList1));
		//return Arrays.toString(wordList1);
		Map<String, Integer> map = new HashMap<>();
		int freq = 0;
		for (int i = 0; i < wList.length; i++) {
			if (!map.containsKey(wList[i])) {
				map.put(wList[i], 1);
			} else {
				map.put(wList[i], map.get(wList[i]) + 1);
			}
		}
		//System.out.println(map);
		return map;

	}
	/**
	 * { function_description }.
	 *
	 * @param      doc1  The document 1
	 * @param      doc2  The document 2
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static int similarity(final String doc1, final String doc2) {
		//System.out.println("hello");
		final int hun1 = 100;
        final double hun2 = 100D;
		double numer = 0;
		double s1 = 0;
		double s2 = 0;
		Map<String, Integer> mapOne = removeAll(doc1);
		Map<String, Integer> mapTwo = removeAll(doc2);
		for (String element1:mapOne.keySet()) {
			for (String element2:mapTwo.keySet()) {
				if (element1.equals(element2)){
					numer += mapOne.get(element1)*mapTwo.get(element2);
				}
			}
		}
		for (String element1:mapOne.keySet()) {
			s1 += Math.pow(mapOne.get(element1), 2);
		}
		for (String element2:mapTwo.keySet()) {
			s2 += Math.pow(mapTwo.get(element2), 2);
		}
		double denominator = Math.sqrt(s1) * Math.sqrt(s2);
		// System.out.println(s1);
		// System.out.println(s2);
		// System.out.println(numer);
		// System.out.println(denominator);
		return (int)((((numer / denominator) * hun2) / hun2) * hun1);


	}
}
/**
 * { item_description }.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//constructor not used.
	}
	public static void main(final String[] args) {
		try {
		Bagofwords f = new Bagofwords();
		Scanner sc = new Scanner(System.in);
		// String line = sc.next();
		File input = new File(sc.next());
		File[] listoffiles = input.listFiles();
		// for (File name:listoffiles) {
		// 	System.out.println(name);
		// }
		final int hun = 100;
		int maximum = 0;
		String res1 = "";
		int length = listoffiles.length;
		int[][] res = new int[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i == j) {
					res[i][j] = hun;
				} else {
				res[i][j] = Bagofwords.similarity(Bagofwords.toString(
					listoffiles[i]), Bagofwords.toString(listoffiles[j]));
				if (maximum < res[i][j]) {
					maximum = res[i][j];
					res1 = "Maximum similarity is in between " +
					listoffiles[i].getName() + " and " + listoffiles[j].getName();

				}
			}
			}
		}
		System.out.print("      \t");
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


	} catch (Exception e) {
		System.out.println("empty directory");
	}

		// String stext1 = sc.nextLine().toLowerCase();
		// String stext2 = sc.nextLine().toLowerCase();
		// Bagofwords feq = new Bagofwords();



	}
}