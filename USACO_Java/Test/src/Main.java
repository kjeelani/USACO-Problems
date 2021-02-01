/*
 * Activity 2.4.3
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println(w("Hello Worellod", "ello"));
    }

    private static String w(String base, String remove){
        boolean repeat = true;
        while (repeat) {
            repeat = false;
            for (int i = 0; i < base.length() - remove.length() + 1; i++) {
                if (base.toLowerCase().substring(i, i + remove.length()).equals(remove.toLowerCase())) {
                    base = base.substring(0, i) + base.substring(i + remove.length());
                    repeat = true;
                    break;
                }
            }
        }
        return base;
    }
}
