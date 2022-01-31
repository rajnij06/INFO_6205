public class ReorganizeString {
    public static void main(String[] args) {
//        String s = "aab"; //"aba"
        String s = "aaab"; //""
        System.out.println(reorganizeString(s));
    }
    public static String reorganizeString(String s) {
        char[] result = new char[s.length()];
        int[] fullArray = new int[26];
        char[] charArray = s.toCharArray();
        for (int i=0; i<charArray.length; i++) {
            fullArray[charArray[i] - 'a']++;
        }
        int x=0;
        int ch =0;
        for (int i=0; i<26; i++) {
            if(fullArray[i] > x) {
                x = fullArray[i];
                ch = i;
            }
        }
        if (x > (s.length()+1)/2) {
            return "";
        }
        int y = 0;
        while (fullArray[ch] > 0) {
            result[y] = (char)(ch+'a');
            y =  y+2;
            fullArray[ch]--;
        }
        for (int j=0; j<26; j++) {
            while (fullArray[j] > 0) {
                if (y >= s.length()) {
                    y=1;
                }
                result[y] = (char)(j+'a');
                y= y+2;
                fullArray[j]--;
            }
        }
        return String.valueOf(result);
    }
}
