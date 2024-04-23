package com.example.topic.Array;

import java.util.*;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */

public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if (!map.containsKey(sortedStr)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr, list);
            }else{
                map.get(sortedStr).add(str);
            }
        }
        System.out.println("map values:::" + map);
        return new ArrayList<>(map.values());
    }
}
