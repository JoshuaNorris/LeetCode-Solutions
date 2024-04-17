/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    var nums1_point = 0;
    var nums2_point = 0;
    var nums1_copy = []
    nums1.forEach(function(element) {
        nums1_copy.push(element);
    });

    for (let i = 0; i < m+n; i++) {
        if (nums1_point === m) {
            nums1[i] = nums2[nums2_point];
            nums2_point++;
        } else if (nums2_point === n) {
            nums1[i] = nums1_copy[nums1_point];
            nums1_point++;
        } else if (nums1_copy[nums1_point] === nums2[nums2_point]) {
            nums1[i] = nums1_copy[nums1_point];
            i++;
            nums1[i] = nums2[nums2_point];
            nums1_point++;
            nums2_point++;
        } else if (nums1_copy[nums1_point] < nums2[nums2_point]) {
            nums1[i] = nums1_copy[nums1_point];
            nums1_point++;
        } else if (n == 0) {
        } else {
            nums1[i] = nums2[nums2_point];
            nums2_point++;
        }
    }
};