import java.util.HashSet;

/**
 * Created by muatik on 2/8/17.
 */
public class Application {
    public static void main(String[] args) {
        String[] texts = new String[]{"elma", "arma", "", "sark", "ss"};

        for (int i = 0; i < texts.length; i++) {
            System.out.println(texts[i] + " is unique: " + isUnique_1(texts[i]));
        }

        System.out.println("");

        for (int i = 0; i < texts.length; i++) {
            System.out.println(texts[i] + " is unique: " + isUnique_1(texts[i]));
        }
    }

    static boolean isUnique_1(String text) {
        // in place, without extra space need algorithm, O( n^2 / 2)
        for (int i = 0; i < text.length() - 1; i++)
            for (int j = i + 1; j < text.length(); j++)
                if (text.charAt(i) == text.charAt(j))
                    return false;
        return true;
    }

    static boolean isUnique_2(String text) {
        // needs extra space to store unique letters, O(n)
        HashSet<Character> letters = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            letters.add(text.charAt(i));
        }
        return letters.size() == text.length();
    }
}
