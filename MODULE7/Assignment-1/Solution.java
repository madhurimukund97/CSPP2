import java.util.Scanner;
/**
 * @author     madhuri
 *
 * Class for input validator.
 */
class InputValidator {
    /*Write the atrributes and methods for InputValidator*/
    /**
     * { var_description }.
     */
    private String str2;
    /**
     * Constructs the object.
     *
     * @param      str1  The string 1
     */
    protected InputValidator(final String str1) {
    /**
     * { input validator }.
     */
        this.str2 = str1;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean validateData() {
    /**
     * { validate data }
     */
        final int var = 6;
        int strlength = str2.length();
        if (strlength >= var) {
            return true;
        }
        return false;
    }
}
/**
 * { item_description }.
 */
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
