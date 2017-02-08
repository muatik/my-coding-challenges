import java.util.HashSet;
import java.util.Set;

/**
 * Created by muatik on 2/8/17.
 */
public class Application {
    public static void main(String[] args) {
        System.out.println(isPermutation("ab c", "a bc"));
        System.out.println(isPermutation("ab c", "abc"));
        System.out.println(isPermutation("rar", "ar"));
        System.out.println(isPermutation("ar", "rar"));
        System.out.println(isPermutation("ar", "br"));
        System.out.println(isPermutation("br", "r"));
        System.out.println(isPermutation("br", "k"));
    }

    static boolean isPermutation(String a, String b) {
        // the algorithm uses extra space to store unique letters, O(n)
        Set<Character> ac = new HashSet<>();

        for (int i = 0; i < a.length(); i++) {
            ac.add(a.charAt(i));
        }

        int n = ac.size();
        for (int i = 0; i < b.length(); i++) {
            ac.add(b.charAt(i));
            if (ac.size() > n)
                return false;
        }

        return true;
    }

}
