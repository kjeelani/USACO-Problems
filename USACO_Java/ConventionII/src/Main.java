import java.io.*;
import java.util.*;

import jdk.internal.jline.internal.InputStreamReader;

class Cow{
    int I; int T; int S;

    public Cow(int I, int T, int S){
        this.I = I; this.T = T; this.S = S;
    }

    public static Comparator<Cow> SeniorityCompare = new Comparator<Cow>() {
        public int compare(Cow c1, Cow c2) {
            return c1.S - c2.S;
        }
    };

    public static Comparator<Cow> InitTimeCompare = new Comparator<Cow>() {
        public int compare(Cow c1, Cow c2) {
            return c1.I - c2.I;
        }
    };
}



public class Main {
    static int N; static int current_time = 0; static int max_wait = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(fin.readLine());
        ArrayList<Cow> tempcowlist = new ArrayList<Cow>();
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(fin.readLine());
            tempcowlist.add(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
        }
        Collections.sort(tempcowlist, Cow.InitTimeCompare);

        Queue<Cow> cowQueue = new LinkedList<Cow>(tempcowlist);
        Queue<Cow> waitingQueue = new PriorityQueue<Cow>(Cow.SeniorityCompare);

        while (true){
            if(cowQueue.isEmpty()){
                break;
            }

            while (true){
                if(cowQueue.peek() == null){break;}
                if(cowQueue.peek().I < current_time){waitingQueue.add(cowQueue.poll());}
                else{break;}
            }

            Cow currentCow;
            if(waitingQueue.isEmpty()){currentCow = cowQueue.poll(); current_time = currentCow.I;}
            else{
                currentCow = waitingQueue.poll(); int wait = current_time - currentCow.I;
                if(wait > max_wait){max_wait = wait;}
            }

            current_time += currentCow.T;
        }

    }

}
