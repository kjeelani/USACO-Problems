import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N; static int M; static int K;
    static int[] pattern;
    static int[] finalAns;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("swap.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("swap.out"));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); M = toInt(st.nextToken()); K = toInt(st.nextToken());

        pattern = new int[N];
        for(int i = 0; i < N; i++){pattern[i] = i;}
        for(int i = 0; i < M; i++){reverse(new StringTokenizer(fin.readLine()));}
        finalAns = new int[N];
        for(int i = 0; i < N; i++){
            int curI = i; ArrayList<Integer> a = new ArrayList<>();
            do{
                a.add(curI);
                curI = pattern[curI];
            } while(curI != i);
            System.out.println(i);
            finalAns[i] = a.get(K%a.size());
        }
        for(Integer i : finalAns){fout.write(i+1 + "\n");} fout.close();

        
    }

    private static void reverse(StringTokenizer st) {
        for (int l = toInt(st.nextToken())-1, r = toInt(st.nextToken())-1; l < r; l++, r--) {
            int temp = pattern[l];
            pattern[l]  = pattern[r];
            pattern[r] = temp;
        }
        //System.out.println(Arrays.toString(pattern));
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
