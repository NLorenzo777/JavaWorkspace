package org.searchalgorithms.binarysearch;

public class Main {

    public static void main(String[] args) {
        int[] testArray = {1, 2, 7, 8, 22, 28, 41, 58, 67, 71, 94};
        int target = 94;
        System.out.println(BinarySearch.search(testArray, target));
    }
}