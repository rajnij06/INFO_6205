import java.util.Arrays;

public class Jan29th {
}
public class Find {
    public static void main (String[] args) {
        int[] arr = {0,0,0,1,1,1,1,2,3,4};
//        System.out.println(findFirst(arr, 1));
    }
    //-------Find------------
    private static int findFirst(int[] arr, int x, int start, int end) {
        if(arr[start] > x || arr[end] < x) {
            return -1;
        }
        if(arr[start] == x) {
            return start;
        }
        int mid = (start + end)/2;
        if (arr[mid] == x) {
            return findFirst(arr, x, start, mid);
        }
        else if(arr[mid] < x) {
            return findFirst(arr, x, mid+1, end);
        }
        else {
            return findFirst(arr, x, start, mid-1);
        }
    }
    private static int findTotal(int[] arr, int x) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
//        int first = findFirst(arr, x);
        return 0; //remove
    }
    //-------Rotate------------
    private  static void reverse(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start >= end || start < 0 || end > arr.length-1 ) {
            return;
        }
        while (start < end) {
            int temp = arr[start];
            arr [start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    private static void rotateArray(int[] arr, int n) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        n = n % arr.length;
        reverse(arr, 0, arr.length-1);
        reverse(arr, 0, n-1);
        reverse(arr, n, arr.length-1);
    }
    private static int findRotatedIndex(int[] arr) {
        if(arr == null) {
            return -1;
        }
        if (arr.length == 1) {
            return 0;
        }
        return 0; //remove
    }
    private static int findRotatedIndex(int[] arr, int start, int end) {
        if (arr[0] < arr[arr.length-1]) {
            return -1;
        }
        //no duplicates
        if (arr[start] == arr[end]) {
            return start;
        }
        int mid = (start + end)/2;
        if (arr[mid] > arr[start]) {
            //left half is properly sorted
            return findRotatedIndex(arr, mid, end);
        }
        else {
            //right half is properly sorted
            return findRotatedIndex(arr, start, mid);
        }
    }
    private static int binarySearch(int[] arr, int x) {
        if (arr == null || arr.length == 0) {
            return  -1;
        }
        return binarySearch(arr, x, 0, arr.length-1);
    }
    private static int binarySearch(int[] arr, int x, int start, int end) {
        if (start > end) {
            return  -1;
        }
        int mid = (start + end)/2;
        if (arr[mid] == x) {
            return mid;
        }
        else if (arr[mid] < x) {
            return binarySearch(arr, x, mid+1, end);
        }
        return 0; //remove
//        else () {
//            return
//        }
    }
    private static int findIndexInSortedRotatedArray (int[] arr, int x) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return  arr[0] == x ? 0 : -1;
        }
        int index = findRotatedIndex(arr);
        //if the array was not rotated
        if (index == -1) {
            return binarySearch(arr, x);
        }
        //if rotated we'll look for edge cases
        if (arr[index] < x) {
            //largest val if smaller than x
            return -1;
        }
        if (arr[index+1] > x) {
            //smallest val if bigger than x
            return -1;
        }
        //se where should we look for the value
        if (x > arr[0]) {
            return binarySearch(arr, x, 0, index);
        }
        return binarySearch(arr,x,index+1,arr.length-1);
    }
    //sum
    private static int[] twoSum(int[] arr, int sum) {
        int[] result = new int[2];
        result[0] = Integer.MIN_VALUE;
        result[1] = Integer.MIN_VALUE;
        if(arr == null || arr.length <= 1) {
            return result;
        }
        Arrays.sort(arr);
        int start = 0, end = arr.length -1;
        while (start < end) {
            int total = arr[start] + arr[end];
            if (total == sum) {
                return result;
            }
            else if (total < sum) {
                start ++;
            } else {

            }
        }
        return result;
    }
    private static int[] threeValueSumEqualToX(int[] arr, int x) {
        int[] result = new int[3];
        Arrays.sort(arr);
        for(int i=0; i<arr.length-2; i++) {
            int[] values = twoSum(arr,(x-arr[i]));
            if (values[0] == Integer.MIN_VALUE) {
                continue;
            }
            result[0] = arr[i];
            result[1] = values[0];
            result[2] = values[1];
//            list.add(result);
        }


        return result;
    }
}
