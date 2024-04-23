package com.example.topic.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 */

import java.util.Arrays;
import java.util.Stack;

public class ValidParentheses_20 {

    /*
Here is the step-by-step approach of the algorithm:
Initialize an empty stack.
Traverse the input string character by character.
If the current character is an opening bracket (i.e., '(', '{', '['), push it onto the stack.

If the current character is a closing bracket (i.e., ')', '}', ']'), check if the stack is empty.
If it is empty, return false, because the closing bracket does not have a corresponding opening bracket.
Otherwise, pop the top element from the stack and check if it matches the current closing bracket. If it does not match, return false, because the brackets are not valid.

After traversing the entire input string, if the stack is empty, return true, because all opening brackets have been matched with their corresponding closing brackets.
Otherwise, return false, because some opening brackets have not been matched with their corresponding closing brackets.
     */
    public boolean isValidSol1(String s) {
//        String[] strings= s.split("");
//        Arrays.sort(strings);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ')' && stack.peek().equals('(')) return false;
                if (c == '}' && stack.peek().equals('{')) return false;
                if (c == ']' && stack.peek().equals('[')) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public boolean isValidSol2(String s) {
        while (true) {
            if (s.contains("()")) s.replace("()", "");
            else if (s.contains("{}")) s.replace("{}", "");
            else if (s.contains("[]")) s.replace("[]", "");
            else {
                return s.isEmpty();
            }
        }
    }
}
