import java.io.*;
import java.util.*;

/*
1.)Read Data
2.)Repeat until a cycle return 0 manipulations
    a.)Use a BFS and turn all K connected components to 0. Keep track of # of manipulations
    b.)Then, use another algorithm to pull down all of the tiles
    c.)Repeat
 */
class Coord{
    int x; int y;
    public Coord(int x, int y){
        this.x = x; this.y = y;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "x=" + this.x +
                ", y=" + this.y +
                '}';
    }
}

public class Main {
    static int N;
    static int K;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("mooyomooyo.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("mooyomooyo.out"));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());

        //read data
        board = new int[N][10]; visited = new boolean[N][10];
        for(int i = 0; i < N; i++){
            char[] t = fin.readLine().toCharArray();
            for(int j = 0; j < 10; j++){
                board[i][j] = Integer.parseInt(String.valueOf(t[j]));
            }
        }


        int manipulations = bfsAll();
        while(manipulations != 0){
            gravity();
            for(int k = 0; k < N; k++){
                System.out.println(Arrays.toString(board[k]));
            }
            manipulations = bfsAll();
        }

        for(int[] r : board){
            for(int c : r){
                fout.write(String.valueOf(c));
            }
            fout.write("\n");
        }
        fout.close();
    }

     private static void gravity() {
        for(int j = 0; j < 10; j++){
            if(board[N-1][j] == 0) {
                int offset = 0; boolean counting = true;
                for (int i = N - 1; i >= 0; i--) {
                    if(counting){if(board[i][j] == 0){offset++; continue;} else{counting = false;}}
                    board[i+offset][j] = board[i][j];
                    board[i][j] = 0 ;
                }
            }

        }
    }

    private static int bfsAll() {
        resetVisited();
        int m = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < 10; j++){
                if(board[i][j] == 0){continue;}
                if(bfs(new Coord(i, j))){m++;}
            }
        }
        return m;
    }

    private static boolean bfs(Coord start) {
        int id = board[start.x][start.y];
        Queue<Coord> tileQ = new LinkedList<Coord>(); tileQ.add(start); int size = 0;
        ArrayList<Coord> coords = new ArrayList<Coord>(); coords.add(start);
        int[] dx = new int[]{-1,1,0,0}; int[] dy = new int[]{0,0,-1,1};

        while (!tileQ.isEmpty()){
            Coord c = tileQ.poll();
            if(visited[c.x][c.y]){continue;}
            else{visited[c.x][c.y] = true; coords.add(c);}
            for(int i = 0; i < 4; i++){
                int x = dx[i]; int y = dy[i];
                if (c.x + x >= 0 && c.x + x < N && c.y + y >= 0 && c.y + y < 10){
                    if (board[c.x + x][c.y + y] == id) {
                        Coord newC = new Coord(c.x+x, c.y + y);
                        tileQ.add(newC); size++;
                    }
                }
            }
        }

        if(size >= K){
            for(Coord c : coords){
                board[c.x][c.y] = 0;
            }
            return true;
        }
        return false;
    }

    private static void resetVisited() {
        for(boolean[] r : visited){
            Arrays.fill(r, false);
        }
    }

}
