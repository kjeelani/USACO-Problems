import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("lostcow.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("lostcow.out"));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int x = Integer.parseInt(st.nextToken()); int Y = Integer.parseInt(st.nextToken());

        int distance = 0; int position = x; int steplength = 1;
        boolean isGreater = x > Y;
        while (true) {
            distance += Math.abs(position - (x + steplength));
            position = x + steplength;
            steplength *= -2;
            if(isGreater != position > Y){
                break;
            }
        }

        fout.write(distance-Math.abs(position-Y) + "\n");
        fout.close();
    }

}
