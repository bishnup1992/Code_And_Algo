package find_min_positive_num_from_out_of_array;

import java.util.HashSet;
import java.util.Set;

public class FindMinPositiveNumberNotPresentInGivenArray {
    public static void main(String[] args) {
        int numArr[] = {1,-1, 2, 3, 4, 5,11,-2,-7};

        Set<Integer> numSet = new HashSet<>();
        for(int num:numArr){
            if(num>0){
                numSet.add(num);
            }
        }
        System.out.println(numSet);
        int minPositiveNum = 1;
        while(numSet.contains(minPositiveNum)){
            minPositiveNum++;
        }
        System.out.println("The minimum positive number not present in the array is: " + minPositiveNum);
    }
}
