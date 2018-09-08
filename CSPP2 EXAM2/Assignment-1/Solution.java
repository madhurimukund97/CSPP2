import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author :
 */
class Set {
    //your code goes here...
    //Good luck :-)
    /**
    * set.
    */
    private int[] set;
    /**
     * size.
     */
    private int size;
    /**
     * Constructs the object.
     */
    public Set(){
        set = new int[10];
        size = 0;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**
     * { function_description }
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int item) {
        for (int i = 0; i < size - 1; i++) {
            if (set[i] == item) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString(){
        if (size == 0) {
            return "{}";
        }
        int i;
        String str = "{";
        for (i = 0; i < size - 1; i++) {
            str = str + set[i] + ",";
        }
        return str + set[i] + "}";
    }

    /**
     * { function_description }
     *
     * @param      item  The item
     */
    public void add(int item) {
        if(!contains(item)) {
            set[size++] = item;
        }
    }

    /**
     * { function_description }
     *
     * @param      newSet  The new set
     */
    public void add(int[] newSet) {
        for (int i : newSet) {
                add(i);
        }
    }

    /**
     * { function_description }
     *
     * @param      set1  The set 1
     *
     * @return     { description_of_the_return_value }
     */
    public Set intersection(Set set1) {
        // Set set3 = new Set();
        // for (int i = 0; i < set1.length; i++) {
        //     if (i == set[i]) {
        //         set1.add(i);
        //     }
        // }
        return null;
    }
    /**
     * { function_description }
     *
     * @param      items  The items
     *
     * @return     { description_of_the_return_value }
     */
    public Set retainAll(int[] items) {
        // int res = 0;
        // int i;
        // int[] retainSet = new int[items.length];
        // for (i = 0; i < size - 1; i++) {
        //     if(set[i] == items[res]) {
        //         retainSet[i] = items[res];
        //     }
        // }
        // return retainSet;
        
        return null;
    }

    /**
     * { function_description }
     *
     * @param      set3  The set 3
     *
     * @return     { description_of_the_return_value }
     */
    public int[][] cartesianProduct(Set set3) {
        return null;
    }
}

/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}
