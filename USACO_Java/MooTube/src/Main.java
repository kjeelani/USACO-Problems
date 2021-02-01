

import java.io.*;
import java.util.*;

/*
1.) Read data and create weighted adjacency list with the nodes (via hashmap)
2.) For each query, do a BFS on the node specified with the relevance
    a.) The BFS can only continue if the relevance of the edge is lower than the given K
    b.) Return the length of the set of videos that were searched
 */

class Edge{
    int d; int r;
    public Edge(int d, int r){
        this.d = d; this.r = r;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "d=" + d +
                ", r=" + r +
                '}';
    }
}

public class Main {
    static int N; static int Q;
    static HashMap<Integer, ArrayList<Edge>> network = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("mootube.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("mootube.out"));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); Q = toInt(st.nextToken());
        for(int i = 0; i < N; i++){
            network.put(i, new ArrayList<Edge>());
        }
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(fin.readLine());
            int n1 = toInt(st.nextToken())-1; int n2 = toInt(st.nextToken())-1; int k = toInt(st.nextToken());
            network.get(n1).add(new Edge(n2, k));
            network.get(n2).add(new Edge(n1, k));
        }


        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(fin.readLine());
            fout.write(bfs(toInt(st.nextToken()), toInt(st.nextToken())-1) + "\n");
        } fout.close();
        
    }

    private static int bfs(int K, int V) {
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(V);
        boolean[] visited = new boolean[N+1]; int toReturn = -1;
        while(!nodes.isEmpty()){
            Integer v = nodes.poll();
            if(visited[v]){continue;}
            visited[v] = true; toReturn += 1;
            for(Edge e : network.get(v)){
                if(e.r >= K){nodes.add(e.d);}
            }
        }
        return toReturn;
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
