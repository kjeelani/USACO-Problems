import java.io.*;
import java.util.*;

/*
1.) Read data, locate starting point, mark nmirrors as -1
2.) Perform BFS
    a.) For each point, increase nmirrors by 1 and iterate all 4 directions marking mirros + 1
    c.) Repeat until end is reached
 */
class Coord{
    int x; int y;
    public Coord(int x, int y){
        this.x = x; this.y = y;
    }
}

class Node{
    Coord d; int m;
    public Node(Coord d, int m){
        this.d = d; this.m = m;
    }
}

public class Main {
    static int N; static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        M = toInt(st.nextToken()); N = toInt(st.nextToken());

        Coord startCoord = new Coord(0,0);
        char[][] area = new char[N][M];
        for(int i = 0; i < N; i++){
            area[i] = fin.readLine().trim().toCharArray();
            for(int j = 0; j < M; j++){
                if(area[i][j] == 'C'){
                    startCoord = new Coord(i,j);
                }
            }
        }
        boolean[][] visited = new boolean[N][M];


        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(new Node(startCoord, -1));
        while(true){
            Node t = nodes.poll();
            visited[t.d.x][t.d.y] = true;
            if( area[t.d.x][t.d.y] == 'C' && t.m != -1){System.out.println(t.m);break;}
            for(int i = 1; i < N; i++){
                if(t.d.x + i >= N || area[t.d.x+i][t.d.y] == '*'){break;}
                if(visited[t.d.x+i][t.d.y]){break;}
                nodes.add(new Node(new Coord(t.d.x+i, t.d.y), t.m+1));
            }
            for(int i = 1; i < N; i++){
                if(t.d.x - i < 0 || area[t.d.x - i][t.d.y] == '*'){break;}
                if(visited[t.d.x - i][t.d.y]){break;}
                nodes.add(new Node(new Coord(t.d.x - i, t.d.y), t.m+1));
            }
            for(int i = 1; i < M; i++){
                if(t.d.y + i >= M || area[t.d.x][t.d.y+i] == '*'){break;}
                if(visited[t.d.x][t.d.y+i]){break;}
                nodes.add(new Node(new Coord(t.d.x, t.d.y+i), t.m+1));
            }
            for(int i = 1; i < M; i++){
                if(t.d.y - i < 0 || area[t.d.x][t.d.y-i] == '*'){break;}
                if(visited[t.d.x][t.d.y-i]){break;}
                nodes.add(new Node(new Coord(t.d.x, t.d.y-i), t.m+1));
            }
        }

        
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
