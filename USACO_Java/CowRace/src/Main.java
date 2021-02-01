import java.io.*;
import java.util.*;

/*
1.) Read data
2.) Simulate each time tick and check for any updates in leaderboard positions
    a.) If a new speed is needed for either cow, pop it from the queue
 */

class Times{
    int speed; int time;
    public Times(int s, int t){
        this.speed = s; this.time = t;
    }
}

public class Main {
    static int N; static int M;
    static Queue<Times> bessie = new LinkedList<Times>(); static Queue<Times> elsie = new LinkedList<Times>();
    static int ans = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); M = toInt(st.nextToken());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(fin.readLine());
            bessie.add(new Times(toInt(st.nextToken()), toInt(st.nextToken())));
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(fin.readLine());
            elsie.add(new Times(toInt(st.nextToken()), toInt(st.nextToken())));
        }
        long bessiedist = 0; long elsiedist = 0;
        Times curBessieTime = bessie.poll(); Times curElsieTime = elsie.poll();
        Boolean isElsieAhead = null;
        while (true){
            try {
                //System.out.println(elsiedist + " " + bessiedist + " " + ans);
                curBessieTime.time--; curElsieTime.time--;
                bessiedist += curBessieTime.speed; elsiedist += curElsieTime.speed;
                if(isElsieAhead == null && bessiedist != elsiedist){isElsieAhead = elsiedist > bessiedist;}
                if(bessiedist != elsiedist){
                    if(elsiedist > bessiedist != isElsieAhead){ans++;}
                    isElsieAhead = elsiedist > bessiedist;
                }
                if (curBessieTime.time == 0) {
                    curBessieTime = bessie.poll();
                }
                if (curElsieTime.time == 0) {
                    curElsieTime = elsie.poll();
                }
            }
            catch (Exception e){
                break;
            }
        }
        System.out.println(ans);
        
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
