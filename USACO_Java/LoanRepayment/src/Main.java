import java.io.*;
import java.util.*;

/*
1.) Read data
2.) Binary Search For X and simulate loan repayment
    a.) Cycle through loan payment until either K is exceeded (move X down)
    or loan is repaid (move X up)
*/

public class Main {
    static long N; static long K; static long M; static long c;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("loan.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("loan.out"));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); K = toInt(st.nextToken()); M = toInt(st.nextToken());

        long mn = 2; long mx = N-1; long md;
        while (mx - mn > 1){

            md = (mx+mn)/2;
            if(loanPaid(md)){mn = md;}
            else{mx = md-1;}
            //System.out.println(loanPaid(md) + " " + md + " " + mx + " " + mn);

        }
        if(loanPaid(mx)){fout.write(mx + "\n");} else{fout.write(mn + "\n");} fout.close();
        //System.out.println(c);

    }

    private static boolean loanPaid(long X) {
        long tempK = K; long G = 0;
        while (true){
            c += 1;
            if(G >= N){return true;}  if(tempK <= 0){return false;}
            tempK -= 1;
            long Y = (N-G)/X;
            if(Y > M){G += Y;}
            else{
                tempK -= (N-G)/M;
                return tempK >= 0;
            }
        }
    }

    private static long toInt(String x){
        return Long.parseLong(x);
    }
}
