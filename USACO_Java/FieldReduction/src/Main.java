import java.io.*;
import java.util.*;
/*
1.) Create a Coord class read data into two ArrayLists sorted by xcoords and ycoords
2.) Find ylow, yhigh, xlow, xhigh
3.) Use a quad for loop for 3 possible point removes from 4 directions and check if it is a valid rectangle, and if it is, check if its area is the most minimized
 */

class Coord{
    int x; int y;
    public  Coord(int x, int y){
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

public class Main {
    static int N;
    static Coord[] xcoords; static Coord[] ycoords;


    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
        N = toInt(fin.readLine());

        xcoords = new Coord[N]; ycoords = new Coord[N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(fin.readLine());
            int x = toInt(st.nextToken());; int y = toInt(st.nextToken());
            Coord c = new Coord(x, y);
            xcoords[i] = c;
            ycoords[i] = c;
        }
        Arrays.sort(xcoords, new Comparator<Coord>() {
            @Override
            public int compare(Coord o1, Coord o2) {
                return o1.x - o2.x;
            }
        });
        Arrays.sort(ycoords, new Comparator<Coord>() {
            @Override
            public int compare(Coord o1, Coord o2) {
                return o1.y - o2.y;
            }
        });

        //Generating all Rectangles possible with removes
        int xlow = xcoords[0].x; int xhigh = xcoords[N-1].x;
        int ylow = ycoords[0].y; int yhigh = ycoords[N-1].y;
        long minArea = (xhigh-xlow) * (yhigh-ylow);
        for(int ylowremove = 0; ylowremove < 4; ylowremove++){
            for(int yhighremove = 0; yhighremove < 4; yhighremove++){
                for(int xlowremove = 0; xlowremove < 4; xlowremove++){
                    for(int xhighremove = 0; xhighremove < 4; xhighremove++){
                        if(CoordSet(xlowremove, xhighremove, ylowremove, yhighremove) != 3){continue;}
                        int width = xcoords[N-1-xhighremove].x - xcoords[xlowremove].x;
                        int height = ycoords[N-1-yhighremove].y - ycoords[ylowremove].y;
                        minArea = Math.min(minArea, width*height);
                    }
                }
            }
        }
        System.out.println(minArea);
        
    }

    private static int CoordSet(int xl, int xh, int yl, int yh) {
        Set<Coord> coordset = new HashSet<Coord>();
        for(int i = 0; i < xl; i++){coordset.add(xcoords[i]);}
        for(int i = N-1; i >= N-xh; i--){coordset.add(xcoords[i]);}
        for(int i = 0; i < yl; i++){coordset.add(ycoords[i]);}
        for(int i = N-1; i >= N-yh; i--){coordset.add(ycoords[i]);}
        return coordset.size();
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
