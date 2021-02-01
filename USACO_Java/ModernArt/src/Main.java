import java.io.*;
import java.util.*;

/*
NOT SOLVED
 */

class Coord implements Comparable{
    int x; int y; String id;
    public Coord(int x, int y, String id){
        this.x = x; this.y = y; this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        Coord c1 = this;
        Coord c2 = (Coord) o;
        if(c1.x == c2.x){
            if(c1.y > c2.y){return 1;}
            else if(c1.y < c2.y){return -1;}
            else{return 0;}

        }
        else{
            if(c1.x > c2.x){return 1;}
            else{return -1;}
        }
    }

    @Override
    public String toString(){
        return String.format("(%d, %d)", this.x, this.y);
    }
}

public class Main {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("art.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("art.out"));

        N = Integer.parseInt(fin.readLine());
        HashMap<String, Coord> lowest = new HashMap<>(); HashMap<String, Coord> highest = new HashMap<>();
        for(Integer i = 1; i < 10; i++){
            lowest.put(i.toString(), new Coord(11, 11, i.toString()));
            highest.put(i.toString(), new Coord(-1, -1, i.toString()));
        }

        HashSet<String> potential_starters = new HashSet<>();
        Coord[][] painting = new Coord[N][N];

        for(int i = 0; i < N; i++){
            String s = fin.readLine().trim();
            int j = 0;
            for(Character c : s.toCharArray()){
                if(c == '0'){painting[i][j] = new Coord(0,0, "0");continue;}
                potential_starters.add(c.toString());
                painting[i][j] = new Coord(i, j, c.toString());
                if(lowest.get(c.toString()).compareTo(painting[i][j]) > 0){
                    lowest.replace(c.toString(), painting[i][j]);
                }
                if(highest.get(c.toString()).compareTo(painting[i][j]) < 0){
                    highest.replace(c.toString(), painting[i][j]);
                }
                j++;
            }
        }

        HashSet<String> temp = (HashSet)potential_starters.clone();
        for(String id: potential_starters){
            Coord low = lowest.get(id); Coord high = highest.get(id);
            for(int i = low.x; i <= high.x; i++){
                for(int j = low.y; j <= high.y; j++){
                    String tid = painting[i][j].id;
                    if(!tid.equals(id)){ temp.remove(tid); }
                }
            }
        }

        System.out.println(lowest.get("2").toString() + highest.get("2").toString());

        fout.write(temp.size() + "\n");
        fout.close();

    }

}
