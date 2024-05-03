# https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=top-interview-150

import math

class Solution:
    def maxArea(self, input: List[int]) -> int:
        l:int = 0
        r:int = len(input) - 1
        max_area:int = 0
        while True:
            if min(input[l], input[r]) * (r-l) > max_area:
                max_area = min(input[l], input[r]) * (r-l)
            elif input[l] > input[r]:
                r-=1
            else:
                l+=1
            if l>=r:
                break
        return max_area

