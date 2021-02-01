import java.io.*;
import java.util.*;

class Coord{
    int x; int y; boolean hasCow;
    public Coord(int x, int y){
        this.x = x;
        this.y = y;
        this.hasCow = false;
    }
}

public class Main {
    static int N; static int K; static int R;
    static HashMap<Coord, ArrayList<Coord>> coordmap = new HashMap<Coord, ArrayList<Coord>>();
    static Coord[][] coords;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("countcross.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("countcross.out"));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); K = toInt(st.nextToken()); R = toInt(st.nextToken());
        visited = new boolean[N][N];

        coords = new Coord[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                Coord c = new Coord(i,j);
                coordmap.put(c, new ArrayList<Coord>());
                coords[i][j] = c;
            }
        }

        //init roads and cows
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(fin.readLine());
            Coord c1 = new Coord(toInt(st.nextToken())-1, toInt(st.nextToken())-1);
            Coord c2 = new Coord(toInt(st.nextToken())-1, toInt(st.nextToken())-1);
            coordmap.get(coords[c1.x][c1.y]).add(coords[c2.x][c2.y]);
            coordmap.get(coords[c2.x][c2.y]).add(coords[c1.x][c1.y]);
        }
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(fin.readLine());
            Coord c = new Coord(toInt(st.nextToken())-1, toInt(st.nextToken())-1);
            coords[c.x][c.y].hasCow = true;
        }

        int totaldistpairs = 0; ArrayList<Integer> pairs = new ArrayList<Integer>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j]){continue;}
                int t = bfs(coords[i][j]);
                for(Integer p : pairs){totaldistpairs += t * p;}
                pairs.add(t);
            }
        }
        fout.write(totaldistpairs + "\n"); fout.close();


        
    }

    private static int bfs(Coord coord) {
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};
        Queue<Coord> coordQueue = new LinkedList<Coord>();
        coordQueue.add(coord);
        int ncows = 0;
        while(!coordQueue.isEmpty()){
            Coord c = coordQueue.poll();
            if(visited[c.x][c.y]){continue;}
            if(coords[c.x][c.y].hasCow){ncows++;}
            visited[c.x][c.y] = true;
            for(int i = 0; i < 4; i++){
                int fx = dx[i]; int fy = dy[i];
                if(c.x+fx < N && c.x+fx >= 0 && c.y+fy < N && c.y+fy >= 0){
                    if(!coordmap.get(coords[c.x][c.y]).contains(coords[c.x+fx][c.y+fy])){coordQueue.add(coords[c.x+fx][c.y+fy]);}
                }
            }
        }
        return ncows;
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
