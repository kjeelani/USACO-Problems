import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static ArrayList<Integer> cows;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("photo.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("photo.out"));

        N = Integer.parseInt(fin.readLine());
        cows = new ArrayList<Integer>();
        for(String cow : fin.readLine().trim().split(" ")){
            cows.add(Integer.parseInt(cow));
        }

        ArrayList<Integer> idealPermutation = findIdealPermutation();
        String s = "";
        for(Integer cow : idealPermutation){
            s += cow + " ";
        }
        fout.write(s.trim() + "\n");
        fout.close();
    }

    private static ArrayList<Integer> findIdealPermutation() {
        ArrayList<Integer> current = null;
        int size ;
        for(int i = cows.get(0); i > -1; i--){
            current = new ArrayList<Integer>();
            current.add(i); //4 0;
            size = 0;
            for(Integer cow : cows){
                current.add(cow - current.get(size));
                size += 1;
            }
            if(checkValidity(current)){
                return current;
            }
        }
        return current; //this should never run
    }

    private static boolean checkValidity(ArrayList<Integer> c) {
        ArrayList<Integer> temp = new ArrayList<>();
        for(Integer e: c){
            temp.add(e);
        }
        Collections.sort(temp);
        for(int i = 1; i < N+1; i++){
            if(i != temp.get(i-1)){
                return false;
            }
        }
        return true;
    }

}
