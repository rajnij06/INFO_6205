// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class FindMinimuminRotatedSortedArray {
    public static void main (String[] args) {
        int[] nums = {3,4,5,1,2}; //1
//        int[] nums = {4,5,6,7,0,1,2}; //0
//        int[] nums = {11,13,15,17}; //11
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        if (end == -1) {
            return -1;
        }
        if (end == 0 || nums[start] < nums[end]) {
            return nums[0];
        }
        while (start <= end) {
            int mid = start+(end-start)/2;
            if (nums[mid] > nums[mid+1])
                return nums[mid+1];
            if (nums[mid] < nums[mid-1])
                return nums[mid];
            if (nums[mid] < nums[start])
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }
}
