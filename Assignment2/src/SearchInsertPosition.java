// https://leetcode.com/problems/search-insert-position/

public class SearchInsertPosition {
    public static void main (String[] args) {
        int[] nums = {1,3,5,6}; int target = 5; //2
//        int[] nums = {1,3,5,6}; int target = 2; //1
//        int[] nums = {1,3,5,6}; int target = 7; //4
//        int[] nums = {1,3,5,6,7,9,11,12,13}; int target = 2; //1
//        int[] nums = {1,3,5,6,7,9,11,12,13}; int target = 10; //6
        System.out.println(searchInsert(nums, target));
    }
    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        if (nums[start] >= target)
            return start;
        if (nums[end] == target)
            return end;
        if (nums[end] < target)
            return nums.length;
        int mid = 0;
        while (start <= end) {
            mid = start+(end-start)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return start;
    }
}
