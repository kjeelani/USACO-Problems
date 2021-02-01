import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] hwk; static double[] prefix;

    public static void main(String[] args) throws IOException {
        //BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fin = new BufferedReader(new FileReader("homework.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("homework.out"));

        N = toInt(fin.readLine());
        hwk = new int[N]; prefix = new double[N-1]; int min = 1000000;
        StringTokenizer st = new StringTokenizer(fin.readLine());
        for(int i = 0; i < N; i++){
            hwk[i] = toInt(st.nextToken());
        }

        for(int i = N-2; i >= 0; i--){
            if(i == N-2){min = Math.min(hwk[N-1], hwk[N-2]); prefix[N-2] = Math.max(hwk[N-1], hwk[N-2]); continue;}
            double average = prefix[i+1]*(N-2-i) + min + hwk[i];
            min = Math.min(min, hwk[i]); prefix[i] = (average - min) / (N-1-i);
        }
        //System.out.println(Arrays.toString(prefix));

        double max = 0; ArrayList<Integer> Kvals = new ArrayList<Integer>();
        for(int i = 0; i < N-1; i++){
            //System.out.println(max + " " + prefix[i]);
            if(max == prefix[i]){Kvals.add(i);}
            if(max < prefix[i]){Kvals.clear(); Kvals.add(i); max = prefix[i];}
        }
        for(Integer i : Kvals){fout.write(i + "\n");}  fout.close();
        
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
