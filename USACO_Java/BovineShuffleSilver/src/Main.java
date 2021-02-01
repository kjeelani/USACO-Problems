import java.io.*;
import java.util.*;
/*
1.) Read data
2.) For each shuffle,
 */
class Node{
    int dat; int freq;
    public Node(int d, int f){
        this.dat = d; this.freq = f;
    }
}

public class Main {
    static int N;
    static Node[] cows; static int[] shuffle; static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
        N = toInt(fin.readLine());
        cows = new Node[N]; shuffle = new int[N]; visited = new boolean[N]; ans = N;
        StringTokenizer st = new StringTokenizer(fin.readLine());
        for(int i = 0; i < N; i++){
            cows[i] = new Node(i, 0);
            shuffle[i] = toInt(st.nextToken())-1;
        }
        for(int i = 0; i < N; i++){
            cows[shuffle[i]].freq++;
        }
        for (int i = 0; i < N; i++) {
            cycle(i);
        }
        System.out.println(ans);
    }

    private static void cycle(int i) {
        if(cows[i].freq == 0 && !visited[i]){
            visited[i] = true;
            ans--;
            while(true){
                i = cows[shuffle[i]].dat;
                cows[i].freq--;
                if(cows[i].freq == 0 && !visited[i]){
                    visited[i] = true;
                    ans--;
                }
                else{
                    break;
                }
            }
        }
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
