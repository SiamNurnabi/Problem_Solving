package com.example.topic.Array;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
 */

public class ProductOfArrayExceptSelf_238 {


    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int prod = 1;
        for (int i = 0; i < length; i++) {
            prod *= nums[i];
        }
        int i = 0;
        for (int num : nums) {
            result[i++] = prod / num;
        }
        return result;
    }

    // Withing using division operation.
    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int[] prefix = new int[length];
        int[] suffix = new int[length];
        prefix[0] = 1;
        suffix[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for (int i = length - 2; i >= 0; i++) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < length; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}
