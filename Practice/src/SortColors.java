import java.util.*;

public class SortColors {
    public static void main (String  args[]) {
        int[] arr = {1,2,4,5}; int k = 4, x = 3;
        System.out.println(findClosestElements(arr, k, x));
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> lst = new LinkedList<>();
        if (x < arr[0]) {
            for (int i=0; i<k; i++) {
                lst.add(arr[i]);
            }
        }
        else if (x > arr[arr.length-1]) {
            int y=arr.length-k;
            for (int i=y; i<arr.length; i++) {
                lst.add(arr[i]);
            }
        }
        int index = search(arr,0,arr.length-1, x);
        System.out.println(index);
        return lst;
    }
    public static int search (int[] r, int start, int end, int x) {
        int mid = (start+end)/2;
        if (r[mid] == x) return mid;
        else if (x < r[mid]) search(r,start,mid-1,x);
        else search(r,mid+1,r.length,x);
        return -1;
    }
}
