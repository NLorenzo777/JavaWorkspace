package org.searchalgorithms.binarysearch;

//TODO: Create a flow chart for better visualization.
public class BinarySearch {

    public static int search(int[] array, int target) {
        int left = 0;
        int right = array.length;

        while (right > left) {
            int mid = Math.floorDiv(left+right, 2);
            int midValue = array[mid];
            if (midValue == target) {
                return mid;
            } else if (target > midValue) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        //means that the value does not exist.
        return -1;
    }
}