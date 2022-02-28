import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SumSub {
    public static void main (String args[]) {
        String  s = "Hello how are you Contestant"; int k = 4;
        System.out.println(truncateSentence(s, k));
    }
    public static String truncateSentence(String s, int k) {
        String[] str = s.split(" ");
        String[] arr = new String[k];
        for (int i=0; i<k; i++) {
            arr[i] = str[i];
        }
        String ans = Arrays.toString(arr);
        ans = ans.replace("[","").replace("]","").replace(",","");
        return ans;
    }
}