package Graph;

public class Main {
    public static void main (String[] args) {
        int[] arr = {2,4,6,8,10,14};
        System.out.println(binary(arr,0, arr.length - 1, 62));
    }

    public static int binary(int[] arr, int l, int r, int x) {
        if (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] > x) {
                return binary(arr, l, mid-1, x);
            } else {
                return binary(arr, mid+1, r, x);
            }
        }
        return -1;
    }
}
