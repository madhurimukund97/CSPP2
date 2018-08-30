import java.util.Scanner;
public class Concatinate{
	public static void main(String[] args) {
		String h,st,c;
		Scanner s = new Scanner(System.in);
		st = s.nextLine();
		h = "Hello";
		c = h.concat(" " + st + "!");
		System.out.println(c);

	}
}