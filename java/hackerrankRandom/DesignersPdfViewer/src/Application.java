import java.util.*;

/**
 * Created by muatik on 1/28/17.
 */
public class Application {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int heights[] = new int[26];

        for (int i = 0; i < heights.length; i++)
            heights[i] = scan.nextInt();

        String word = scan.next();

        int maxH = 0, h=0;
        for (int i = 0; i < word.length(); i++) {
            h = heights[((int)word.charAt(i)) - ((int) 'a')];
            if (h > maxH)
                maxH = h;
        }

        System.out.println(word.length() * maxH);
    }

}
