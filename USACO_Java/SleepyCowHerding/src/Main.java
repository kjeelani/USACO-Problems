import java.io.*;
import java.util.*;

/*
1.) Read data and use prefix sum to find the distance between the gaps of cows (i.e cow 2 and 5 have a gap of 2)
2.) The maximum is just the sum of all the elements in the prefix sum
3.) To find the minimum

 */
public class Main {
    static int N;
    static int[] cows; static int[] distances;
    static int max = 0; static int min = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
        N = toInt(fin.readLine());
        cows = new int[N];
        for(int i = 0; i < N; i++){
            cows[i] = toInt(fin.readLine());
        }
        Arrays.sort(cows);
        max = Math.max(cows[N-2] - cows[0], cows[N-1] - cows[1]) - (N-2);
        if(cows[N-2] - cows[0] == N-2 && cows[N-1] - cows[N-2] > 2){min = 2;}
        else{
            int j = 0; int best = 0;
            for(int i = 0; i < N; i++){
                while(j < N-1 && cows[j+1] - cows[i] < N){
                    j++;
                }
                best = Math.max(best, j-i+1);
            }
            min = N-best;
        }

        System.out.println(min + "\n" + max);



        
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
