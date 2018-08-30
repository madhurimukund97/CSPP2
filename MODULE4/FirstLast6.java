import java.util.Scanner;
public class FirstLast6{
	public static void main(String[] args) {
		// Scanner s = new Scanner(System.in);
		// int n = s.nextInt();
		int n;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		int[] arr;
		arr = new int[n];
		for (int i=0;i<n;i++){
			arr[i] = s.nextInt();
		}
		if (arr[0] == 6 || arr[n-1] == 6){
			System.out.println(true);
		}
		else{
			System.out.println(false);
		}
	}
}