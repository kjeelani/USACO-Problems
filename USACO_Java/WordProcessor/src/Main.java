import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static String[] words;
    private static int K;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("word.in"));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());

        words = fin.readLine().trim().split(" ");
        processWords();
    }

    private static void processWords() throws IOException{
        PrintWriter fout = new PrintWriter(new FileWriter("word.out"));

        String cur = "";
        int nwords = 0;
        for(String word: words){
            System.out.println(cur + " | " + word);
            if(cur.length() == 0){
                cur += word;
            }
            else if(word.length() + cur.length() - nwords <= K){
                cur += " " + word;
                nwords += 1;
            }
            else{
                fout.write(cur + "\n");
                cur = word;
                nwords = 0;
            }
        }
        fout.write(cur + "\n");
        fout.close();
    }

}
