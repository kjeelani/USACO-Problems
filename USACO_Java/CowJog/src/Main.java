import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] cows;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
        N = (int) toInt(fin.readLine());
        cows = new long[N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(fin.readLine());
            st.nextToken();
            cows[i] = toInt(st.nextToken());
        }
        long min = 1000000000; int groups = 0; int lastCow = 0;
        for(int i = N-1; i >= 0; i--){
            if(min >= cows[i]){groups++; min = cows[i];}
        }
        System.out.println(groups);
    }

    private static long toInt(String x){
        return Long.parseLong(x);
    }
}
