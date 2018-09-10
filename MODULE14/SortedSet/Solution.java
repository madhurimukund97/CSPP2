import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
// import java.util.sort;

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
    Set() {
        final int n = 20;
        set = new int[n];
        size = 0;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }

    private void resize() {
        set = Arrays.copyOf(set, size * 2);
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
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
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        int i;
        String str = "{";
        for (i = 0; i < size - 1; i++) {
            str = str + set[i] + ", ";
        }
        return str + set[i] + "}";
    }

    /**
     * { function_description }.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (!contains(item)) {
            for (int i = 0; i < size; i++) {
                if (set[i] > item) {
                    for (int j = size; j > i; j--) {
                        set[j + 1] = set[j];
                    }
                    set[i + 1] = set[i];
                    set[i] = item;

                }
            }
        }
        // else {
        //    size = size - 1;
        // }
    }
    /**
     * Adds all.
     *
     * @param      items  The items.
     */
    public void addAll(final int[] items) {
        
    }
    /**
     * { function_description }
     *
     * @param      toElement  To element
     *
     * @return     { description_of_the_return_value }
     */
    public int[] headSet(final int toElement) {
        return null;
    }

    /**
     * { function_description }.
     *
     * @param      fromElement  The from element
     * @param      toElement    To element
     *
     * @return     { description_of_the_return_value }
     */
    public int[] subSet(final int fromElement, final int toElement) {
        return null;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
    */
    public int last(){
        return 1;
    }
    /**
     * { function_description }.
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final int index) {
        if (index < 0 || index >= this.size()) {
            return -1;
        } else {
            return set[index];
        }
    }
    /**
     * { function_description }.
     *
     * @param      newSet  The new set
     */
    public void add(final int[] newSet) {
        for (int i : newSet) {
                add(i);
        }
    }

    /**
     * { function_description }.
     *
     * @param      set1  The set 1
     *
     * @return     { description_of_the_return_value }
     */
    public Set intersection(final Set set1) {
        Set set3 = new Set();
        for (int i = 0; i < this.size; i++) {
            if (set1.contains(this.get(i))) {
                set3.add(this.get(i));
            }
        }
        return set3;
    }
    /**
     * { function_description }.
     *
     * @param      items  The items
     *
     * @return     { description_of_the_return_value }
     */
    public Set retainAll(final int[] items) {
        Set set3 = new Set();
        // if(set.length  || set3.length == 0){
        //     return "{}";
        // }
        //
        for (int i : items) {
            set3.add(i);
        }
        return intersection(set3);
    }
    /**
     * { function_description }.
     *
     * @param      set3  The set 3
     *
     * @return     { description_of_the_return_value }
     */
    public int[][] cartesianProduct(final Set set3) {
        int[][] result = new int[this.size() * set3.size()][2];
        int k = -1;
        if (this.size() == 0 || set3.size() == 0) {
            return null;
        }
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < set3.size(); j++) {
                result[++k][0] = this.get(i);
                result[k][1] = set3.get(j);
            }
        }
        return result;
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
