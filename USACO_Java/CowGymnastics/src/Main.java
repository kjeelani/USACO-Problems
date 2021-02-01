import java.io.*;
import java.util.*;

public class Main {
    private static int N; private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("gymnastics.out"));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); K = toInt(st.nextToken());
        ArrayList<ArrayList<Integer>> cows = new ArrayList<ArrayList<Integer>> ();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(fin.readLine());
            ArrayList<Integer> t = new ArrayList<Integer>();
            for(int j = 0; j < K; j++){
                t.add(toInt(st.nextToken()));
            }
            cows.add(t);
        }


        int pairs = 0;
        for(int i = 0; i < K; i++){
            for(int j = 0; j < K; j++){
                if(i == j){continue;}
                boolean isGood = true;
                for(int k = 0; k < N; k++){
                    if(cows.get(k).indexOf(i+1) > cows.get(k).indexOf(j+1)){isGood = false; break;}
                }
                if(isGood){pairs++;}
            }
        }

        fout.write(pairs + "\n"); fout.close();

        
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
