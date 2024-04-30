// https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public String reverseWords(String s) {
        while (true) {
            if (s.charAt(0) == ' ') { s = s.substring(1); }
            else { break; }
        }
        String result = reverseWordsHelper(s, "");
        return result.substring(0, result.length()-1);
    }

    private String reverseWordsHelper(String s, String result) {
        String word = "";
        int index = 0;
        boolean seen_whitespace = false;
        while (true) {
            if (index == s.length()) {
                return word+" "+result;
            } else if (s.charAt(index) == ' ') {
                seen_whitespace = true;
            } else if (seen_whitespace) {
                break;
            } else {
                word = word + s.substring(index, index+1);
            }
            index++;
        }
        return reverseWordsHelper(s.substring(index), word+" "+result);
    }
}