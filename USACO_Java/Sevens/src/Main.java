import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] cows;
    static long[] prefix;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
        N = toInt(fin.readLine()); cows = new long[N]; prefix = new long[N];
        for(int i = 0; i < N; i++){
            cows[i] = (long) toInt(fin.readLine());
            if(i == 0){prefix[i] = cows[i];}
            else{prefix[i] = prefix[i-1] + cows[i];}
        }
        for(int i = N; i >= 0; i--){
            if(i == 0 || sevens(i)){System.out.println(i+1);break;}
        }
    }

    private static boolean sevens(int windowSize) {
        for(int i = 0; i < N-windowSize-1; i++){
            if((prefix[i+windowSize-1]-prefix[i]) % 7 == 0){return true;}
        }
        return false;
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
