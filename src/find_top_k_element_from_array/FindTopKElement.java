package find_top_k_element_from_array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindTopKElement {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        int k = 3;
        int[] topKElements = getTopKElement(nums, k);
        System.out.println("Top " + k + " elements: ");
        for (int num : topKElements) {
            System.out.print(num + " ");
        }
    }

    private static int[] getTopKElement(int[] nums, int k){
        if(nums == null || nums.length == 0 || k <= 0){
            return new int[0];
        }
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // Logic to find top K elements from the array
        //Step 1: Count the frequency of each element in the array
        for(int num: nums){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        }
        //Step 2: Use a priority queue (min-heap) to keep track of the top K elements based on their frequency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(num -> frequencyMap.get(num)));//here empty heap created and adding Comparator.compareInt(frequencyMap::get) to compare the frequency of elements in futures when we add elements to the heap.

        for(int num: frequencyMap.keySet()){
            minHeap.offer(num); //added the element to the minHeap
            if(minHeap.size() > k){
                minHeap.poll(); // Remove the element with the lowest frequency
            }
        }

        //Step 3: Extract the top K elements from the priority queue and return them as an array
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = minHeap.poll();
        }
        return result; // Return the array of top K elements
    }
}
