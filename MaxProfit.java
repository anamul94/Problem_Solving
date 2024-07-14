package com.anamul;

public class MaxProfit {

    public int maxProfit(int[] prices){
        int maxProfit = 0;
        int maxprofitDay = -1;
        for (int i=0;i<prices.length-1;i++){
            for (int j=i+1;j<prices.length;j++){
                if (prices[j] - prices[i] > maxProfit){
                    maxProfit = prices[j] - prices[i];
//                    maxProfit = j;
                }

            }
        }

        return  maxProfit;
    }

    public  int maxProfit2(int[] prices){
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE; // Initialize min price to positive infinity

        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice); // Update max profit based on current price and min price
            minPrice = Math.min(minPrice, price); // Update min price with the lower value
        }

        return maxProfit;
    }

    public int maxSum(int[] nums){
        int maxSum = nums[0];
        int currSum = 0;

        for(int num : nums){
            currSum = Math.max(0, currSum);
            currSum += num;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;

    }

//    public int maxCircularSubarraySum(int[] nums) {
//        int maxSum = Integer.MIN_VALUE; // Initialize max sum to negative infinity
//        int currMax = 0;
//        int minSum = 0; // Track minimum sum for wrapping case
//        int currMin = 0;
//
//        for (int num : nums) {
//            currMax = Math.max(currMax + num, num); // Update current max sum
//            maxSum = Math.max(maxSum, currMax); // Update overall max sum
//
//            currMin = Math.min(currMin + num, num); // Update current minimum sum
//            minSum = Math.min(minSum, currMin); // Update overall minimum sum
//
//            System.out.println(maxSum);
//        }
//
//        // Handle wrapping case: total sum - minimum sum (wrapping subarray)
//        if (maxSum < 0) {
//            return maxSum; // All elements negative, return maxSum
//        }
//        return maxSum - minSum;
//    }

    public int maxCircularSubarraySum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxSum = nums[0];
        int currMax = nums[0];
        int minSum = nums[0];
        int currMin = nums[0];
        int totalSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            currMax = Math.max(currMax + num, num); // Update current max sum
            maxSum = Math.max(maxSum, currMax); // Update overall max sum

            currMin = Math.min(currMin + num, num); // Update current minimum sum
            minSum = Math.min(minSum, currMin); // Update overall minimum sum

            totalSum += num; // Update total sum
        }

        // Handle the case where all elements are negative
        if (maxSum < 0) {
            return maxSum; // All elements negative, return maxSum
        }

        return Math.max(maxSum, totalSum - minSum); // Maximum of non-wrapping and wrapping subarray
    }

    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n == 1) return 1;

        int maxLength = 1;
        int inc = 1; // Length of subarray ending with increasing pattern
        int dec = 1; // Length of subarray ending with decreasing pattern

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                inc = dec + 1;
                dec = 1;
            } else if (arr[i] < arr[i - 1]) {
                dec = inc + 1;
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            maxLength = Math.max(maxLength, Math.max(inc, dec));
        }

        return maxLength;
    }


//    public int maxCircularSubarraySum(int[] nums){
//        int linear_sum = maxSum(nums);
//
//        int totalSum = 0;
//        for (int i=0; i<nums.length; i++){
//            totalSum += nums[i];
//            nums[i] = -nums[i];
//        }
//
//        int circularSum = totalSum + maxSum(nums);
//
//        return  Math.max(linear_sum,circularSum);
//
//
//    }

    public void main(){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

        int[] prices2 = {7,6,4,3,1};
        System.out.println(maxProfit2(prices2));

        int[] prces3 = {4,1,2,7,3,4};

        System.out.println(maxProfit2(prces3));
        System.out.println(maxProfit(prces3));

//        int[] nums = {-3,-2,-3};
        int[] nums = {1,-2,3,-2};
        System.out.println(maxCircularSubarraySum(nums));

    }
}
