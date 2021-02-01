import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int count;



    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("square.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("square.out"));

        ArrayList<Integer> xcoords = new ArrayList<>(); ArrayList<Integer> ycoords = new ArrayList<Integer>();
        int c = 1;
        for(int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            while (st.hasMoreTokens()) {
                if (c % 2 == 1) {
                    xcoords.add(Integer.parseInt(st.nextToken()));
                } else {
                    ycoords.add(Integer.parseInt(st.nextToken()));
                }
                c += 1;
            }
        }
        int xdif = Collections.max(xcoords) - Collections.min(xcoords); int ydif = Collections.max(ycoords) - Collections.min(ycoords);
        fout.write((int) Math.pow(Math.max(xdif, ydif),2) + "\n");
        fout.close();
    }

}
