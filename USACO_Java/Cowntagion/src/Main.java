import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

/*
1.) Create a graph and a global counter
2.) Perform a DFS
    a.) At each stage, increment counter by 1 if moving, but if there are not enough cows at that Node, double max capacity
    and increase c by 1
3.) Return ans
*/

public class Main {
    static int N;
    static HashMap<Integer, ArrayList<Integer>> network = new HashMap<>();
    static int[] sickcows;
    static boolean[] visited; static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        N = toInt(f.readLine());

        sickcows = new int[N]; visited = new boolean[N];
        for(int i = 0; i < N; i++){network.put(i, new ArrayList<>());}
        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n1 = toInt(st.nextToken())-1; int n2 = toInt(st.nextToken())-1;
            network.get(n1).add(n2); network.get(n2).add(n1);
        }
        sickcows[0] = 1;

        dfs(0);
        System.out.println(ans);
        
    }

    private static void dfs(int node) {
        visited[node] = true;
        int cowsSent = 0;
        for(Integer n : network.get(node)){
            if(!visited[n]){
                dfs(n);
                ans++;
                cowsSent++;
            }
        }
        ans += Math.max(Math.log(cowsSent)/Math.log(2)+1, 0);
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
