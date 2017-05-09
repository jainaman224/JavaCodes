package geeksforgeeks;
import java.util.*;

public class GeeksforGeeks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array");
		Array array = new Array(sc.nextInt());
		array.menu();
		sc.close();
	}

}
