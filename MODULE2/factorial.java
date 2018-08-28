import java.util.Scanner;
public class factorial{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		if (num >=0);
		System.out.println(fact(num));

	}
	static int fact(int n){
		if (n==1 || n==0) return 1;
		return n*fact(n-1);
	}
}