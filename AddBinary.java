// 67. Add Binary Easy Topics Companies

// Given two binary strings a and b,return their sum as a binary string.

// Example 1:

// Input:a="11",b="1"Output:"100"

// Example 2:

// Input:a="1010",b="1011"Output:"10101"

class Solution {
    public String addBinary(String a, String b) {

        int len1 = a.length();
        int len2 = b.length();
        int carry = 0;
        StringBuilder res = new StringBuilder();

        int i = len1 - 1;
        int j = len2 - 1;

        while (i >= 0 || j >= 0) {
            int val_a = (i >= 0) ? Character.getNumericValue(a.charAt(i)) : 0;
            int val_b = (j >= 0) ? Character.getNumericValue(b.charAt(j)) : 0;

            int sum = val_a + val_b + carry;
            carry = sum / 2;
            res.append(sum % 2);

            i--;
            j--;
        }

        if (carry != 0) {
            res.append(carry);
        }
        return res.reverse().toString();

    }
}