import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N; static int M;
    static HashMap<Integer, ArrayList<Integer>> wormholes = new HashMap<>();
    static int[] positions;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("wormsort.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("wormsort.out"));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); M = toInt(st.nextToken());
        positions = new int[N];

        st = new StringTokenizer(fin.readLine());
        for(int i = 0; i < N; i++){positions[i] = toInt(st.nextToken())-1; wormholes.put(i, new ArrayList<>());}

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(fin.readLine());
            int s = toInt(st.nextToken())-1; int e = toInt(st.nextToken())-1;
            int width = toInt(st.nextToken());

            wormholes.get(s).add(width); wormholes.get(e).add(width);
        }
         int[] t = positions.clone();
        Arrays.sort(t);
        if(Arrays.equals(t, positions)){fout.write(-1 + "\n");}
        else{
            int mn = Integer.MAX_VALUE;
            for(int i = 0; i < N; i++){
                //System.out.println(wormholes.toString() + " " + Arrays.toString(positions));
                if(!wormholes.get(i).isEmpty() && positions[i] != i){mn = Math.min(mn, Collections.max(wormholes.get(i)));}
            }
            fout.write(mn + "\n");
        }
        fout.close();

        
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
