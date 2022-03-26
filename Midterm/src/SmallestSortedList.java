// Question 1

import java.util.ArrayList;

public class SmallestSortedList {
    public static void main(String args[]) {
//        int[] nums = {0, 1, 3, 50, 75};
//        int lower = 0, upper = 99;
        int[] nums = {-1};
        int lower =-1, upper = -1;
        ArrayList<String> res;
        res = findMissingRanges(nums, lower, upper);
        //printing result stored in res named arraylist
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + ", ");
        }
    }
    public static ArrayList<String> findMissingRanges(int[] nums, int low, int up) {
        ArrayList<String> resFunc = new ArrayList<String>();
        int cur = low;
        // iterating whole input array
        for (int i = 0; i < nums.length; i++) {
            if(low == Integer.MAX_VALUE) return resFunc; // no need to process if lower is max possible integer value
            if (nums[i] < cur) {
                continue; // continue looping with 2nd element of array since array element is less than the range
            }
            if (nums[i] == cur) {
                cur++;
                continue; // incrementing cur value since array value matches the lower range
            }
            resFunc.add(getArrayRange(cur, nums[i] - 1)); // adding current lower and upper range to result arraylist
            if(nums[i] == Integer.MAX_VALUE) return resFunc; // no need to process if array value is max
            cur = nums[i] + 1;
        }
        if (cur <= up) {
            resFunc.add(getArrayRange(cur, up));
        }
        return resFunc;
    }
    // get the range of array
    public static String getArrayRange(int n1, int n2) {
        if (n1 == n2) {
            return String.valueOf(n1);
        } else {
            return String.format("%d->%d" , n1, n2);
        }
    }
}

