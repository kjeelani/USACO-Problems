import java.io.*;
import java.util.*;

class Milker{
    int buckets; int cost;
    public Milker(int buckets, int cost){
        this.buckets = buckets; this.cost = cost;
    }
}

public class Main {
    static int N; static int M; static int R;
    static long[] prefixM; static long[] prefixR;
    static Long[] rentals; static PriorityQueue<Long> cows = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Milker> milkoffers = new PriorityQueue<>(new Comparator<Milker>() {
        @Override
        public int compare(Milker o1, Milker o2) {
            return o2.cost -o1.cost;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("rental.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("rental.out"));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); M = toInt(st.nextToken()); R = toInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            cows.add((long) toInt(fin.readLine()));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(fin.readLine());
            milkoffers.add(new Milker(toInt(st.nextToken()), toInt(st.nextToken())));
        }

        prefixM = new long[N+1]; prefixM[0] = 0;
        for(int i = 1; i < N+1; i++){
            long temp = cows.poll(); long mx = 0;
            while (!milkoffers.isEmpty()){
                Milker m = milkoffers.peek();
                if(m.buckets < temp){mx += m.buckets * m.cost; temp -= m.buckets; milkoffers.poll();}
                else{mx += temp * m.cost; m.buckets -= temp; break;}
            }
            prefixM[i] = mx + prefixM[i-1];
        }

        rentals = new Long[R];
        for (int i = 0; i < R; i++) {
            rentals[i] =  (long) toInt(fin.readLine());
        }
        Arrays.sort(rentals, Collections.reverseOrder()); prefixR = new long[N+1]; prefixR[0] = 0;
        for(int i = 1; i < N+1; i++){
            if(i > rentals.length){prefixR[i] = prefixR[i-1];}
            else{prefixR[i] = rentals[i-1] + prefixR[i-1];}
        }

        long maxmoney = 0;
        for(int i = 0; i < N+1; i++){
            maxmoney = Math.max(maxmoney, prefixR[i] + prefixM[N-i]);
        }
        fout.write(maxmoney + "\n"); fout.close();
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
