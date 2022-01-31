import java.util.*;

public class SortArraybyIncreasingFrequency {
    public static void main(String[] args) {
//        int[] nums = {1,1,2,2,2,3}; //[3,1,1,2,2,2]
        int[] nums = {2,3,1,3,2}; //[1,3,3,2,2]
        System.out.println(Arrays.toString(frequencySort(nums)));
    }
    public static int[] frequencySort(int[] nums) {
        Map<Integer,Integer> sortMap = new HashMap<>();
        Integer[] num = new Integer[nums.length];
        for (int i=0; i<nums.length; i++) {
            num[i] = nums[i];
        }
        for (int i=0; i<nums.length; i++) {
            sortMap.put(nums[i],sortMap.getOrDefault(nums[i],0)+1);
        }
        Arrays.sort(num, (a,b) -> sortMap.get(a) == sortMap.get(b) ? b-a : sortMap.get(a)-sortMap.get(b));
        for (int i=0; i<nums.length; i++) {
            nums[i] = num[i];
        }
        return nums;
    }
}