import java.util.*;
class InputValidator {
    /*Write the atrributes and methods for InputValidator*/
    String str2;
    public InputValidator(String str1){
        this.str2 = str1;
    }
    public boolean validateData() {
        int strlength = str2.length();
        if(strlength >= 6) {
            return true;
        }
        else{
            return false;
        }
    }
}
public class Solution {
    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        String input=s.next();
        InputValidator i=new InputValidator(input);
        System.out.println(i.validateData());
    }
}
