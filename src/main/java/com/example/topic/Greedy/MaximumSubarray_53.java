package com.example.topic.Greedy;

/*
Given an integer array nums, find the
subarray
 with the largest sum, and return its sum.
 */

public class MaximumSubarray_53 {

    // Brute force approach
    // Find all the sub array and find the max value
    public int maxSubArraySol1(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            max = Math.max(max, sum);
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        max = Math.max(max, nums[nums.length-1]);
        return max;
    }

//     Kadane's algorithm approach
    /*
    The subarray with negative sum is discarded (by assigning max_ending_here = 0 in code).
We carry subarray till it gives positive sum.
     */
    public int maxSubArraySol2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
