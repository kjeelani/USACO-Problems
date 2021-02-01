import java.io.*;
import java.util.*;

/*
1.) Read data and buckets
2.) Implement BFS to find optimal paint route
    a.) Keep track of visited nodes
    b.) Return # moves if reached
    c.) If no nodes in queue, return -1
 */

class N{
    int data; int ntries;

    public N(int n, int m){
        this.ntries = m; this.data = n;
    }
}

public class Main {
    static int A; static int B; static int N; static int P;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        A = toInt(st.nextToken()); B = toInt(st.nextToken());
        st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); P = toInt(st.nextToken());
        st = new StringTokenizer(fin.readLine());
        int[] buckets = new int[N];
        for(int i = 0; i < N; i++){ buckets[i] = toInt(st.nextToken()); }

        Queue<N> nodes = new LinkedList<N>();
        nodes.add(new N(A, 0));
        boolean[] visited = new boolean[P+2];
        int c = 0;
        while (!nodes.isEmpty()){
            c++;
            N t = nodes.poll();
            if(visited[t.data]){continue;}
            visited[t.data] = true;
            if(t.data == B){System.out.println(t.ntries); break;}
            for(int i = 0; i < N; i++) {
                int res = t.data % P * buckets[i] % P;
                if (!visited[res]) {
                    nodes.add(new N(res, t.ntries + 1));
                }
            }
        }
        if(nodes.isEmpty()){
            System.out.println(-1);
        }
        
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
