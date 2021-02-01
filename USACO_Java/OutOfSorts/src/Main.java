import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("sort.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("sort.out"));
        N = toInt(fin.readLine());
        for(int i = 0; i < N; i++){arr[i] = toInt(fin.readLine());}



        
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
