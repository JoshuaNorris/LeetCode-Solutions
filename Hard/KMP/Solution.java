// https://leetcode.com/problems/shortest-palindrome/description/

class Solution {
    public String shortestPalindrome(String s) {
        String reverse = (new StringBuilder(s).reverse()).toString();

        int partial_match_index = kmp(reverse, s);
        System.out.println(partial_match_index);
        return reverse.substring(0, reverse.length() - partial_match_index) + s;

    }

    private int kmp(String reversed, String s) {
        String newstring = s + '#' + reversed;
        int[] partial_match_table = new int[newstring.length()];
        int k = 0;
        int i = 1;
        while (i<newstring.length()) {
            if (newstring.charAt(k) == newstring.charAt(i)) {
                partial_match_table[i] = k+1;
                k++;
                i++;
            } else {
                if (k > 0) {
                    k = partial_match_table[k-1];
                } else {
                    partial_match_table[i] = 0;
                    i++;
                }
            }
        }
        return partial_match_table[newstring.length()-1];
    }
}