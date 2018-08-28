import java.util.Scanner;
import java.lang.Math;
/**
 * @author madhuri
*/
public final class Solution {
    /**
     * @constructor
    */
    private Solution(){
        //I am not using this constructor
    }
    /**
    Do not modify this main function.
    
    @param      args  The arguments
    */
    public static void main(final String[] args) {
        /**
         Main function
        */
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadraticEquation(a, b, c);
    }
    /**
    Need to write the rootsOfQuadraticEquation function and print the output.
    @param      a     { parameter_description }
    @param      b     { parameter_description }
    @param      c     { parameter_description }
    */
    static void rootsOfQuadraticEquation(final int a, final int b, final int c) {
        double root1;
        double root2;
        double var1 = (b * b) - (4 * a * c);
        root1 = ((-b) + Math.sqrt(var1)) / (2 * a);
        root2 = ((-b) - Math.sqrt(var1)) / (2 * a);
        System.out.println(root1 + " " + root2);
        // System.out.println(root2);
    }
}
