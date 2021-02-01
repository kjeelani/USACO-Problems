import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

class Node {
    int d;
    int t;

    public Node(int x, int y) {
        this.t = x;
        this.d = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return t == node.t;
    }

    @Override
    public int hashCode() {
        return Objects.hash(t);
    }
}

public class Main {
    static int N;
    static Node[] nodes;
    static HashMap<Node, ArrayList<Node>> network = new HashMap<>();
    static int ans; static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("clocktree.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("clocktree.out"));
        N = toInt(fin.readLine()); nodes = new Node[N];
        StringTokenizer st = new StringTokenizer(fin.readLine());
        for(int i = 0; i < N; i++){
            nodes[i] = new Node(i, toInt(st.nextToken()));
            network.put(nodes[i], new ArrayList<>());
        }
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(fin.readLine());
            int n1 = toInt(st.nextToken()); int n2 = toInt(st.nextToken());
            network.get(nodes[n1-1]).add(nodes[n2-1]);
            network.get(nodes[n2-1]).add(nodes[n1-1]);
        }
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            int x = dfs(i, visited);
            //System.out.println(x);
            ans += x == 11 || x == 12 ? 1 : 0;
            visited = new boolean[N];
        }
        fout.write(ans + "\n"); fout.close();

    }

    private static int dfs(int n, boolean[] visited){
        int sum = nodes[n].d; visited[n] = true;
        ArrayList<Node> a = network.get(nodes[n]);
        if(a.size() == 1 && visited[a.get(0).t]){ return 12-nodes[n].d; }

        for(Node nn : network.get(nodes[n])){
            if(!visited[nn.t]){sum += dfs(nn.t, visited);}
        }
        return 12-sum%12;
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
