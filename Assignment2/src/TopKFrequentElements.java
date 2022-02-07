// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.*;

public class TopKFrequentElements {
    public static void main (String[] args) {
//        int[] nums = {1,1,1,2,2,4}; int k = 2; //[1,2]
//        int[] nums = {1,1,1,2,2,3,4,6,6,6,6,6,6,6,7,7,7,7}; int k = 2; //[6,7]
        int[] nums = {1}; int k = 1; //[1]
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
    private static Set<Integer> getKeys(Map<Integer, Integer> map, Integer value) {
        Set<Integer> resKey = new HashSet<>();
        if (map.containsValue(value)) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (Objects.equals(entry.getValue(), value)) {
                    resKey.add(entry.getKey());
                }
            }
        }
        return resKey;
    }
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums == null)
            return new int[0];
        int[] result = new int[k];
        Map<Integer,Integer> data = new HashMap<>();
        List<Integer> res = new ArrayList();
        for (int n=0; n<nums.length; n++) {
            if (data.containsKey(nums[n])) {
                data.put(nums[n], data.get(nums[n])+1);
            } else
                data.put(nums[n], 1);
        }
        for (int i : data.values()) {
            res.add(i);
        }
        Collections.sort(res);
        Collections.reverse(res);
        for (int i=0; i<k; i++) {
            int val = res.get(i);
            for (Integer key : getKeys(data, val)) {
                result[i] = key;
            }
        }
        return result;
    }
}
