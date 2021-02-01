import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("teleport.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("teleport.out"));

        StringTokenizer st = new StringTokenizer((fin.readLine()));
        int A = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()); int Y = Integer.parseInt(st.nextToken());

        fout.write(Math.min(Math.abs(A-B), Math.min(Math.abs(A-X) + Math.abs(Y-B), Math.abs(A-Y) + Math.abs(X-B))) + "\n");
        fout.close();

    }

}
