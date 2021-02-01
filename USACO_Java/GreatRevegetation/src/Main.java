
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Node{
    int p; char t;
    public Node(int p, char t){
        this.p = p;
        this.t = t;
    }

    @Override
    public String toString() {
        return "Node{" +
                "p=" + p +
                ", t=" + t +
                '}';
    }
}

class BoolN{
    boolean b; int color;
    public BoolN(){
        this.b = false;
        this.color = -1;
    }

    @Override
    public String toString() {
        return "BoolN{" +
                "b=" + b +
                ", color=" + color +
                '}';
    }
}

class FilledNode{
    int d; int color;
    public FilledNode(int p, int color){
        this.d = p; this.color = color;
    }

    @Override
    public String toString() {
        return "FilledNode{" +
                "d=" + d +
                ", color=" + color +
                '}';
    }
}

public class Main {
    static int N; static int C; static int ans;
    static HashMap<Integer, ArrayList<Node>> graph = new HashMap<>();
    static BoolN[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("revegetate.out"));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); C = toInt(st.nextToken());

        visited = new BoolN[N];
        for(int i = 0; i < N; i++){visited[i] = new BoolN();}

        for(int i = 0; i < N; i++){graph.put(i, new ArrayList<>());}
        for(int i = 0; i < C; i++){
            st = new StringTokenizer(fin.readLine());
            char type = st.nextToken().charAt(0);
            int n1 = toInt(st.nextToken())-1; int n2 = toInt(st.nextToken())-1;
            graph.get(n1).add(new Node(n2, type));
            graph.get(n2).add(new Node(n1, type));
        }
        for(int i = 0; i < N; i++){
            if(!visited[i].b && bfs(i)){
                ans += 2;
            }
        }
        fout.write(Integer.toBinaryString(ans) + "\n"); fout.close();
        
    }

    private static boolean bfs(int i) {
        Queue<FilledNode> nodes = new LinkedList<>();
        nodes.add(new FilledNode(i, 0));
        boolean isBad = false;
        while(!nodes.isEmpty()){
            FilledNode n = nodes.poll(); System.out.println(Arrays.toString(visited) + isBad);
            visited[n.d].b = true; visited[n.d].color = n.color;
            for(Node nn : graph.get(n.d)){
                if(nn.t == 'S'){
                    if(visited[nn.p].b){isBad = isBad || visited[nn.p].color == visited[n.d].color; continue;}
                    nodes.add(new FilledNode(nn.p, n.color));
                }
                else{
                    if(visited[nn.p].b){isBad = isBad || visited[nn.p].color != visited[n.d].color; continue;}
                    nodes.add(new FilledNode(nn.p, 1-n.color));
                }n
            }
        }
        return !isBad;
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
