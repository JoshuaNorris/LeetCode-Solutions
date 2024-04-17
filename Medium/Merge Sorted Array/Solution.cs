public class Solution {
    public void Merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1_pointer = 0;
        int nums2_pointer = 0;
        int[] nums1temp = new int[m];
        for (int x = 0; x < m; x++)
        {
            nums1temp[x] = nums1[x];
        }
        if (m > 0 && n > 0)
        {
            for (int x = 0; x < m+n; x++)
            {
                int num1 = nums1temp[nums1_pointer];
                int num2 = nums2[nums2_pointer];
                if (num1 > num2)
                {
                    nums1[x] = num2;
                    nums2_pointer++;
                    if (nums2_pointer == n)
                    {
                        nums2_pointer--;
                        nums2[nums2_pointer] = Int32.MaxValue;
                    }
                }
                else
                {
                    nums1[x] = num1;
                    nums1_pointer++;
                    if (nums1_pointer == m)
                    {
                        nums1_pointer--;
                        nums1temp[nums1_pointer] = Int32.MaxValue;
                    }
                }
            }
        }
        else if (m==0 && n !=0)
        {
            for (int x = 0; x < n; x++)
            {
                nums1[x] = nums2[x];
            }
        }
    }
}