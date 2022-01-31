import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}, nums2 = {2,2}; //[2]
//        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4}; //[9,4]
        System.out.println(Arrays.toString(intersection((nums1), nums2)));
    }
    public static Integer[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hset = new HashSet<>();
        for (int element : nums1) {
            hset.add(element);
        }
        ArrayList<Integer> res = new ArrayList<>();
        int i=0;
        while (i< nums2.length) {
            if (hset.contains(nums2[i]))
                if (!res.contains(nums2[i]))
                    res.add(nums2[i]);
            i++;
        }
        Integer[] result = res.toArray(new Integer[0]);
        return result;
    }
}
