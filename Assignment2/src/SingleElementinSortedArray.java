// https://leetcode.com/problems/single-element-in-a-sorted-array/

public class SingleElementinSortedArray {
    public static void main (String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8}; //2
//        int[] nums = {3,3,7,7,10,11,11}; //10
//        int[] nums = {3,3,7,7,10,10,11}; //11
//        int[] nums = {3,7,7,10,10}; //3
        System.out.println(singleNonDuplicate(nums));
    }
    public static int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length-1;
        int mid = start+(end-start)/2;
        while (start < end) {
            if (nums[start] != nums[start+1])
                return nums[start];
            else if (nums[end] != nums[end-1])
                return nums[end];
            else {
                start = start + 2;
                end = end - 2;
            }
        }
        return nums[mid];
    }
}
