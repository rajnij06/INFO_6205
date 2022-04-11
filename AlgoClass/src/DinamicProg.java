import java.util.HashMap;

public class DinamicProg {
    public static void main (String[] args) {
//        System.out.println(fibMemorization(4));
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(longestIncSub(arr));
    }
    public static long fibMemorization(int n) {
        if (n <= 1) return n;
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, 0L);
        map.put(1, 1L);
        return fibMemorizatn(map, n);
    }
    public static long fibMemorizatn(HashMap<Integer, Long> map, int n) {
        if (!map.containsKey(n)) {
            long val = fibMemorizatn(map, n-1) + fibMemorizatn(map, n-2);
            map.put(n, val);
        }
        return map.get(n);
    }
    public static int kadanesBF(int[] arr) {
        int maxSum = arr[0];
        for (int i=1; i<arr.length; i++) {
            for (int j=0; j<i; j++) {
                int sum = 0;
                for (int k=1; k<j; k++) {
                    sum += arr[k];
                }
                if (maxSum < sum) maxSum = sum;
            }
        }
        return maxSum;
    }
    public static int kadane(int[] arr) {
        int maxSum = arr[0];
        int sum = 0;
        int startI = 0, endI = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if (maxSum < sum) {
                maxSum = sum;
                endI = i;
            }
            if (sum < 0) {
                sum = 0;
                startI = i+1;
            }
        }
        System.out.println("Start Index : " + startI);
        System.out.println("End Index : " + endI);
        return maxSum;
    } //Done
    public static int longestIncSub(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        if (arr.length == 1) return 1;
        int[] lis = new int[arr.length];
        int[] index = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            lis[i] = 1;
            index[i] = 1;
        }
        int maxInd = 0, maxVal = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i] > arr[j]) { //there can be an increasing subsequence
                    if (lis[i] < lis[j+1]) {
                        lis[i] = lis[j] + 1;
                        index[i] = j;
                    }
                    if (maxVal < lis[i]) {
                        maxVal = lis[i];
                        maxInd = i;
                    }
                }
            }
        }
        return maxVal;
    }
}
