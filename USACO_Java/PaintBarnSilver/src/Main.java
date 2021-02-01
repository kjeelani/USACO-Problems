import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

/*
NOT FINISHED
 */

public class Main {
    static int N; static int K;
    static int[] xarr = new int[1001]; static int[] yarr = new int[1001];
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("_.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("_.out"));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); K = toInt(st.nextToken());

        HashSet<Integer> txvals = new HashSet<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(fin.readLine());
            int x1 = toInt(st.nextToken()); int y1 = toInt(st.nextToken());
            int x2 = toInt(st.nextToken()); int y2 = toInt(st.nextToken());

            for(int j = x1; j < x2; j++){xarr[j]++;}
            for(int j = y1; j < y2; j++){yarr[j]++;}
            System.out.println(Arrays.toString(xarr));
        }
        for(int i = 0; i < 1001; i++){
            for(int j = 0; j < 1001; j++){
                if(Math.min(xarr[i], yarr[j]) == K){ans++;}
            }
        }
        System.out.println(ans + "\n");
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
