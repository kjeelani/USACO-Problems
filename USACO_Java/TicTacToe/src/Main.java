import java.io.*;
import java.util.*;

public class Main {
    private static char[][] board = new char[3][3];
    private static ArrayList<ArrayList<Character>> storedPoss = new ArrayList<ArrayList<Character>>();


    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("tttt.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("tttt.out"));
        for(int i = 0; i < 3; i++){
            board[i] = fin.readLine().trim().toCharArray();
        }

        ArrayList<char[]> board_possibilities = find_possibilities();
        int indiv = 0; int team = 0;
        for(char[] poss : board_possibilities){
            int t = count(poss);
            if(t == 1){indiv++;}
            else if(t == 2){team++;}
        }
        fout.write(indiv + "\n" + team + "\n"); fout.close();
    }

    private static ArrayList<char[]> find_possibilities() {
        ArrayList<char[]> toReturn = new ArrayList<char[]>();
        char[] col = new char[3];
        for(int i = 0; i < 3; i++){
            toReturn.add(board[i]);
            for(int j = 0; j < 3; j++){
                col[j] = board[j][i];
            }

            toReturn.add(col); col = new char[3];
        }
        toReturn.add(new char[]{board[0][0], board[1][1], board[2][2]});
        toReturn.add(new char[]{board[0][2], board[1][1], board[2][0]});
        return toReturn;
    }

    private static int count(char[] p) {
        ArrayList<Character> noDupes = new ArrayList<Character>();
        for(char c : p){
            if(!noDupes.contains(c)){
                noDupes.add(c);
                Collections.sort(noDupes);
            }
        }
        if(storedPoss.contains(noDupes)){
            return 0;
        }
        System.out.println(Arrays.toString(noDupes.toArray()));
        storedPoss.add(noDupes);
        return noDupes.size();
    }

}
