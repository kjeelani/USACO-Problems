import java.io.*;
import java.util.*;

class Coord{
    int x; int y;
    public Coord(int x, int y){
        this.x = x; this.y = y;
    }
}

class Line{
    int x1; int y1; int x2; int y2;
    public Line(int x1, int y1, int x2, int y2){
        this.x1 = x1; this.x2 = x2;
        this.y1 = y1; this.y2 = y2;
    }

    @Override
    public String toString() {
        return "Line{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }
}

public class Main {
    static int N; static char[] instructions;
    static ArrayList<Line> lines = new ArrayList<Line>();
    static int maxX; static int minX; static int maxY; static int minY;
    static int[][] matrix; static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
        N = toInt(fin.readLine()); instructions = fin.readLine().trim().toCharArray();

        maxX = 0; maxY = 0;
        minX = 0; minY = 0;
        int curX = 0; int curY = 0;
        for(char c : instructions){
            int prevX = curX; int prevY = curY;
            if(c == 'N'){curY++; maxY = Math.max(curY, maxY);}
            if(c == 'S'){curY--; minY = Math.min(curY, minY);}
            if(c == 'E'){curX++; maxX = Math.max(curX, maxX);}
            if(c == 'W'){curX--; minX = Math.min(curX, minX);}
            lines.add(new Line(prevX, prevY, curX, curY));
        }

        maxX -= minX; maxY -= minY;
        for(Line l : lines){
            l.x1 -= minX; l.x2 -= minX;
            l.y1 -= minY; l.y2 -= minY;
        }
        minX = 0; minY = 0;


        matrix = new int[maxX*2+10][maxY*2+10]; visited = new boolean[maxX*2+10][maxY*2+10];
        for(Line l: lines){
            //System.out.println(l);
            //for(int[] x : matrix){System.out.println(Arrays.toString(x));} System.out.println();
            if(l.y1 == l.y2) {
                for (int i = Math.min(l.x1, l.x2) * 2; i <= Math.max(l.x1, l.x2) * 2; i++) {
                    matrix[i+5][l.y1*2+5] = 1;
                }
            }
            else {
                for (int i = Math.min(l.y1, l.y2) * 2; i <= Math.max(l.y1, l.y2) * 2; i++) {
                    matrix[l.x1*2+5][i+5] = 1;
                }
            }
        }

        int gates = 0;
        for(int i = 0; i < maxX*2+10; i++){
            for(int j = 0; j < maxY*2+10; j++){
                if(!visited[i][j] && matrix[i][j] != 1){bfs(new Coord(i, j)); gates++;}
            }
        }
        //for(boolean[] x : visited){System.out.println(Arrays.toString(x));} System.out.println();
        System.out.println(gates-1);

        
    }

    private static void bfs(Coord coord) {
        Queue<Coord> coords = new LinkedList<Coord>();
        coords.add(coord);
        int[] moves = new int[]{-1,0,1};
        while(!coords.isEmpty()){
            Coord c = coords.poll();
            if(visited[c.x][c.y]){continue;}
            visited[c.x][c.y] = true;
            for(int fx : moves){
                for(int fy : moves){
                    if(fx == 0 && fy == 0){continue;}
                    if(c.x + fx <= maxX*2+9 && c.x + fx >= 0 && c.y + fy <= maxY*2+9 && c.y + fy >= 0 && matrix[c.x+fx][c.y+fy] != 1){
                        coords.add(new Coord(c.x+fx, c.y+fy));
                    }
                }
            }
        }
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
