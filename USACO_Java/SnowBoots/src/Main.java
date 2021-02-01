
import java.io.*;
import java.util.*;

class Boots{
    int d; int s;
    public Boots(int d, int s){
        this.d = d; this.s = s;
    }
}

class Node{
    int bi; int ti; int steps;
    public Node(int bi, int ti, int steps){
        this.bi = bi; this.ti = ti; this.steps = steps;
    }
}

public class Main {
    static int N; static int B;
    static int[] tiles;
    static Boots[] boots;
    static int minBoots;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("snowboots.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("snowboots.out"));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); B = toInt(st.nextToken()); minBoots = B-1; visited = new boolean[N][B];

        st = new StringTokenizer(fin.readLine());
        tiles = new int[N];
        for(int i = 0; i < N; i++){tiles[i] = toInt(st.nextToken());}

        boots = new Boots[B];
        for(int i = 0; i < B; i++){
            st = new StringTokenizer(fin.readLine());
            boots[i] = new Boots(toInt(st.nextToken()), toInt(st.nextToken()));
        }

        dfs(new Node(0,0,0));
        fout.write(minBoots + "\n"); fout.close();

    }

    private static void dfs(Node n) {
        if(visited[n.ti][n.bi]){return;}
        visited[n.ti][n.bi] = true;
        if(n.ti == N-1){System.out.println(n.steps);minBoots = Math.min(minBoots, n.steps); return;}

        for(int i = Math.min(n.ti+boots[n.bi].s,N-1); i > n.ti; i--){
            if(boots[n.bi].d >= tiles[i]){dfs(new Node(n.bi, i, n.steps));}
        }
        if(n.bi < B-1 && boots[n.bi+1].d >= tiles[n.ti]){dfs(new Node(n.bi+1, n.ti, n.steps+1));}

    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
