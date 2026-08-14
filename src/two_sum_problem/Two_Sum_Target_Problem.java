package two_sum_problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum_Target_Problem {

    public static void main(String[] args) {
        int[] twoSumNumArray = getTwoSumNumArray(new int[]{3, 5, 8, 12}, 13);
        if (twoSumNumArray != null){
            System.out.println(Arrays.toString(twoSumNumArray));
        }
    }

    /**
     * Input = [3,5,8,12]
     * target = 13
     * Figure out the collective Sum of the index should be target Value =13
     *
     * Ex: 5+8 =13
     * Output = [1,2]   Number 5 is 1st Index, and Number 8 is in 2nd Index
     */
    /**
     * Steps-1:Scan/Loop the num array
     * Step-2: define need = target - current  Ex: Here target is 13 , always Subtracted your target value from current number , to check if its meet your need
     * Step-3: If your need found , get index of your need position and current value position
     * Step-4: if your need not meet after your substraction,then store (num->index), Look for next Number in the array
     */

    private static int[] getTwoSumNumArray(int[] nums, int target) {

        Map<Integer, Integer> twoSumMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (twoSumMap.containsKey(need)) {
                return new int[]{twoSumMap.get(need), i};
            }
            twoSumMap.put(nums[i], i); //Put this number->index and move to next num
        }
        return null;
    }
}
