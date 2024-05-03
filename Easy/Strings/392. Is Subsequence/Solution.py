# https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        sointer:int = 0
        if len(s) == 0:
            return True
        for char in t:
            if char == s[sointer]:
                sointer+=1
                if sointer >= len(s):
                    return True
        return False
