import java.io.*;
import java.util.*;
/*
1.) Read data
2.) Do a BFS to find the largest connected component of a single cow
3.) Do a BFS that will only work for a pair of two cows and return maximum
NOT COMPLETE
 */

class Node{
    int x; int y; int d; int d2; int m;
    public Node(int x, int y, int d, int m){
        this.d = d; this.m = m; this.x = x;  this.y = y; this.d2 = -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x &&
                y == node.y &&
                (d2 == -1 || node.d2 == -1 || d2 == node.d2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, d2);
    }
}

public class Main {
    static int N;
    static int[][] game;
    static int maxSing = 0;
    static int maxDoub = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("_.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("_.out"));
        N = toInt(fin.readLine());

        game = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(fin.readLine());
            for (int j = 0; j < N; j++) {
                game[i][j] = toInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                bfs(new Node(i,j,game[i][j], 1));
            }
        }
        fout.write(maxSing + "\n" + maxDoub + "\n"); fout.close();



        
    }

    private static void bfs(Node node) {
        Queue<Node> nodes = new LinkedList<>(); nodes.add(node);
        HashMap<Node, Boolean> isThere = new HashMap<>();
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};
        while(!nodes.isEmpty()){
            System.out.println(nodes.toString());
            Node n = nodes.poll();
            if(isThere.containsKey(n)){continue;}
            isThere.put(n, true);
            for(int i = 0; i < 4 ; i++){
                int fx = dx[i]; int fy = dy[i];
                try{
                    if(game[n.x+fx][n.y+fy] != n.d){
                        if(n.d2 == -1){
                            Node newn = new Node(n.x+fx, n.y + fy, n.d, n.m+1);
                            newn.d2 = game[n.x+fx][n.y+fy]; nodes.add(newn);
                            maxSing = Math.max(n.m, maxSing);
                        }
                        else{maxDoub = Math.max(n.m, maxDoub);}
                    }
                    else{nodes.add(new Node(n.x+fx, n.y + fy, n.d, n.m+1));}
                }
                catch (Exception ignored){}
            }
        }
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
