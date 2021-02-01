import java.io.*;
import java.util.*;
/*
1.) Read data
2.) Rebuild string while checking for censored word occurances
 */
public class Main {
    static String word; static String censor;
    static int N; static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
        word = fin.readLine().trim(); censor = fin.readLine().trim(); N = word.length(); T = censor.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < N; i++) {
            res.append(word.charAt(i));
            if (res.length() > T && res.substring(res.length() - T).equals(censor)) {
                res.setLength(res.length()-T);
            }
        }
        System.out.println(res);
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
