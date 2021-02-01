import java.io.*;
import java.util.*;

/*
1.) Using N and the edges given, create adj map
2.) For each M given, do a BFS until either the prefered milk is found (1) or BFS ends (0)
 */

class Node {
    int d; char type; int id;

    public Node(int x, char type, int id) {
        this.d = x;
        this.type = type;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return d == node.d;
    }

    @Override
    public int hashCode() {
        return Objects.hash(d);
    }

}

public class Main {
    static int N; static int M;
    static HashMap<Node, ArrayList<Node>> network = new HashMap<>();
    static Node[] nodes; static boolean[] visited;
    static String ans = "";

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("milkvisits.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("milkvisits.out"));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); M = toInt(st.nextToken());

        char[] nodeNames = fin.readLine().trim().toCharArray();
        nodes = new Node[N]; visited = new boolean[N];
        for(int i = 0; i < N; i++){
            Node n = new Node(i, nodeNames[i], -1);
            network.put(n, new ArrayList<>());
            nodes[i] = n;
        }
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(fin.readLine());
            int p1 = toInt(st.nextToken())-1; int p2 = toInt(st.nextToken())-1;
            network.get(nodes[p1]).add(nodes[p2]); network.get(nodes[p2]).add(nodes[p1]);
        }

        int id = 1;
        for(int i = 0; i < N; i++){
            if(!visited[i]){dfs(i, id, nodes[i].type);}
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(fin.readLine());
            int s = toInt(st.nextToken())-1; int e = toInt(st.nextToken())-1;
            char c = st.nextToken().charAt(0);
            if(nodes[s].id != nodes[e].id || nodes[e].type == c){ans += "1";} else{ans += "0";}
        } fout.write(ans +"\n"); fout.close();
    }

    private static void dfs(int i, int id, char type) {
        if(visited[i]){return;} visited[i] = true;
        if(nodes[i].type != type){return;} nodes[i].id = id;
        for(Node nn : network.get(nodes[i])){
            dfs(nn.d, id, type);
        }
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
