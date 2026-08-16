package find_array_index_using_binarySearch;

import java.util.Arrays;

public class BinarySearchExample {
    public static void main(String[] args) {
        //Unsorted array
        int[] arr = {2, 5, 8, 12, 67,16, 99,23, 38, 45, 56, 78, 89};
        int target = 23;
        int index = binarySearch(arr, target);
        System.out.println("Index of " + target + " is: " + index);
        int index2 = binarySearchUsingJavaUtil(arr, target);
        System.out.println("Index of " + target + " using Java Util is: " + index2);
    }

    private static int binarySearch(int[] arr, int target) {
        //Sort the Unsorted array before performing binary search
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length -1;
        //Continue while search space is valid
        while(left <= right) {
            //Find the middle index
            int mid = left + (right - left) / 2;

            //Target value found
            if(arr[mid] == target) {
                return mid;
            }
            //Target is on right
            else if(arr[mid] < target) {
                left = mid + 1;
            }
            //Target is on left
            else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }

    private static int binarySearchUsingJavaUtil(int[] arr, int target) {
        //Sort the Unsorted array before performing binary search
        Arrays.sort(arr);
        return Arrays.binarySearch(arr, target);
    }
}
