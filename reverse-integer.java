//Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

//Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

//Example 1:

//Input: x = 123
//Output: 321



import java.util.Stack;

class Solution {
    public int reverse (int x){
        long num = x;
        boolean isNegative = false;
        if(num < 0){
            isNegative = true;
            num = Math.abs(num);
        }

        String s = String.valueOf(num);
        Stack<Character> stack = new Stack<>();

        for( int i =0; i < s.length(); i++){
            stack.push(s.charAt(i));
        }

        StringBuilder reversedStr = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedStr.append(stack.pop());
        }

        try{
            long finalNum = Long.parseLong(reversedStr.toString());
            if (isNegative) finalNum = -finalNum;

            if(finalNum < Integer.MIN_VALUE ||  finalNum > Integer.MAX_VALUE) {
                return 0;
            }
            return (int) finalNum;
        } catch  (NumberFormatException e) {
            return 0;
        }
    }
}