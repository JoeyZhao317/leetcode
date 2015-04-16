/**
 *   This algorithm is from MIT Course "Introduction to Algorithm
 *   
 *   Mergedsort is a kind of sort algorithm
 *   
 *   The time complexity O(n) = n*log(n).
 *   
 *   This is completed in 2012-1-7 by Zhao Yi
 */

package com.learning;

public class MergedSort {

	private static void subMerge(int array[]) {
		int length = array.length;
		if (length == 1) {
			return;
		}
		int mid = length / 2;
		int midToBack = length - mid;
		//I think we should not use so many new. But I have no idea now
		int[] front = new int[mid];
		int[] back = new int[midToBack];
		for (int i = 0; i < mid; i++) {
			front[i] = array[i];
		}
		for (int j = mid; j < length; j++) {
			back[j - mid] = array[j];
		}

		subMerge(front);
		subMerge(back);
		for (int i = 0, j = 0; i < mid || j < midToBack;) {
			if( i == mid && j < midToBack) {
				array[i + j] = back[j];
				j++;
				continue;
			}
			if( j == midToBack && i < mid) {
				array[i + j] = front[i];
				i++;
				continue;
			}
			if (front[i] >= back[j]) {
				array[i + j] = back[j];
				j++;
			} else if(front[i] < back[j]) {
				array[i + j] = front[i];
				i++;
			}
		}
	}

	public static void testMergeSort(int[] array, String testName) {
		int test[] = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			test[i] = array[i];
		}
		System.out.println("Start to test " + testName + ":");
		subMerge(test);
		printArray(test);
	}

	public static void printArray(int array[]) {
		System.out.print("The out of array is: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String args[]) {
		int[] test1 = { 1, 5, 3, 7, 8 , 12, 8};
		int[] test2 = { 1 };
		int[] test3 = { 13, 124, 2, 454, 14, 100, 5 };
		int[] test4 = {2,1,2,1,2,1,2, 0, 0,1,0};
		int[] test5 = {7,7,11,19,13,14,333,134,256,2,3};
		testMergeSort(test1, "test1");
		testMergeSort(test2, "test2");
		testMergeSort(test3, "test3");
		testMergeSort(test4, "test4");
		testMergeSort(test5,"test5");
	}
}
