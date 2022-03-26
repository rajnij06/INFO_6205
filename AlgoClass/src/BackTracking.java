import java.util.Arrays;

public class BackTracking {
    public static void main (String[] args) {
//        generateBinarySearch(2);
//        generateTernerySearch(3);
//        generateMarraySearch(2,3);
//        generateCombination(3,"abc");
    }
//-------------------Binary-------------------
    private  static void generateBinarySearch(int size) {
        if (size < 0) return;
        int[] result = new int[size];
        for (int i=0; i< result.length; i++)
            result[i] = -1;
        int curr = 0;
        generateBinarySearch(result, curr);
    }
    private static void generateBinarySearch(int[] result, int curr) {
        if (curr == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i=0; i<2; i++) {
            result[curr] = i;
            generateBinarySearch(result,curr+1);
        }
    }
//-------------------Ternery-------------------
    private  static void generateTernerySearch(int size) {
        if (size < 0) return;
        int[] result = new int[size];
        for (int i=0; i< result.length; i++)
            result[i] = -1;
        int curr = 0;
        generateTernerySearch(result, curr);
    }
    private static void generateTernerySearch(int[] result, int curr) {
        if (curr == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i=0; i<3; i++) {
            result[curr] = i;
            generateTernerySearch(result,curr+1);
        }
    }
//-------------------Ternery-------------------
    private  static void generateMarraySearch(int size, int m) {
        if (size < 0) return;
        int[] result = new int[size];
        for (int i=0; i< result.length; i++)
            result[i] = -1;
        int curr = 0;
        generateMarraySearch(result, curr, m);
    }
    private static void generateMarraySearch(int[] result, int curr, int m) {
        if (curr == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i=0; i<m; i++) {
            result[curr] = i;
            generateMarraySearch(result,curr+1, m);
        }
    }
//------------marray-----------------
    private static void generateCombination(int size, String str) {
        if (str == null || str.length() == 0 || size <= 0)
            return;
        int[] result = new int[size];
        int curr = 0; combinations(str, result, 0); }
    private static void combinations(String str,
         int[] result, int curr) {
        if (curr == result.length)  {
            printCombination(str,result);
            return; }
        for (int i=0; i<str.length(); i++) {
            result[curr] = i;
            combinations(str, result, curr+1); }}
    private static void printCombination(String str, int[] result) {
        for (int i=0; i<result.length; i++) {
            System.out.print(str.charAt(result[i]) + ", ");
        } System.out.println(); }
//-----------------subset------------------------
    private static void generateAllSubset(String str, int[] res, int curr) {
        if (curr== str.length()) {
            printSubset(str, res);
            return;
        }
        for (int i=0; i<2; i++) {
            res[curr] = i;
            generateAllSubset(str, res, curr+1);
        }
    }
    private static void printSubset(String str, int[] res) {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (int i=0; i< res.length; i++) {
            if (res[i] == 1) sb.append(str.charAt(i) + ", ");
        }
        int ind = sb.toString().lastIndexOf(',');
        if (ind != -1)
            sb.delete(sb.lastIndexOf(","), sb.length()-1);
        sb.append(" }");
        System.out.println(sb.toString());
    }
//------------------combTotal----------------
    private static void numberofWays(int[] coins, int tot) {
        if (coins == null || coins.length == 0 || tot <= 0) return;
        int[] res = new int[coins.length];
        int curr = 0;
        numberofWays(coins, tot, res, curr);
    }
    private static void numberofWays(int[] coin, int tot, int[] res, int curr) {
        if (curr == res.length) {
            printSubsetequltoTotal(coin, tot, res);
            return;
        }
        for (int i=0; i<2; i++) {
            res[curr] = i;
            numberofWays(coin, tot, res, curr+1);
        }
    }
    private static void printSubsetequltoTotal(int[] coin, int tot, int[] res) {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        int sum = 0;
        for (int i=0; i< res.length; i++) {
            if (res[i] == 1) {
                sb.append(coin[i] + ", ");
                sum += coin[i];
            }
        }
        int ind = sb.toString().lastIndexOf(',');
        if (ind != -1)
            sb.delete(sb.lastIndexOf(","), sb.length()-1);
        sb.append(" }");
        if (sum == tot)
            System.out.println(sb.toString());
    }
    private static void printPermutation(String str) {
        int[] res = new int[str.length()];
        int curr = 0;
        printPermutation(str, res, curr);
    }
    private static void printPermutation(String str, int[] res, int curr) {
        if (res.length == curr) {
            //print
            return;
        }
        for (int i=0; i < str.length(); i++) {
            if(isValid(res, curr, i)) {
                curr = res[i];
            }
            res[curr] = i;
            printPermutation(str, res, curr+1);
        }
    }
    private static boolean isValid(int[] res, int curr, int numToAdd) {
        for (int i=0; i< curr; i++) {
            if (res[i] == numToAdd) return false;
        }
        return true;
    }
}
