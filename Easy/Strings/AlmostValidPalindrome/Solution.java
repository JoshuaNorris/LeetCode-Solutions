// https://leetcode.com/problems/valid-palindrome-ii/submissions/1212061531/


class Solution {


	public static void main(String[] args) {
        System.out.println(validPalindrome("abc"));
        // System.out.println(validPalindrome("abca"));

    }

    public static boolean validPalindrome(String s) {
        int lpoint = 0;
        int rpoint = s.length() - 1;
        while (true) {
            char lchar = Character.toLowerCase(s.charAt(lpoint));
            char rchar = Character.toLowerCase(s.charAt(rpoint));
            if (!Character.isLetter(lchar) && !Character.isDigit(lchar)) {
                lpoint++;
            } else if (!Character.isLetter(rchar) && !Character.isDigit(rchar)) {
                rpoint--;
            } else {
                if (lchar == rchar) {
                    lpoint ++;
                    rpoint --;
                } else if (lpoint != rpoint - 1){
                    return (isPalindrome(s.substring(lpoint, rpoint)) || isPalindrome(s.substring(lpoint + 1, rpoint + 1)));
                } else {
                	return true;
                }
            }
            if (lpoint >= rpoint) {
                break;
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s) {
    	System.out.println("string -" + s + "-");
        int lpoint = 0;
        int rpoint = s.length() - 1;
        while (true) {
            char lchar = Character.toLowerCase(s.charAt(lpoint));
            char rchar = Character.toLowerCase(s.charAt(rpoint));
            if (!Character.isLetter(lchar) && !Character.isDigit(lchar)) {
                lpoint++;
            } else if (!Character.isLetter(rchar) && !Character.isDigit(rchar)) {
                rpoint--;
            } else {
                if (lchar == rchar) {
                    lpoint ++;
                    rpoint --;
                } else {
                    return false;
                }
            }
            if (lpoint >= rpoint) {
                break;
            }
        }
        return true;
    }

}