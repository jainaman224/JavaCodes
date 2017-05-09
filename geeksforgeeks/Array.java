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
	private void emptyArray(int[] arr) {
		for(int i=0;i<arr.length;i++)
			arr[i] = 0;
	}
	
	// Swap numbers trick
	private int getItself(int itself, int dummy) {
		return itself;
	}
	
	// Menu for array
	public void menu() {
		long startTime, stopTime;
		
		System.out.println("1. Custom array");
		System.out.println("2. Random array");
		
		System.out.print("Enter your choice: ");
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
		System.out.println("3. Quick Sort");
		System.out.println("4. Merge Sort");
		System.out.println("5. Counting Sort");
		System.out.println("6. Heap Sort");
		
		System.out.print("Enter your choice: ");
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
				startTime = System.currentTimeMillis();
				insertionSort();
				stopTime = System.currentTimeMillis();
				System.out.println("Time elapsed "+ (stopTime - startTime));
				printArray();
				break;
				
			case 3:
				startTime = System.currentTimeMillis();
				quickSort(0, array.length-1);
				stopTime = System.currentTimeMillis();
				System.out.println("Time elapsed "+ (stopTime - startTime));
				printArray();
				break;
				
			case 4:
				startTime = System.currentTimeMillis();
				mergeSort(0, array.length-1);
				stopTime = System.currentTimeMillis();
				System.out.println("Time elapsed "+ (stopTime - startTime));
				printArray();
				break;
				
			case 5:
				startTime = System.currentTimeMillis();
				countingSort(256);
				stopTime = System.currentTimeMillis();
				System.out.println("Time elapsed "+ (stopTime - startTime));
				printArray();
				break;
				
			case 6:
				startTime = System.currentTimeMillis();
				heapSort();
				stopTime = System.currentTimeMillis();
				System.out.println("Time elapsed "+ (stopTime - startTime));
				printArray();
				break;
				
			default:
				System.out.println("Invalid");
		}
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
		
	// Partition for quick sort (Conquer Step)
	private int partition(int left, int right) {
		int pivot = array[left];
		int index = right;
			
		for(int j=right;j>left;j--)
			if(array[j]>pivot) {
				array[index] = getItself(array[j], array[j]=array[index]);
				index--;
			}
			
		array[left] = array[index];
		array[index] = pivot;
			
		return index;
	}
		
	// Quicksort (Divide Step)
	private void quickSort(int left, int right) {
		if(left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}
		
	// MergeSort (Conquer Step)
	private void merge(int left, int mid, int right) {
		int[] temp = new int[right-left+1];
		
		int start1 = left, start2 = mid + 1, j = 0;
		
		while(start1<=mid && start2<=right) {
			if(array[start1]<array[start2])
				temp[j] = array[start1++];
			else
				temp[j] = array[start2++];
			j++;
		}
			
		while(start1<=mid)
			temp[j++] = array[start1++];
			
		while(start2<=right)
			temp[j++] = array[start2++];
			
		for(j=0;j<=right-left;j++)
			array[left+j] = temp[j];
	}
		
	// MergeSort (Divide Step)
	private void mergeSort(int left, int right) {
		if(left<right) {
			int mid = left + (right - left)/2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}
		
	// Counting Sort
	private void countingSort(int range) {
		int[] countArray = new int[range+1];
		int[] output = new int[array.length];
		emptyArray(countArray);
			
		for(int i=0;i<array.length;i++)
			countArray[array[i]]++;
			
		for(int i=1;i<=range;i++)
			countArray[i] += countArray[i-1];
			
		for(int i=0;i<array.length;i++) {
			output[countArray[array[i]]-1] = array[i];
			countArray[array[i]]--;
		}
	
		for(int i=0;i<array.length;i++)
			array[i] = output[i];
	}
	
	// Heapify array
	private void heapify(int i, int size) {
		int parent = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left<size && array[left]>array[parent])
			parent = left;
		
		if(right<size && array[right]>array[parent])
			parent = right;
		
		if(parent!=i) {
			array[parent] = getItself(array[i], array[i] = array[parent]);
			heapify(parent, size);
		}
	}
	
	// Heapsort
	private void heapSort() {
		int size = array.length;
		
		for(int i=size/2-1;i>=0;i--)
			heapify(i, size);
		
		for(int i=size-1;i>=0;i--) {
			System.out.println(array[0]+" "+array[i]);
			array[i] = getItself(array[0], array[0] = array[i]);
			System.out.println(array[0]+" "+array[i]);
			heapify(0, i);
		}
	}
}
