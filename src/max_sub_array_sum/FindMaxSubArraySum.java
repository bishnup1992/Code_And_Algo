package max_sub_array_sum;

public class FindMaxSubArraySum {
    public static void main(String[] args) {
        System.out.println(getMaxSubArraySum(new int[]{5,-2,3,-10,6}));
    }

    /**
     * Problem Statement : find a continuous group of num , which sum is larget from an array [-2,1,-3,4,-1,2,1,-5,4]
     *  Output [4.-1,2,1] -> 4+(-1)+2+1 = 6 , Which is the highest number in the given array
     *  Logic Steps:
     * Keep Extending current subarray when the previous running sum helps us, If carrying
     * the previous sum makes the result worse than starting from the current number, start fresh.
     * Every number ask if it is better to continue or start fresh
     * Always compare Maximum in maxSum and CurrSum in each step and return the max number you found at last
     * Ex: if(currSum + nums[i] < nums[i]){
     *     currSum = nums[i]; //start fresh
     * }else{
     *     currSum = currSum+nums[i];//Cpmtinue old subarray
     * }
     * Max function =>  helps us do the same in one line choose whichever is better
     * Ex: Math.max(option1(start fresh),option2(contue with old array))
     */
    public static int getMaxSubArraySum(int[] numArr){
        if (numArr == null || numArr.length == 0) {
            return 0;
        }

        int currSum = numArr[0];
        int maxSum=   numArr[0];

        for(int i=1; i<numArr.length; i++){
            // Option 1: Start fresh from current number
            // Option 2: Continue previous subarray
            currSum= Math.max(numArr[i],currSum+numArr[i]);
            // Keep the best sum found so far
            maxSum= Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}
