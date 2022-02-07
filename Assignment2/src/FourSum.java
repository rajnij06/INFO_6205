//https://leetcode.com/problems/4sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {
    public static void main (String[] args) {
        int[] nums = {1,0,-1,0,-2,2}; int target = 0; //[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//        int[] nums = {2,2,2,2,2}; int target = 8; //[[2,2,2,2]]
        System.out.println(fourSum(nums, target));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4)
            return new ArrayList();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length-3; i++) {
            if(i!=0 && nums[i] == nums[i-1])
                continue;
            for(int j=i+1; j<nums.length-2; j++) {
                if(j!=i+1 && nums[j] == nums[j-1])
                    continue;
                int k = j+1;
                int x = nums.length-1;
                while (k < x) {
                    int sum = nums[i]+nums[j]+nums[k]+nums[x];
                    if (sum == target) {
                        List<Integer> list= new ArrayList();
                        Collections.addAll(list, nums[i], nums[j], nums[k], nums[x]);
                        result.add(list);
                        while (k<x && nums[k] == nums[j+1])
                            k++;
                        while (k<x && nums[x] == nums[x-1])
                            x--;
                        k++; x--;
                    }
                    else if (sum < target)
                        k++;
                    else
                        x--;
                }
            }
        }
        return result;
    }
}
