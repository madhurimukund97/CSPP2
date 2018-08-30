import java.util.Scanner;
public class Average{
	public static void main(String[] args) {
		int n, i;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		double res = 0;
		int[] arr = new int[n];
        for (i = 0; i < arr.length; i++){
        	arr[i] = s.nextInt();
            res = res + arr[i];
        }
        double avg = res / arr.length;
        System.out.println(avg);
    }
}
