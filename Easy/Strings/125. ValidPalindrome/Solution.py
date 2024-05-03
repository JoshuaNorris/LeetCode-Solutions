# https://leetcode.com/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = remove_non_alphabetic(s).lower()
        l: int = 0
        r: int = len(s) - 1
        if (len(s) == 0):
            return True
        
        while True:
            if s[l] != s[r]:
                return False
            l+=1
            r-=1
            if l >= r:
                break
        return True

def remove_non_alphabetic(input_string):
    result = ''
    for char in input_string:
        if char.isalpha() or char.isnumeric():
            result += char
    return result