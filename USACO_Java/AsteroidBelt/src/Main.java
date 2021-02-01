import java.io.*;
import java.util.*;
/*
1.) Read data
2.) Loop through all vertices
    a.) If not visited by another BFS, and if it is an asteroid chunk, BFS the entire area and incrmeent nasteroids
 */

class Coord{
    int x; int y;
    public Coord(int x, int y){
        this.x = x; this.y = y;
    }
}

public class Main {
    static int N; static int nasteroids = 0;
    static boolean[][] visited; static char[][] belt;


    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
        N = toInt(fin.readLine());
        belt = new char[N][N]; visited = new boolean[N][N];
        for(int i = 0; i < N; i++){belt[i] = fin.readLine().strip().toCharArray();}

        for(int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                if(belt[i][j] == '*' && !visited[i][j]){nasteroids++; bfs(new Coord(i,j));}
            }
        }
        System.out.println(nasteroids);
        
    }

    private static void bfs(Coord fc) {
        Queue<Coord> coords = new LinkedList<Coord>();
        coords.add(fc);

        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        while(!coords.isEmpty()) {
            Coord c = coords.poll();
            if (belt[c.x][c.y] == '.' || visited[c.x][c.y]) {continue;}
            visited[c.x][c.y] = true;
            for(int i = 0; i < 4; i++){
                int fx = dx[i]; int fy = dy[i];
                if(c.x + fx >= 0 && c.x + fx < N && c.y + fy >= 0 && c.y + fy < N){
                    coords.add(new Coord(c.x+fx, c.y+fy));
                }
            }
        }
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
