/**
 * Created by muatik on 2/8/17.
 */
public class Application {

    public static void main(String[] args) {
        System.out.println(isRotated("foobarbaz", "barbazfoo"));
        System.out.println(isRotated("abc", "bca"));
        System.out.println(isRotated("abc", "cab"));
        System.out.println(isRotated("abc", "car"));
    }

    private static boolean isRotated(String a, String b) {
        return (b+b).contains(a);
    }
}
