package com.example.topic.Array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/*
https://leetcode.com/problems/contains-duplicate/description/
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */

public class ContainsDuplicate_217 {

    //The brute force approach involves comparing each element in the array with every other element to check for duplicates.
    public boolean containsDuplicateSol1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

    // Using hashset.
    // First all the integers are added to a hashset. So there will be no duplicate value.
    // If we compare the length between array and the hashset, we will get the answer.
    public boolean containsDuplicateSol2(int[] nums) {
        int arrayLength = nums.length;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        return numSet.size() < arrayLength;
    }

    // sort the array
    // then check for adjacent elements that are the same.

    public boolean containsDuplicateSol3(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1])
                return true;
        }
        return false;
    }


    /* we iterate through the array and store each element as a key in a hash map.
    The value associated with each key represents the count of occurrences of that element.
    If we encounter an element that already exists in the hash map with a count greater than or equal to 1, we return true.
     */
    public boolean containsDuplicateSol4(int[] nums) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int num : nums) {
            if (seen.containsKey(num) && seen.get(num) >= 1) return true;
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }
        return false;
    }
}
