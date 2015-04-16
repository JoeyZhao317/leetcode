package com.learning;

public class InsertSort {
	InsertSort() {
    }
	
	static public void sort(int[] input) {
		int lenght = input.length - 1;
		for (int i = 1; i <= lenght; i++) {
			int tmp = input[i];
			int j ;
			for (j = i; j > 0 && tmp < input[j - 1]; j--) {
				input[j] = input[j - 1];
			}
			input[j] = tmp;
		}

	}
	
	public static void main(String[] args){
		int[] a={1,4,2,5,8,10,24,7};
		sort(a);
		BubbleSort.printArray(a);
	}
	
}
