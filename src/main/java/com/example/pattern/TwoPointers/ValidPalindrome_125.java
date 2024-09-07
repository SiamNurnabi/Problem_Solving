package com.example.pattern.TwoPointers;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
 */

public class ValidPalindrome_125 {

    // [^a-zA-z0-9] equivalent to [\W]|_ Also it removes underscore.
    public boolean isPalindromeSol1(String s) {
        String lowerCase = s.toLowerCase();
//        String nonAlpha = lowerCase.replaceAll("[^a-zA-z0-9]", "");
        String nonAlpha = lowerCase.replaceAll("[\\W]|_", "");
        int length = nonAlpha.length();
        if (length == 0 || length == 1) {
            return true;
        } else {
            for (int i = 0; i < length / 2; i++) {
                if (nonAlpha.charAt(i) != nonAlpha.charAt(length - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }


    // Using two pointers
    public boolean isPalindromeSol2(String s) {
        String lowerCase = s.toLowerCase();
        lowerCase = lowerCase.replaceAll("[\\W]|_", "");
        int length = lowerCase.length();
        int l = 0, r = length - 1;
        if (length == 0 || length == 1) {
            return true;
        }
        while (l < r) {
            if (lowerCase.charAt(l) == lowerCase.charAt(r)) {
                l++;
                r--;
            }
            if (lowerCase.charAt(l) != lowerCase.charAt(r)) {
                return false;
            }
        }
        return true;
    }


    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while (start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst)) {
                start++;
            } else if (!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
}
