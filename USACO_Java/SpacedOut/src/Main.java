

import org.w3c.dom.Node;

import java.io.*;
import java.util.*;



public class Main {
    static int N;
    static int[][] matrix;
    static ArrayList<Node> matrixSummed = new ArrayList<>();
    static boolean[][] marked;
    static int maxBeauty;

    static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node{
        ArrayList<Coord> cl; int s; int marked;
        public Node(ArrayList<Coord> cl, int s){
            this.cl = cl; this.s = s; this.marked = 0;
            cl.sort(new Comparator<Coord>() {
                @Override
                public int compare(Coord o1, Coord o2) {
                    return matrix[o2.x][o2.y] - matrix[o1.x][o1.y];
                }
            });
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        N = toInt(f.readLine()); matrix = new int[N][N]; marked = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = toInt(st.nextToken());
            }
        }

        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < N-1; j++){
                matrixSummed.add(new Node(
                        new ArrayList<Coord>(Arrays.asList(new Coord(i,j), new Coord(i+1,j), new Coord(i, j+1), new Coord(i+1, j+1)))
                        , matrix[i][j] + matrix[i + 1][j] + matrix[i][j + 1] + matrix[i + 1][j + 1]
                ));
            }
        }
        Collections.sort(matrixSummed, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.s-o1.s;
            }
        });

        for(Node n : matrixSummed){
            int good = 0;
            for(Coord c : n.cl){
                if(marked[c.x][c.y]){good += 1; continue;}
                if(!marked[c.x][c.y] && safe(c)){marked[c.x][c.y] = true; good += 1; maxBeauty += matrix[c.x][c.y];}
            }
        }
        for(boolean[] b : marked){System.out.println(Arrays.toString(b)); }
        System.out.println(maxBeauty + "\n");

        

        
    }

    private static boolean safe(Coord c) {
        int c1 = fN(!marked[c.x][Math.min(N-1,c.y+1)],!marked[Math.min(N-1,c.x+1)][c.y],!marked[Math.min(N-1,c.x+1)][Math.min(N-1,c.y+1)]);
        int c2 = fN(!marked[c.x][Math.max(0,c.y-1)], !marked[Math.min(N-1,c.x+1)][c.y], !marked[Math.min(N-1,c.x+1)][Math.max(0,c.y-1)]);
        int c3 = fN(!marked[c.x][Math.min(N-1,c.y+1)],!marked[Math.max(0,c.x-1)][c.y] ,!marked[Math.max(0,c.x-1)][Math.min(N-1,c.y+1)]);
        int c4 = fN(!marked[c.x][Math.max(0,c.y-1)],!marked[Math.max(0,c.x-1)][c.y],!marked[Math.max(0,c.x-1)][Math.max(0,c.y-1)]);
        return c1 >= 2 && c2 >= 2 && c3 >= 2 && c4 >= 2;
    }

    private static int fN(boolean b, boolean b1, boolean b2) {
        int c = 0;
        if(b){c++;} if(b1){c++;} if(b2){c++;}
        return c;
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
