import java.io.*;
import java.util.*;
/*
1.) Read data and construct adjacency list
2.) Loop through adjacency list and return max(n.edges)+1
 */
public class Main {
    static int N;
    static HashMap<Integer, Integer> edges = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("planting.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("planting.out"));
        N = toInt(fin.readLine());

        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(fin.readLine());
            int n1 = toInt(st.nextToken()); int n2 = toInt(st.nextToken());
            if(edges.containsKey(n1)){edges.replace(n1, edges.get(n1) + 1);}
            else{edges.put(n1,1);}
            if(edges.containsKey(n2)){edges.replace(n2, edges.get(n2) + 1);}
            else{edges.put(n2,1);}
        }

        int max = 0;
        for(Integer k : edges.values()){
            max = Math.max(max,k);
        }
        fout.write((max+1)+"\n"); fout.close();
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
