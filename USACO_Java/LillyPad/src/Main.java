import java.io.*;
import java.util.*;

class Coord{
    int x; int y;
    public Coord(int x, int y){
        this.x = x; this.y = y;
    }
}

class Node{
    Coord d; int m;
    public Node(Coord data, int moves){
        this.d = data; this.m = moves;
    }
}

public class Main {
    static int N; static int M;
    static int D1; static int D2;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); M = toInt(st.nextToken());
        D1 = toInt(st.nextToken()); D2 = toInt(st.nextToken());

        int[][] pond = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Coord startPos = new Coord(0,0);
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(fin.readLine());
            for (int j = 0; j < M; j++) {
                pond[i][j] = toInt(st.nextToken());
                if(pond[i][j] == 3){startPos = new Coord(i, j);}
            }
        }

        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(new Node(startPos, 0));

        int[] move1 = new int[]{D1, D1, -D1, -D1, D2, D2, -D2, -D2};
        int[] move2 = new int[]{D2, -D2, D2, -D2, D1, -D1, D1, -D1};

        while (true){
            Node t = nodes.poll();
            if(visited[t.d.x][t.d.y]){continue;}
            if(pond[t.d.x][t.d.y] == 4){System.out.println(t.m); break;}
            visited[t.d.x][t.d.y] = true;
            for(int i = 0; i < 8; i++){
                int m1 = move1[i]; int m2 = move2[i];
                if(t.d.x + m1 < N && t.d.x + m1 >= 0 && t.d.y + m2 < M && t.d.y + m2 >= 0 && (pond[t.d.x + m1][t.d.y + m2] == 1 || pond[t.d.x + m1][t.d.y + m2] == 4)){
                    nodes.add(new Node(new Coord(t.d.x+m1,t.d.y+m2), t.m + 1));
                }
            }
        }
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
