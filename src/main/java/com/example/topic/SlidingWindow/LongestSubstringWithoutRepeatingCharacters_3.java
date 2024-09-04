package com.example.topic.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Given a string s, find the length of the longest
substring
without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        String subString = String.valueOf(s.charAt(left));
        int maxLength = 0;
        while (right < s.length()) {
            String c = String.valueOf(s.charAt(right));
            if (subString.contains(c)) {
                left = right;
            }
            subString = s.substring(left, right + 1);
            maxLength = Math.max(maxLength, subString.length());
            right++;
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringSol2(String s) {
        int left = 0;
        int right = 0;
        int maxLength = Integer.MIN_VALUE;
//        char[] chars = s.toCharArray();
        String[] strings = String.valueOf(s).split("");
        StringBuilder subString = new StringBuilder();
        while (right < strings.length) {
            String c = strings[right];
            if (subString.toString().contains(c)) {
                subString = new StringBuilder();
                left++;
                right = left;
                continue;
            }
            subString.append(c);
            maxLength = Math.max(maxLength, subString.length());
            right++;
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringSol3(String s) { // explanation of this block of code
        int left = 0;
        int right = 0;
        int maxLength = Integer.MIN_VALUE;
        if (s.isEmpty()) {
            return 0;
        }
        String[] strings = s.split("");
        StringBuilder subString = new StringBuilder();
        while (right < strings.length) {
            String c = strings[right];
            if (subString.toString().contains(c)) {   // If c is found in subString, the method finds the index of c in subString and deletes characters from the beginning of subString up to and including c. It also increments the left pointer accordingly.
                int start = subString.toString().indexOf(c);
                while (start != -1) {
                    subString.delete(subString.charAt(0), start + c.length());
                    start--;
                    left++;
                }
            }
            subString.append(c);
            maxLength = Math.max(maxLength, subString.length());
            right++;
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringSol4(String s) {
        int left = 0;
        int maxLength = Integer.MIN_VALUE;
        if (s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.get(c) > 1) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}

class Main {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_3 longestSubstringWithoutRepeatingCharacters3 = new LongestSubstringWithoutRepeatingCharacters_3();
        System.out.println(longestSubstringWithoutRepeatingCharacters3.lengthOfLongestSubstring("abcdcdabef"));
    }
}
