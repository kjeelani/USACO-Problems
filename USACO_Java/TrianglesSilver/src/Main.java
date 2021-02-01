import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/


public class Main {
    static int N;
    static HashMap<Integer, ArrayList<Integer>> ylines = new HashMap<>();
    static HashMap<Integer, ArrayList<Integer>> xlines = new HashMap<>();

    static HashSet<Integer> xvalues = new HashSet<>();
    static long areas;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("_.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("_.out"));
        N = toInt(fin.readLine());

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(fin.readLine());
            int x = toInt(st.nextToken()); int y = toInt(st.nextToken());

            if(!ylines.containsKey(x)){ylines.put(x, new ArrayList<>(Collections.singletonList(y)));}
            else{ylines.get(x).add(y);}

            if(!xlines.containsKey(y)){ylines.put(y, new ArrayList<>(Collections.singletonList(x)));}
            else{ylines.get(y).add(x);}

            xvalues.add(x);
        }

        ArrayList<Integer> xprefix = new ArrayList<>();
        ArrayList<Integer> yprefix = new ArrayList<>();

        for(int i = 0; i < xvalues.size(); i++){

        }
        
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
