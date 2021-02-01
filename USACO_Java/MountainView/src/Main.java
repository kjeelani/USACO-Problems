import java.io.*;
import java.util.*;

class Coord {
    int x;
    int y;
    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return x == coord.x &&
                y == coord.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Main {
    static int N;
    static HashSet<Coord> mountains = new HashSet<>();
    static Coord[] mA;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("mountains.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("mountains.out"));
        N = toInt(fin.readLine());

        mA = new Coord[N];
        Coord c;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            c = new Coord(toInt(st.nextToken()), toInt(st.nextToken()));
            mountains.add(c); mA[i] = c;
        }

        for(int i = 0; i < N; i++){
            if(!mountains.contains(mA[i])){continue;}
            for(int j = 0; j < N; j++){
                if(mA[i].x + mA[i].y > mA[j].x + mA[j].y &&
                mA[i].y-mA[i].x > mA[j].y-mA[j].x){mountains.remove(mA[j]);}
            }
        }
        fout.write(mountains.size() + "\n"); fout.close();
        
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
