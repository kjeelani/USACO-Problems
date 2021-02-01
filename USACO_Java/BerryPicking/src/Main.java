import java.io.*;
import java.util.*;

/*
1.) Read data and sort it in ArrayList
2.) Find index to insert max(berries)/2 twice using upperbound if it is greater than berries[N-K/2]
3.) Once it is not, find the sum of bessie's share of berries
 */

public class Main {
    static int N; static int K;
    static ArrayList<Integer> berries = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("berries.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("berries.out"));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); K = toInt(st.nextToken());

        st = new StringTokenizer(fin.readLine());
        for(int i = 0; i < N; i++){berries.add(toInt(st.nextToken()));}
        Collections.sort(berries);

        while (true) {
            System.out.println(berries.toString());
            int mx = berries.get(berries.size()-1);
            if(N < K){
                for(int i = 0; i < 2; i++){
                    berries.add(lb(mx/2),mx/2); mx += 1;
                }
                berries.remove(N+1); N += 1; continue;
            }

            boolean br = true;
            for(int i = 0; i < 2; i++){
                if(mx/2 > berries.get(Math.max(0,N-K))){
                    berries.add(lb(mx/2),mx/2); br = false;
                } mx += 1;
            }
            if(!br){berries.remove(berries.size()-1); N += 1;}
            else{break;}
        }

        int sum = 0;
        for(int i = N-K; i < N-K/2; i++){
            sum += berries.get(i);
        }
        fout.write(sum + "\n"); fout.close();


    }

    private static int lb(int x) {
        int left = 0;
        int right = N;
        while (left < right) {
            int mid = (right + left) / 2;
            if (x <= berries.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }


}
