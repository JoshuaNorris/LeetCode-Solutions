// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int strStr(String haystack, String needle) {
        int[] kmp_table = kmpTableBuilder(needle);
        return kmp(haystack, needle, kmp_table);
    }

    private int kmp(String haystack, String needle, int[] kmp_table) {
        int hindex = 0;
        int nindex = 0;
        int matchedindex = -1;
        while (true) {
            if (haystack.charAt(hindex) == needle.charAt(nindex)) {
                matchedindex = (matchedindex == -1) ? hindex : matchedindex;
                if (nindex >= needle.length() - 1) { return matchedindex; }
                hindex ++;
                nindex ++;
            } else {
                if (nindex == 0) {
                    hindex++;
                    matchedindex = -1;
                }
                else {
                    nindex = kmp_table[nindex - 1];
                    matchedindex = hindex - nindex;
                }
            }

            if (hindex > haystack.length() - 1) { return -1; }
        }
    }

    private int[] kmpTableBuilder (String needle) {
        int[] kmp_table = new int[needle.length()];
        if (needle.length() == 1) { return kmp_table; }
        int index = 0;
        int j = 1;
        while (true) {
            if (needle.charAt(j) == needle.charAt(index)) {
                kmp_table[j] = index + 1;
                index ++;
                j++;
            } else {
                if (index == 0) {
                    j++;
                } else {
                    index = kmp_table[index - 1];
                }
            }
            if (j >= needle.length()-1) { break; }

        }
        return kmp_table;
    }
}