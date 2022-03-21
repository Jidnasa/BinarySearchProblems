import java.util.Collections;
import java.util.HashMap;

public class FrequentSubstring {
    public static void main(String[] args) {
       String s = "abccddce";
        int minLength=2;
        int maxLength=4;
        int maxUnique=2;
        HashMap<String, Integer> count = new HashMap<>();
        int left = 0, right = left + minLength, tmp = left;
        HashMap<Character, Integer> uniq = new HashMap<>();
        while (right <= s.length()) {
            while (tmp < right) {
                char c = s.charAt(tmp);
                uniq.put(c, uniq.getOrDefault(c, 0) + 1);
                tmp++;
            }
            String str = s.substring(left, right);    // extract the word from the long string and store as 1 substring
            if (uniq.size() <= maxUnique)
                count.put(str, count.getOrDefault(str, 0) + 1);
            char c = s.charAt(left);
            uniq.put(c, uniq.get(c) - 1);   // to slide the window towards right by deleting the prev blocks -1;
            if (uniq.get(c) == 0) {
                uniq.remove(c);
            }
            left++;
            right++;
        }
        /*if (count.size() == 0) {
            return 0;
        }*/
        System.out.println(count);
        System.out.println(uniq);
         System.out.println(Collections.max(count.values()));
    }
}
