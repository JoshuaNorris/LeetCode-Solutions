# https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        l:int = 0
        r:int = len(numbers) - 1

        while True:
            if numbers[l]+numbers[r] == target:
                break
            elif numbers[l]+numbers[r] > target:
                r-=1
            else:
                l+=1
        return [l+1, r+1]