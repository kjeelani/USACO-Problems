import java.io.*;
import java.util.*;

class Cow{
    long stime; long etime;
    public Cow(long s, long e){
        this.stime = s; this.etime = e;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "stime=" + stime +
                ", etime=" + etime +
                '}';
    }
}

public class Main {
    static int N; static int C;
    static PriorityQueue<Long> chickens = new PriorityQueue<Long>();
    static PriorityQueue<Cow> cows = new PriorityQueue<Cow>(new Comparator<Cow>() {
        @Override
        public int compare(Cow o1, Cow o2) {
            if(o1.stime == o2.stime){return (int) (o1.etime-o2.etime);}
            else{return (int) (o1.stime - o2.stime);}
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("helpcross.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("helpcross.out"));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        C = toInt(st.nextToken()); N = toInt(st.nextToken());

        for(int i = 0; i < C; i++){chickens.add((long) toInt(fin.readLine()));}
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(fin.readLine());
            cows.add(new Cow((long) toInt(st.nextToken()), (long) toInt(st.nextToken())));
        }

        int pairs = 0; PriorityQueue<Cow> t = new PriorityQueue<Cow>(new Comparator<Cow>() {
            @Override
            public int compare(Cow o1, Cow o2) {
                if(o1.stime == o2.stime){return (int) (o1.etime-o2.etime);}
                else{return (int) (o1.stime - o2.stime);}
            }
        });
        while(!chickens.isEmpty() && !cows.isEmpty()){
            if(chickens.peek() < cows.peek().stime){chickens.poll(); continue;}
            else if(chickens.peek() > cows.peek().etime){cows.poll(); continue;}

            while(!cows.isEmpty() && chickens.peek() >= cows.peek().stime){t.add(cows.poll());}
            t.poll(); chickens.poll(); pairs++;
            while(!t.isEmpty()){cows.add(t.poll());}
        }
        fout.write(pairs + "\n"); fout.close();
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
