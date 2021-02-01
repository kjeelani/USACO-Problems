import java.io.*;
import java.util.*;

/*
1.) Read all lines and store them in a list of pair of coords, as well as adding each coord to an ALL COORDS list
2.) Store cow coords in a cow list as well as the ALL COORDS list
3.) Map ALL COORDS to their compressed coords
4.) Create all lines on precreated matrix and also place cows
5.) Floodfill to obtain the answer
 */

class Coord{
    int x; int y;
    public Coord(int x, int y){
        this.x = x; this.y = y;
    }
}

public class Main {
    static int F; static int C;
    static HashSet<Integer> allCoordsX = new HashSet<Integer>(); static HashSet<Integer> allCoordsY = new HashSet<Integer>();
    static Coord[][] lineSegments; static Coord[] cows;
    static HashMap<Integer, Integer> compressionX = new HashMap<Integer, Integer>();
    static HashMap<Integer, Integer> compressionY = new HashMap<Integer, Integer>();
    static int[][] matrix; static boolean[][] visited;



    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        F = toInt(st.nextToken()); C = toInt(st.nextToken());

        lineSegments = new Coord[F][2];
        for(int i = 0; i < F; i++){
            st = new StringTokenizer(fin.readLine());
            int x1 = toInt(st.nextToken()); int y1 = toInt(st.nextToken()); int x2 = toInt(st.nextToken()); int y2 = toInt(st.nextToken());
            allCoordsX.add(x1); allCoordsX.add(x2); allCoordsY.add(y1); allCoordsY.add(y2);
            lineSegments[i][0] = new Coord(x1, y1); lineSegments[i][1] = new Coord(x2, y2);
        }

        cows = new Coord[C];
        for(int i = 0; i < C; i++){
            st = new StringTokenizer(fin.readLine());
            int x1 = toInt(st.nextToken()); int y1 =toInt(st.nextToken());
            allCoordsX.add(x1); allCoordsY.add(y1);
            cows[i] = new Coord(x1, y1);
        }

        ArrayList<Integer> newAllCoordsX = new ArrayList<Integer>(allCoordsX); ArrayList<Integer> newAllCoordsY = new ArrayList<Integer>(allCoordsY);
        Collections.sort(newAllCoordsX); Collections.sort(newAllCoordsY);
        int c = 0;
        for(Integer i : newAllCoordsX){compressionX.put(i, c);c+=2;}
        c = 0;
        for(Integer i : newAllCoordsY){compressionY.put(i, c);c+=2;}

        matrix = new int[newAllCoordsX.size()*2][newAllCoordsY.size()*2];
        visited = new boolean[newAllCoordsX.size()*2][newAllCoordsY.size()*2];

        for(Coord[] line : lineSegments){
            line[0].x = compressionX.get(line[0].x); line[1].x = compressionX.get(line[1].x);
            line[0].y = compressionY.get(line[0].y); line[1].y = compressionY.get(line[1].y);
            if(line[0].y == line[1].y){
                for(int i = Math.min(line[0].x, line[1].x); i <= Math.max(line[0].x, line[1].x); i++){matrix[i][line[0].y] = 1;}
            }
            else{
                for(int i = Math.min(line[0].y, line[1].y); i <= Math.max(line[0].y, line[1].y); i++){matrix[line[0].x][i] = 1;}
            }
        }

        for(Coord co : cows){matrix[compressionX.get(co.x)][compressionY.get(co.y)] = 2;}

        int maxcows = 0;
        for(int i = 0; i < newAllCoordsX.size()*2; i++){
            for (int j = 0; j < newAllCoordsY.size()*2; j++) {
                if(!visited[i][j] && matrix[i][j] != 1){maxcows = Math.max(maxcows, bfs(new Coord(i,j)));}
            }
        }
        System.out.println(maxcows);

    }

    private static int bfs(Coord fc) {
        Queue<Coord> coords = new LinkedList<Coord>();
        coords.add(fc);
        int count = 0;
        int[] d = new int[]{-1, 0, 1};
        while(!coords.isEmpty()){
            Coord c = coords.poll();
            if(visited[c.x][c.y]){continue;}
            visited[c.x][c.y] = true;
            if(matrix[c.x][c.y] == 2){count++;}
            for(int fx: d){
                for(int fy : d){
                    if(fy == 0 && fx == 0){continue;}
                    if(0 <= c.x + fx && c.x + fx < allCoordsX.size()*2 && 0 <= c.y + fy && c.y + fy < allCoordsY.size()*2 && matrix[c.x][c.y] != 1){
                        coords.add(new Coord(c.x + fx, c.y + fy));
                    }
                }
            }
        }
        return count;
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
