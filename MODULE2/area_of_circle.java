import java.util.Scanner;
public class area_of_circle{
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		int radius = s.nextInt();
		
		System.out.println(area(radius));
	}

	static double area(int radius){
		 double areaofcircle = pi()*radius*radius;
         return areaofcircle;
	}
	static double pi(){
		return 3.14;
	}

}