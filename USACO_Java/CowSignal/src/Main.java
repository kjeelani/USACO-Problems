import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static int K;



    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("cowsignal.out"));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());

        ArrayList<String> matrix = new ArrayList<String>();
        for(int i = 0; i < N; i++){
            matrix.add(fin.readLine().trim());
        }

        ArrayList<String> newmatrix = mutated(matrix);
        for(String s : newmatrix){
            fout.write(s);
        }
        fout.close();
    }

    private static ArrayList<String> mutated(ArrayList<String> m) {
        ArrayList<String> nm = new ArrayList<String>();
        for(String s : m){
            String newS = "";
            for(Character c : s.toCharArray()){
                for(int i = 0; i < K; i++){
                    newS += c.toString();
                }
            }
            for(int i = 0; i < K; i++){
                nm.add(newS + "\n");
            }
        }
        return nm;
    }


}
