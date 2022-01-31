import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5}; //3
//        int[] citations = {1,3,1}; //1
        System.out.println(hIndex(citations));
    }
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int result=0;
        for (int i=citations.length-1; i>=0; i--) {
            if (citations[i] <= result) {
                break;
            }
            result++;
        }
        return result;
    }
}
