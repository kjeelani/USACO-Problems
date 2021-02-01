import java.io.*;
import java.util.*;

class Coord{
    int x; int y;
    public Coord(int x, int y){
        this.x = x; this.y = y;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "x=" + x +
                ", y=" + y +
                '}';
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
    static char[][] field; static boolean[][] visited;
    static HashMap<Character, ArrayList<Coord>> portals = new HashMap<Character, ArrayList<Coord>>();

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); M = toInt(st.nextToken());

        field = new char[N][M]; visited = new boolean[N][M];
        Coord startCoord = new Coord(-1,-1);
        for(int i = 0; i < N; i++){
            field[i] = fin.readLine().trim().toCharArray();
            for (int j = 0; j < M; j++) {
                if(field[i][j] == '@'){startCoord = new Coord(i, j);}
            }
        }

        initPortals();

        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(new Node(startCoord, 0));
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        try {
            while (!nodes.isEmpty()) {
                Node t = nodes.poll();
                if (visited[t.d.x][t.d.y]) {
                    continue;
                }
                if (field[t.d.x][t.d.y] == '=') {
                    System.out.println(t.m);
                    break;
                }

                visited[t.d.x][t.d.y] = true;

                for (int i = 0; i < 4; i++) {
                    int fx = dx[i];
                    int fy = dy[i];

                    if (t.d.x + fx >= 0 && t.d.x + fx < N && t.d.y + fy >= 0 && t.d.y + fy < M && field[t.d.x + fx][t.d.y + fy] != '#') {
                        char nextChar = field[t.d.x + fx][t.d.y + fy];
                        if (!(nextChar == '.' || nextChar == '=' || nextChar == '@')) {
                            nodes.add(teleport(nextChar, new Coord(t.d.x + fx, t.d.y + fy), t.m));
                        } else {
                            nodes.add(new Node(new Coord(t.d.x + fx, t.d.y + fy), t.m + 1));
                        }
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println(-1);
        }


        
    }

    private static void initPortals() {
        for(char c : "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()){portals.put(c, new ArrayList<Coord>());}

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(portals.containsKey(field[i][j])){portals.get(field[i][j]).add(new Coord(i,j));}
            }
        }
    }

    private static Node teleport(char c, Coord n, int moves) {
        ArrayList<Coord> pair = portals.get(c);
        for(Coord t : pair){
            if(t.x != n.x || t.y != n.y){return new Node(t,moves + 1);}
        }
        return null;
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
