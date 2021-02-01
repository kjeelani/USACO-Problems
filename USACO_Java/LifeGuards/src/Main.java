import java.io.*;
import java.util.*;

class Point{
    int d; int t; int id;
    public Point(int d, int t, int id){
        this.d = d; this.t = t; this.id = id;
    }
}

class Freq{
    int freq; int timeAlone;
    public Freq(int f, int t){
        this.freq = f; this.timeAlone = t;
    }
}

/*
1.) Read data and create endpoints for intervals
2.) Loop through endpoints keeping track of total time as well as layers
    a.) Store a hashmap {id:Pair(freq, timeAlone)}, add keys when a start node is found, and remove keys when
    a delete node is found and keep track of max(timeAlone)
3.) Return totaltime - max(timeAlone)
 */

public class Main {
    static int N;
    static Point[] points;
    static TreeMap<Integer, Freq> curPoints = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("lifeguards.out"));
        N = toInt(fin.readLine()); points = new Point[2*N];
        for(int i = 0; i < 2*N; i += 2){
            StringTokenizer st = new StringTokenizer(fin.readLine());
            points[i] = new Point(toInt(st.nextToken()), 0, i);
            points[i+1] = new Point(toInt(st.nextToken()), 1, i);
        }
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.d - o2.d;
            }
        });

        int layers = 0; int totaltime = 0; int prev = 0; int maxTimeAlone = Integer.MAX_VALUE;
        for(int i = 0; i < 2*N; i++) {
            if (layers != 0) {
                totaltime += points[i].d - prev;
            }
            if (layers == 1) {
                curPoints.get(curPoints.firstKey()).timeAlone += points[i].d - prev;
            }
            if (points[i].t == 0) {
                layers++;
                curPoints.put(points[i].id, new Freq(0, 0));
            } else {
                layers--;
                maxTimeAlone = Math.min(maxTimeAlone, curPoints.get(points[i].id).timeAlone);
                curPoints.remove(points[i].id);
            }
            prev = points[i].d;
        }
        fout.write(totaltime - maxTimeAlone + "\n"); fout.close();

        
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
