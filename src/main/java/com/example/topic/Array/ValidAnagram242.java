package com.example.topic.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */

public class ValidAnagram242 {

    // If the length of the Strings are equal, then sort them first.
    // After that if those Strings are equal, that will be a valid anagram.
    public boolean isAnagramSol1(String s, String t) {
        if (s.length() == t.length()) {
            char[] charArrayOfS = s.toCharArray();
            Arrays.sort(charArrayOfS);
            String sortedS = new String(charArrayOfS);
            char[] charArrayOfT = t.toCharArray();
            Arrays.sort(charArrayOfT);
            String sortedT = new String(charArrayOfT);
            return sortedS.equals(sortedT);
        } else return false;
    }

    // Using hashmap.
    // Add the frequency of First string and subtract the frequency of second string
    // value of the key of the map will be zero
    public boolean isAnagramSol2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for (int value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }


    // Hash Table (Using Array)
    public boolean isAnagramSol3(String s, String t) {
        int[] counts = new int[26];
        // Count the frequency of characters in string s
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        // Decrement the frequency of characters in string t
        for (char c : t.toCharArray()) {
            counts[c - 'a']--;
        }
        // Check if any character has non-zero frequency
        for (int value : counts) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }


}
