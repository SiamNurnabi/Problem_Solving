package com.example.topic.Array;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */

import java.util.HashMap;

public class TwoSum_1 {

    // Using hashmap
    // Without inserting all the element of the array(One pass)
    //Create an empty hash map to store elements and their indices.
    //For each element nums[i], calculate the complement by subtracting it from the target: complement = target - nums[i].
    //Check if the complement exists in the hash table. If it does, we have found a solution.
    //If the complement does not exist in the hash table, add the current element nums[i] to the hash table with its index as the value.

    public int[] twoSumSol1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                flag = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{map.get(target - nums[flag]), flag};
    }

    // Insert all the element of the array(two pass)
    // Iterate the array and search for the value in map

    public int[] twoSumSol2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                flag = i;
//                break;
            }
        }
        return new int[]{map.get(target - nums[flag]), flag};
    }
}
