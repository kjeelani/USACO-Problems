import java.io.*;
import java.math.BigInteger;
import java.util.*;

/*
1.) Read data
2.) Use a reverse prefix sum to keep track of the max amount of tastiness throughout the hike
3.) Simulate Bessie going to the max tastiness spot until Farmer John catches up and add this amount to total
    a.) From that position, find the index of the new max and repeat step 3 until the end is reached
4.) Output total
 */

class Spots{
    int t; int l;
    public Spots(int l, int t){
        this.l = l;
        this.t = t;
    }
}

public class Main {
    static long Frate; static long Brate; static int L; static int N;
    static int[] maxprefix; static Spots[] food;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        L = toInt(st.nextToken()); N = toInt(st.nextToken()); Frate = toInt(st.nextToken()); Brate = toInt(st.nextToken());

        maxprefix = new int[N]; food = new Spots[N];
        for(int i = 0; i < N; i++){st = new StringTokenizer(fin.readLine()); food[i] = new Spots(toInt(st.nextToken()), toInt(st.nextToken()));}
        Arrays.sort(food, new Comparator<Spots>() {
            @Override
            public int compare(Spots o1, Spots o2) {
                return o1.l - o2.l;
            }
        });

        //init prefix
        int maxIndex = N-1;
        for(int i = N-1; i >= 0; i--){
            if(food[maxIndex].t < food[i].t){maxIndex = i;}
            maxprefix[i] = maxIndex;
        }
        //simulate movements
        int pos = 0; int nextstop = 0; long maxfood = 0;
        while (nextstop != N){
            Spots cur_stop = food[maxprefix[nextstop]];
            long Btime = Brate * (long) (cur_stop.l - pos); long Ftime = Frate * (long) (cur_stop.l - pos);
            maxfood += (Ftime - Btime) * (long) cur_stop.t;
            pos = cur_stop.l;
            nextstop = maxprefix[nextstop] + 1;
        }
        System.out.println(maxfood);
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
