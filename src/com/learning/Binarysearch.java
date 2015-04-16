package com.learning;

public class Binarysearch {
	public static void main(String args[]) {
        int[] example = {1,4,6,7,10,14,16,18,19,20};
        //System.out.println("testcase1 result = " + binarySearch(example, 16));
        System.out.print(findOne(9999));
        int c = 9;
        int [][] testarray = new int[c][];
        testarray[0]=new int[5];   
        System.out.println();
    }
    
    static public int binarySearch( int[] input, int result) {
        int low = 0;
        int high = input.length-1;
        while(low <= high) {
            int middle = (low + high)/2;
            if( result == input[middle]) {
                return middle;
            }else if(result > input[middle]){
                low = middle + 1;
            }else {
                high = middle - 1;
            }          
        }
        return -1;
    }
    
    static public int findOne( int input) {
    	int count = 0;
    	while(input != 0) {
    		count++;
    	    input = input &(input -1);
    	}
    	return count;
    }
}
