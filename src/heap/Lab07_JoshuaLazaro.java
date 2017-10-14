package heap;

import java.util.ArrayList;

public class Lab07_JoshuaLazaro {

	static int listHeapSize;
	
	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(8);
		list.add(0);
		list.add(4);
		list.add(6);
		list.add(1);
		list.add(9);
		list.add(7);
		list.add(3);
		list.add(2);
		list.add(5);
		
		System.out.println("Before Heap Sort");
		for(int e : list){
			System.out.print(e + " ");
		}
		System.out.println();
		
		System.out.println("After Heap Sort");
		
		heapSort(list);
		//buildMaxHeap(list);
		
		for(int e : list){
			System.out.print(e + " ");
		}
	}
	
	public static int leftChild(int index){
		return 2 * index;
	}
	
	public static int rightChild(int index){
		return (2 * index) + 1;
	}
	
	public static void maxHeapify(ArrayList<Integer> list, int index){
		int left = leftChild(index);
		int right = rightChild(index);
		int largest;
		
		if(left <= listHeapSize - 1 && list.get(left) > list.get(index)){
			largest = left;
		}
		else{
			largest = index;
		}
		if(right <= listHeapSize - 1 && list.get(right) > list.get(largest)){
			largest = right;
		}
		if(largest != index){
			int temp = list.get(index);
			list.set(index, list.get(largest));
			list.set(largest, temp);
			
			maxHeapify(list, largest);
		}
	}
	
	public static void buildMaxHeap(ArrayList<Integer> list){
		listHeapSize = list.size();
		
		for(int i = list.size()/2; i >= 0; i--){
			maxHeapify(list, i);
		}
	}
	
	public static void heapSort(ArrayList<Integer> list){
		buildMaxHeap(list);
		for(int i = list.size(); i > 0; i--){
			int temp = list.get(0);
			list.set(0, list.get(i - 1));
			list.set(i - 1, temp);
			
			listHeapSize--;
			
			maxHeapify(list, 0);
		}
	}
}