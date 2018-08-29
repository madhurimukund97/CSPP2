import java.util.Scanner;
class SumOfNNumbers{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i, sum = 0;
		for(i=1;i<=n;i++){
			sum = sum +i;	
		}
		System.out.println(sum);
	}
}