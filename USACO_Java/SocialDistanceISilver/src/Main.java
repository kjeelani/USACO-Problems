import java.io.*;
import java.util.*;

class Range{
    long s; long e;
    public Range(long s, long e){
        this.s = s; this.e = e;
    }
}

public class Main {
    static int N; static int M;
    static Range[] ranges;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("socdist.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("socdist.out"));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); M = toInt(st.nextToken());
        ranges = new Range[M];
        for(int i = 0; i < M; i++){st = new StringTokenizer(fin.readLine()); ranges[i] = new Range(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));}
        Arrays.sort(ranges, new Comparator<Range>() {
            @Override
            public int compare(Range o1, Range o2) {
                return o1.s > o2.s ? 1 : -1;
            }
        });

        long mn = 1; long mx = ranges[M-1].e; long md;
        while(mx - mn > 1){
            md = (mn+mx)/2;
            if(check(md)){mn = md;}
            else{mx = md - 1;}
        }
        if(check(mx)){fout.write(mx +"\n");}
        else{fout.write(mn + "\n");}
        fout.close();
    }

    private static boolean check(long D) {
        Queue<Range> rngQ = new LinkedList<Range>(Arrays.asList(ranges));
        long s = rngQ.peek().s;
        for(int i = 0; i < N-1; i++){
            s += D;
            while (!rngQ.isEmpty() && s > rngQ.peek().e){rngQ.poll();}
            if(rngQ.isEmpty()){return false;}
            if(rngQ.peek().s > s){s = rngQ.peek().s;}
        }
        return true;
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
