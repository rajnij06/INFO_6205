//https://leetcode.com/problems/3sum-closest/

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main (String[] args) {
//        int[] nums = {-1,2,1,-4}; int target = 1; //2
        int[] nums = {0,0,0}; int target = 1; //0
        System.out.println(threeSumClosest(nums,target));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i=0; i<len-2; i++) {
            int j=i+1, k=len-1;
            while (j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                if (Math.abs(target-sum) < Math.abs(target-ans))
                    ans = sum;
                if (sum < target)
                    j++;
                else
                    k--;
            }
        }
        return ans;
    }
}
