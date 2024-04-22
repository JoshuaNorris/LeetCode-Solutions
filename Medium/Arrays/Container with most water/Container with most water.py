# From https://leetcode.com/problems/container-with-most-water/description/




def biggest_container(input):
	max = 0
	r = len(input) - 1
	l = 0
	if len(input) < 2:
		return 0

	while True:
		if r == l:
			break
		else:
			if input[r] > input[l]:
				area = input[l] * (r - l)
				if area > max:
					max = area
				l += 1
			else:
				area = input[r] * (r - l)
				if area > max:
					max = area
				r -= 1
	return max







print(biggest_container([]))
print(biggest_container([1]))
print(biggest_container([2,2]))
print(biggest_container([1,8,6,2,5,4,8,3,7]))
