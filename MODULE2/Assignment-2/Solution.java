
import java.util.Scanner;
import java.lang.Math;

public final class Solution {
    /**
    Do not modify this main function.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadraticEquation(a, b, c);  
    }
    /**
    Need to write the rootsOfQuadraticEquation function and print the output.
    */
    static void rootsOfQuadraticEquation(final int a, final int b, final int c) {
        double root1;
        double root2;
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(c);
        // System.out.println((Math.sqrt((b*b)-4*a*c)));
        double var1 = (b * b) - (4 * a * c);
        root1 = ((-b) + Math.sqrt(var1)) / (2 * a);
        root2 = ((-b) - Math.sqrt(var1)) / (2 * a);
        System.out.println(root1 + " " + root2);
        // System.out.println(root2);
    }
}
