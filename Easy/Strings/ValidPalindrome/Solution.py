# https://leetcode.com/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def isPalindrome(self, s: str) -> bool:
        l: int = 0
        r: int = len(s) - 1
        while True:

            if s[l].lower() != s[r].lower():
                return False
            l+=1
            r-=1
            while (l<len(s) and not s[l].isalpha()):
                l+=1
            while (r>=0 and not s[r].isalpha()):
                r-=1
            if l >= r:
                break
        return True
