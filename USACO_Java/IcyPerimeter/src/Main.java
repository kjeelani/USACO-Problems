import java.io.*;
import java.util.*;

class Coord{
    int x; int y;
    public Coord(int x, int y){
        this.x = x; this.y = y;
    }
}

class Area{
    int area; int perimeter;
    public Area(int a, int p){this.area = a; this.perimeter = p;}

    public Area Compare(Area a){
        if(a.area == this.area){
            if(a.perimeter < this.perimeter){return a;} else{return this;}
        }
        else if(a.area > this.area){return a;} else{return this;}
    }
}

public class Main {
    static int N;
    static char[][] machine;
    static boolean[][] visited;
    static Area max = new Area(0,0);
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("perimeter.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("perimeter.out"));
        N = toInt(fin.readLine());
        machine = new char[N][N]; visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            machine[i] = fin.readLine().trim().toCharArray();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(machine[i][j] == '.'){continue;}
                Area a = new Area(0,0);
                dfs(new Coord(i,j), a);
                max = max.Compare(a);
            }
        }

        fout.write(max.area + " " + max.perimeter + "\n"); fout.close();
        
    }

    private static void dfs(Coord c, Area a) {
        if(visited[c.x][c.y]){return;}
        visited[c.x][c.y] = true; a.area++;
        for(int i = 0; i < 4; i++){
            int fx = dx[i]; int fy = dy[i];
            try{
                if(machine[c.x+fx][c.y+fy] == '.'){a.perimeter++;}
            }
            catch(Exception e){a.perimeter++;}
        }
        //System.out.println(c.x + " " + c.y + " " + a.area + " " + a.perimeter);

        for(int i = 0; i < 4; i++){
            int fx = dx[i]; int fy = dy[i];
            try{
                if(machine[c.x+fx][c.y+fy] == '#'){dfs(new Coord(c.x+fx, c.y+fy), a);}
            }
            catch(Exception e){}
        }
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
