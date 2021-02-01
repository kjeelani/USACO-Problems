import java.io.*;
import java.util.*;

/*
1.) Init data
2.) Create a prefix sum and stack of indices and iterate backwards
    a.) For each iteration backwards, compare n to arr[top of stack]
    b.) If greater, remove it and continue, if less, stop and sum up all numbers from a[i] to a[top of stack] and add i to stack
3.) Sum up prefix sum at the end
 */

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        N = toInt(fin.readLine());
        int[] cows = new int[N]; long[] prefix = new long[N]; Stack<Integer> highcows = new Stack<Integer>();
        for (int i = 0; i < N; i++) {cows[i] = toInt(fin.readLine());}

        for(int i = N-1; i >= 0; i--){
            while(true){
                if(highcows.isEmpty()){prefix[i] = (N-1)-i; highcows.add(i); break;}
                if(cows[highcows.peek()] >= cows[i]){prefix[i] = highcows.peek()-1-i; highcows.add(i); break;}
                else{highcows.pop();}
            }
        }
        System.out.println(Arrays.stream(prefix).sum());
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
