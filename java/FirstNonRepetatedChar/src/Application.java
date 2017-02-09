/**
 * Created by muatik on 2/9/17.
 */
public class Application {
    public static void main(String[] args) {
        System.out.println(findFirstNonRepeatedChar("AABBCDDK"));
        System.out.println(findFirstNonRepeatedChar("AABBCCDDK"));
    }

    private static String findFirstNonRepeatedChar(String text) {
        int counter = 1 ;
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i - 1) != text.charAt(i)) {
                if (counter == 1)
                    return String.valueOf(text.charAt(i-1));
                counter = 1;
            } else
                counter++;
        }

        if (counter == 1)
            return String.valueOf(text.charAt(text.length() -1));

        return "";
    }
}
