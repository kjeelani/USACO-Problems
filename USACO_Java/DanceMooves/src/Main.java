import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N; static int K;
    static HashMap<Integer, HashSet<Integer>> reached = new HashMap<>();
    static ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    static int[] positions;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = toInt(st.nextToken()); K = toInt(st.nextToken());

        positions = new int[N];
        for(int i = 0; i < N; i++){
            reached.put(i, new HashSet<>(Collections.singletonList(i)));
            paths.add(new ArrayList<>(Collections.singletonList(i)));
            positions[i] = i;
        }

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(f.readLine());
            int n1 = toInt(st.nextToken())-1; int n2 = toInt(st.nextToken())-1;

            int t = positions[n1];
            positions[n1] = positions[n2];
            positions[n2] = t;


            reached.get(positions[n1]).add(n1); reached.get(positions[n2]).add(n2);

            //System.out.println(Arrays.toString(positions)  +  reached.toString());

        }



        for(int i = 0; i < N; i++){
            int curPos = i; HashSet<Integer> visited = new HashSet<>(); HashSet<Integer> actuallyVisited = new HashSet<>();
            do{
                visited.addAll(reached.get(curPos));
                actuallyVisited.add(curPos);
                curPos = positions[curPos];
            } while(!actuallyVisited.contains(curPos));
            System.out.println(visited.size());
        }


        
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
