import java.io.*;
import java.util.*;

public class Main {
    static int K; static int B; static int N;
    static int[] crosswalks;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("maxcross.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("maxcross.out"));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); K = toInt(st.nextToken()); B = toInt(st.nextToken());
        crosswalks = new int[N];
        for(int i = 0; i < B; i++){
            crosswalks[toInt(fin.readLine())-1] = 1;
        }

        int minSig = Integer.MAX_VALUE;
        int nSig = 0;
        for(int i = 0; i < K; i++){
            if(crosswalks[i] == 1){nSig++;}
        }
        for(int i = 0; i < N-K+1; i++){
            if(i == 0){minSig = nSig;continue;}
            if(crosswalks[i-1] == 1){nSig--;}
            if(crosswalks[i+K-1] == 1){nSig++;}
            minSig = Math.min(minSig, nSig);
        }
        fout.write(minSig + "\n"); fout.close();



        
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
