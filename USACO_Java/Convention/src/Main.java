import java.io.*;
import java.util.*;

/*
1.)Read data
2.)Use binary search to see if M buses is enough if cows wait T minutes
    a.)If cows cannot wait T minutes, go up
    b.)If cows can wait T minutes, go down
    c.)For each binary search, iterate through the cows, simulate waiting times, see if # of buses is enough
 */

public class Main {
    static int N; static int M; static int C;
    static Integer[] cows;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("convention.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("convention.out"));

        StringTokenizer st = new StringTokenizer((fin.readLine())); StringTokenizer st2 = new StringTokenizer((fin.readLine()));
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        
        cows = new Integer[N];
        for(int i = 0; i < N; i++){
            cows[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(cows);
        
        int T = binarySort();
        fout.write(T + "\n");
        fout.close();
        
    }

    private static int binarySort() {
        int min = 1; int max = (int) Math.pow(10, 9); int mid = (min + max) / 2;
        while (true){
            if(max == min || max == min + 1 && simulation(min)){
                return min;
            }
            else if(max == min + 1){
                return max;
            }
            System.out.println(max + " " + mid + " " + min);
            if(simulation(mid)){max = mid;}
            else{min = mid + 1;}
            mid = (min + max) / 2;
        }
    }

    private static boolean simulation(int maxT) {
        int tempBus = 1;  int capacity = 0; int s = 0;
        for(int i = 0; i < N; i++){
            if(cows[i]-s > maxT || capacity == C){
                capacity = 0; tempBus++;
                if(i+1 != N){s = cows[i];}
            }
            capacity++;
            if(tempBus > M){
                return false;
            }
        }
        return true;
    }

}
