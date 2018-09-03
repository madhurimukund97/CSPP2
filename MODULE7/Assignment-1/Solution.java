import java.util.*;
class InputValidator {
    /*Write the atrributes and methods for InputValidator*/
    String str2;
    static int six = 6;
    public InputValidator (String str1) {
        this.str2 = str1;
    }
    public boolean validateData() {
        int strlength = str2.length();
        if (strlength >= six) {
            return true;
        } else {
            return false;
        }
    }
}
public final class Solution {
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}
