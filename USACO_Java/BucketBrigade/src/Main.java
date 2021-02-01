import java.io.*;
import java.util.*;

class Coords{
    int x;
    int y;

    public Coords(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    private static final int N = 10;
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("buckets.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("buckets.out"));

        map = new char[N][N];
        for(int i = 0; i < N; i++){
            map[i] = fin.readLine().trim().toCharArray();
        }

        Coords lake = find('B');
        Coords barn = find('L');
        Coords rock = find('R');
        System.out.println(lake.x + " " + lake.y);
        System.out.println(barn.x + " " + barn.y);
        System.out.println(rock.x + " " + rock.y);

        int xdif = Math.abs(lake.x-barn.x); int ydif = Math.abs(lake.y-barn.y);
        boolean c1 = ydif == 0 && rock.x > Math.min(barn.x, lake.x) && rock.x < Math.max(lake.x, barn.x) && rock.y == barn.y;
        boolean c2 = xdif == 0 && rock.y > Math.min(barn.y, lake.y) && rock.y < Math.max(lake.y, barn.y) && rock.x == barn.x;


        if(c1 || c2){
            fout.write(xdif + ydif + 1 + "\n");
        }
        else {
            fout.write(xdif + ydif - 1 + "\n");
        }
        fout.close();
    }

    private static Coords find(char c) {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[j][i] == c){
                    return new Coords(i, j);
                }
            }
        }
        return new Coords(0,0);
    }

}
