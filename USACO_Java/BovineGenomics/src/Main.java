import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("cownomics.out"));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        char[][] spotted = new char[N][M]; char[][] plain = new char[N][M];
        for(int i = 0; i < N; i++){
            spotted[i] = fin.readLine().trim().toCharArray();
        }
        for(int i = 0; i < N; i++){
            plain[i] = fin.readLine().trim().toCharArray();
        }

        int count = M;
        for(int i = 0; i < M; i++){
            ArrayList<Character> spottedtemp = new ArrayList<>();
            ArrayList<Character> plaintemp = new ArrayList<>();
            Character[] letters = {'A', 'T', 'G', 'C'};
            for(int j = 0; j < N; j++){
                spottedtemp.add(spotted[j][i]);
                plaintemp.add(plain[j][i]);
            }
            for(char c : letters){
                if(spottedtemp.contains(c) && plaintemp.contains(c)){
                    count--;
                    break;
                }
            }
        }
        fout.write(count + "\n");
        fout.close();



    }

}
