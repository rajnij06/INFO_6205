import java.util.*;

public class MajorityElementII {
    public static void main(String[] args) {
        Integer[] nums = {3,2,3}; //[3];
//        Integer[] nums = {1}; //[1];
//        Integer[] nums = {1,2}; //[1,2]
         System.out.println(majorityElement(nums));
    }
    public static List<Integer> majorityElement(Integer[] nums) {
        List<Integer> result = new LinkedList<>();
        if (nums.length/3 == 0) {
            for (int i: nums) {
                result.add(Integer.valueOf(i));
            }
            return result;
        }
        HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            if (data.containsKey(nums[i])) {
                data.replace(nums[i],data.get(nums[i])+1);
            }
            else {
                data.put(nums[i],1);
            }
            if (data.get(nums[i]) > nums.length/3) {
                result.add(nums[i]);
            }
        }
        return result;
    }
}
