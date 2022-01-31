import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    public static void main(String[] args) {
        int[] arr = {3,2,4,1};
//        int[] arr = {1,2,3}; //[]
        System.out.println(pancakeSort(arr));
    }
    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int i=arr.length-1; i>0; i--) {
            if (i+1!=arr[i]) {
                int j=0;
                int k=i-1;
                while (arr[k]!=i+1) {
                    k--;
                }
                if (k-j>0) {
                    result.add(k-j+1);
                }
                while (j<k) {
                    swap(arr,k--,j++);
                }
                j=0;
                k=i;
                result.add(k-j+1);
                while(j<k) {
                    swap(arr,k--,j++);
                }
            }
        }
        return result;
    }
    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
