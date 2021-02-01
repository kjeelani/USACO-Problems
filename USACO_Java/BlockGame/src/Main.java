import java.io.*;
import java.util.*;

public class Main {
    private static Integer[] char_counter = new Integer[26];
    private static final char[] charlist = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("blocks.out"));


        //read data
        N = Integer.parseInt(fin.readLine());
        ArrayList<String[]> block_list = new ArrayList<String[]>();
        for(int i = 0; i < N; i++){
            block_list.add(fin.readLine().split(" "));
        }

        //fill char_counter with 0s
        Arrays.fill(char_counter, 0);

        //for each block, iterate through all characters and find max chars located in each of them
        for(String[] blocks : block_list){
            char[] block1 = blocks[0].toCharArray();
            char[] block2 = blocks[1].toCharArray();
            for(int i = 0; i < 26; i++){
                char_counter[i] += Math.max(count(block1, charlist[i]), count(block2, charlist[i]));
            }
        }

        //finally print out all counts
        for(Integer c : char_counter){
            fout.write(c + "\n");
        }
        fout.close();
    }

    private static int count(char[] charl, char c) {
        int counter = 0;
        for(char tempc : charl){
            if(tempc == c){
                counter++;
            }
        }
        return counter;
    }

}
