import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        int result=power(base,exponent);
        System.out.println(result);
	}
	/*
	Need to write the power function and print the output.
	*/
	static int power(int b, int e){
		int res = 1;

        while (e != 0)
        {
            res *= b;
            --e;
        }
        return res;
	}
}
