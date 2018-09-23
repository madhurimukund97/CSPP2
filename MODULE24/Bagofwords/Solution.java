import java.io.File;
import java.util.Scanner;

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
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        try {
        Bagofwords f = new Bagofwords();
        Scanner sc = new Scanner(System.in);
        // String line = sc.next();
        File input = new File(sc.next());
        File[] listoffiles = input.listFiles();
        // for (File name:listoffiles) {
        //  System.out.println(name);
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
                res[i][j] = Bagofwords.similarity(
                    Bagofwords.toString(
                    listoffiles[i]),
                Bagofwords.toString(listoffiles[j]));
                if (maximum < res[i][j]) {
                    maximum = res[i][j];
                res1 = "Maximum similarity is in between "
                    + listoffiles[i].getName()
                    + " and " + listoffiles[j].getName();

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