import java.io.*;
import java.util.*;
/*Not solved*/
class Piles{
    long a; long b;
    public Piles(long a, long b){
        this.a = a;
        this.b = b;
    }
}

public class Main {
    static int N;
    static Piles[] piles;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("teleport.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("teleport.out"));
        N = toInt(fin.readLine()); piles = new Piles[N];

        long mn = (long) Math.pow(10,8); long mx = (long) -Math.pow(10,8); long md = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            int a = toInt(st.nextToken()); int b = toInt(st.nextToken());
            mn = Math.min(b, Math.min(a, mn));
            mx = Math.max(b, Math.max(a, mn));
            piles[i] = new Piles(a, b);
        }
        mn -= 1; mx += 1;

        while(mx - mn > 1){
            md = (mx+mn)/2;
            String ans = isGood(md);
            if(ans.equals("inc")){mx = md;}
            else if(ans.equals("dec")){mn = md+1;}
            else{break;}
        }
        fout.write(check(md) + "\n"); fout.close();



    }

    private static String isGood(long md) {
        long bef = check(md-1); long is = check(md); long aft = check(md+1);
        System.out.println(md + " " + bef + " " + is + " " + aft);
        if(bef <= is && is <= aft){return "inc";}
        else if(aft <= is && is <= bef){return "dec";}
        else{return "is";}
    }

    private static long check(long Y) {
        long toReturn = 0;
        for(Piles p : piles){
            toReturn += Math.min(Math.min(Math.abs(p.a-p.b), Math.abs(p.a) + Math.abs(p.b - Y)), Math.abs(p.b) + Math.abs(p.a-Y));
        }
        return toReturn;
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
