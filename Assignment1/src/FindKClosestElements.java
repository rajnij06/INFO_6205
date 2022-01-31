import java.util.LinkedList;
import java.util.List;

public class FindKClosestElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5}; int k = 4, x = 3; //[1,2,3,4]
//        int[] arr = {1,2,3,4,5}; int k = 4, x = -1; //[1,2,3,4]
        System.out.println(findClosestElements(arr, k, x));
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new LinkedList<>();
        int i = 0;
        int len = arr.length - 1;
        while (len - i >= k) {
            if (Math.abs(arr[i] - x) > Math.abs(arr[len] - x)) {
                i++;
            } else {
                len--;
            }
        }
        for (int j=i; j <= len; j++) {
            result.add(arr[j]);
        }
        return result;
    }
}
