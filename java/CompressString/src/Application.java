/**
 * Created by muatik on 2/9/17.
 */
public class Application {
    public static void main(String[] args) {
        System.out.println(compress("AAABBCCCRAKKMM"));
        System.out.println(compress("AB"));
        System.out.println(compress("ABB"));
        System.out.println(compress("A"));
        System.out.println(compress("BBBBKKKKKKKKK"));
    }

    private static String compress(String text) {
        StringBuilder compressed = new StringBuilder();
        int counter = 1;

        for (int i = 1; i < text.length(); i++) {

            if (text.charAt(i - 1) != text.charAt(i)) {
                compressed.append(text.charAt(i -1));
                if (counter > 1) {
                    compressed.append(counter);
                }
                counter = 1;
            } else
                counter++;
        }

        if (counter > 0) {
            compressed.append(text.charAt(text.length() - 1));
            if (counter > 1) {
                compressed.append(counter);
            }
        }

        return compressed.toString();
    }


}
