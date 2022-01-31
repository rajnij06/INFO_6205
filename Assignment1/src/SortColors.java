import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0}; //[0,0,1,1,2,2]
//        int[] nums = {2,0,1}; //[0,1,2]
        System.out.println(Arrays.toString(sortColors(nums)));
    }
    static int[] sortColors(int[] nums) {
        int i=0, start=0, end=nums.length-1;
        while (i <= end) {
            if (nums[i] == 0) {
                nums[i] = nums[start];
                nums[start] = 0;
                start++;
            }
            if (nums[i] == 2) {
                nums[i] = nums[end];
                nums[end] = 2;
                end--;
                i--;
            }
            i++;
        }
        return nums;
    }
}
