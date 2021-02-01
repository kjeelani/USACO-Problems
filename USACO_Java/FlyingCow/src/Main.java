import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

/*
1.) Create BFS algorithm that tries options 3*i, n+1, and n-1
    a.) Keeps track of number of tries each Node has been through
    b.) When a node reaches N, return the value of tries
 */

class KNode{
    int data;
    int ntries;

    public KNode(int n, int m){
        this.data = n;
        this.ntries = m;
    }
}

public class Main {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        N = toInt(fin.readLine());

        Queue<KNode> nodes = new LinkedList<KNode>();
        boolean[] visited = new boolean[N+2];
        nodes.add(new KNode(1,0));
        int c = 0;
        while (true){
            c++;
            KNode t = nodes.poll();
            if(t.data == N){
                System.out.println(t.ntries);
                break;
            }
            if(t.data < N+2 && t.data >= 1 && !visited[t.data]) {
                visited[t.data] = true;
                nodes.add(new KNode(t.data * 3, t.ntries + 1));
                nodes.add(new KNode(t.data + 1, t.ntries + 1));
                nodes.add(new KNode(t.data - 1, t.ntries + 1));
            }


        }


        
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
