/**
 *   This algorithm is from MIT Course "Introduction to Algorithm
 *   
 *   QuickSort is a kind of sort algorithm
 *   
 *   The average of time complexity is about O(n) = n*log(n).
 *   But if the input is sorted array or reverse oder, 
 *   the time complexity will is n^2, so we need use the 
 *   random index to pick the master element to get the best
 *   average time complexity
 *   
 *   This is completed in 2012-1-15 by Zhao Yi
 */

package com.learning;

public class QuickSort {

    public static void quickSubSort(int[] A, int firstIndex, int lastIndex) {
        if (firstIndex >= lastIndex) {
            return;
        }
        int boundary = firstIndex + 1;
        // int q = firstIndex + 1;
        int keeper = A[firstIndex];

        for (int k = firstIndex + 1; k <= lastIndex; k++) {
            if (A[k] < keeper) {
                if (k > boundary) {
                    int tmp = A[k];
                    A[k] = A[boundary];
                    A[boundary] = tmp;
                }
                boundary++;
            }
        }
        A[firstIndex] = A[boundary - 1];
        A[boundary - 1] = keeper;
        MergedSort.printArray(A);
        quickSubSort(A, firstIndex, boundary - 1);
        quickSubSort(A, boundary, lastIndex);
    }

    public void quickSort(int[] A) {
        int lenght = A.length;
        quickSubSort(A, 0, lenght - 1);
        // MergedSort.printArray(A);
        String b = "aaa";
        char c = b.charAt(1);
    }

    public static void testQuickSort(int[] array, String testName) {
        System.out.println("Start to test " + testName + ":");
        quickSubSort(array, 0, array.length - 1);
        MergedSort.printArray(array);
    }

    public static void main(String args[]) {
        int A1[] = { 12, 4, 2, 15, 5, 20, 7 };
        int A2[] = { 26, 24, 22, 15, 13, 10, 4 };
        int A3[] = { 1, 2, 3, 4, 5, 6, 7 };
        int A4[] = { 1, 2, 13, 4, 5, 6, 7,26, 24, 22, 15, 13, 10, 4 };

        testQuickSort(A1, "test1");
        testQuickSort(A2, "test2");

        testQuickSort(A3, "test3");
        testQuickSort(A4, "test4");
    }
}
