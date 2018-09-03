import java.util.Scanner;
/**
 * @author     madhuri
 *
 * Class for input validator.
 */
class InputValidator {
    /*Write the atrributes and methods for InputValidator*/
    /**
     * { var_description }
     */
    private String str2;
    final int var = 6;
    public InputValidator(final String str1) {
        this.str2 = str1;
    }
    public boolean validateData() {
        int strlength = str2.length();
        if (strlength >= var) {
            return true;
        } else {
            return false;
        }
    }
}
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
    public static void main(final String[] args) {
    /**
     * main _ function
    */
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}
