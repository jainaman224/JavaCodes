package geeksforgeeks;
import java.util.*;

public class Array {
	int[] array;
	Scanner sc;
	
	// Constructor
	public Array(int size) {
		sc = new Scanner(System.in);
		array = new int[size];
	}
	
	// Take input in array
	private void setArray() {
		System.out.println("Enter elements of array");
		
		for(int i=0;i<array.length;i++)
			array[i] = sc.nextInt();
	}
	
	// Random array generator
	private void randomArray() {
		Random r = new Random();
		
		for(int i=0;i<array.length;i++)
			array[i] = r.nextInt();
	}
	
	// Print array
	public void printArray() {
		System.out.println("Array");
		
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
	}
	
	// Linear Search
	public int linearSearch(int element) {
		for(int i=0;i<array.length;i++)
			if(array[i]==element)
				return i;
		
		return -1;
	}
	
	// Empty array
	private void emptyArray() {
		for(int i=0;i<array.length;i++)
			array[i] = 0;
	}
	
	// Swap numbers
	private void swapNumbers(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	// Insertion Sort
	private void insertionSort() {
		int j, temp;
		
		for(int i=1;i<array.length;i++) {
			j = i - 1;
			temp = array[i];
			
			while(j>=0 && array[j]>temp) {
				array[j+1] = array[j];
				j--;
			}
			
			array[j+1] = temp;
		}
	}
	
	// Menu for array
	public void menu() {
		System.out.println("1. Custom array");
		System.out.println("2. Random array");
		
		System.out.println("Enter your choice");
		switch(sc.nextInt()) {
			case 1:
				setArray();
				break;
			
			case 2:
				randomArray();
				System.out.print("Random ");
				printArray();
				break;
				
			default:
				System.out.println("Invalid choice. Option is taken to be custom.");
				setArray();
		}
		
		System.out.println("Welcome to array menu");
		System.out.println("1. Linear Search");
		System.out.println("2. Insertion Sort");
		
		System.out.print("Enter your choice");
		switch(sc.nextInt()) {
			case 1:
				System.out.print("Enter element to be searched");
				int answer = linearSearch(sc.nextInt());
				
				if(answer==-1)
					System.out.println("Element not present in array");
				else
					System.out.println("Element is found at index "+(answer+1));
				
				break;
			
			case 2:
				long startTime = System.currentTimeMillis();
				insertionSort();
				long stopTime = System.currentTimeMillis();
				System.out.println("Time elapsed"+ (stopTime - startTime));
				printArray();
				break;
				
			default:
				System.out.println("Invalid");
		}
	}
}
