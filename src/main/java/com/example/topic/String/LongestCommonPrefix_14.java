package com.example.topic.String;

import java.util.Arrays;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix_14 {
    public static String longestCommonPrefixSol1(String[] strs) {
        int minLength = 201;
        for (String s : strs) {
            minLength = Math.min(s.length(), minLength);
        }
        for (int i = 0; i < minLength; i++) {
            char temp = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != temp) {
                    minLength = i;
                    break;
                }
            }
        }
        return strs[0].substring(0, minLength);
    }

    public static String longestCommonPrefixSol2(String[] strs) {
        // Sorting the array lexicographically. First word will be the smallest. We don't need to check bigger than the smallest word.
        Arrays.sort(strs);  // logn
        String first = strs[0];
        String last = strs[strs.length - 1];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < first.length(); i++) {  // n
            if (first.charAt(i) != last.charAt(i)) {
                return stringBuilder.toString();
            }
            stringBuilder.append(first.charAt(i));
        }
        return stringBuilder.toString();    // Complexity will be nlogn
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefixSol2(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefixSol2(new String[]{""}));
        System.out.println(longestCommonPrefixSol2(new String[]{"a"}));
        System.out.println(longestCommonPrefixSol2(new String[]{"dog","done","d"}));
    }
}
