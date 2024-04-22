// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.util.HashMap;

class Solution {

	public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("aeoupyfgcr"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("cdd"));
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> letters_seen = new HashMap<>();
        int max = 0;
        int current_substring_start = 0;


        for (int index = 0; index < s.length(); index ++) {
            char current_char = s.charAt(index);
            if (letters_seen.containsKey(current_char)) {
                if (letters_seen.get(current_char) >= current_substring_start ) {

                    int new_substring_len = (index - current_substring_start);
                    current_substring_start = letters_seen.get(current_char) + 1;
                    if (new_substring_len > max) {
                        max = new_substring_len;

                    }
                } else {
                    int new_substring_len = (index - current_substring_start) + 1;
                    if (new_substring_len > max) {
                        max = new_substring_len;
                    }
                }
            } else if (index == s.length() - 1) {
                int new_substring_len = (index - current_substring_start) + 1;
                if (new_substring_len > max) {
                    max = new_substring_len;
                }
            }
            letters_seen.put(current_char, index);
        }
        return max;

    }
}