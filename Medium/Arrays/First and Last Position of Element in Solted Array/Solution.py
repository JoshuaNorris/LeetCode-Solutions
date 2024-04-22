from typing import List

class Solution:
	def searchRange(self, nums: List[int], target: int) -> List[int]:
		result_start = Solution.binarySearch(nums, target)
		if result_start == -1:
			return [-1, -1]
		result_end = result_start
		while True:
			if result_end == len(nums) - 1:
				break
			elif nums[result_end + 1] == target:
				result_end += 1
			else:
				break
		while True:
			if result_start == 0:
				break
			elif nums[result_start - 1] == target:
				result_start -= 1
			else:
				break
		return [result_start, result_end]

	def binarySearch(nums: List[int], target: int) -> int:
		search_start = 0
		search_end = len(nums) - 1
		search_mid = (search_start + search_end) // 2  # Floor division operator in Python
		if (len(nums) == 0):
			return -1

		while True:
			if nums[search_mid] == target:
				return search_mid
			elif search_start == search_end:
				return -1
			elif nums[search_mid] > target:
				if search_mid == 0:
					return -1
				else:
					search_end = search_mid - 1
			else:
				if search_mid == len(nums) - 1:
					return -1
				else:
					search_start = search_mid + 1
			search_mid = (search_start + search_end) // 2  # Floor division operator in Python

def main():
	solution = Solution()
	print(Solution.searchRange(solution, [5,7,7,8,8,10], 8))
	print(Solution.searchRange(solution, [5,7,7,8,8,10], 6))
	print(Solution.searchRange(solution, [], 0))
	print(Solution.searchRange(solution, [2,2], 1))

main()
