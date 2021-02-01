import java.io.*;
import java.util.*;
/*
1.) Read data into adj matrix
2.) Simulate bfs
    a.) Keep track of what time each position was reached in HashMap
    b.) Do so until queue is empty
3.) For each time, print what was reached
 */

class Node{
    int d; int m;
    public Node(int d, int m){
        this.d = d; this.m = m;
    }
}

public class Main {
    static int N; static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); M = toInt(st.nextToken());

        int[][] adjmatrix = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(fin.readLine());
            for(int j = 0; j < N; j++){
                adjmatrix[i][j] = toInt(st.nextToken());
            }
        }
        boolean[] visited = new boolean[N];
        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(new Node(M-1, 1));

        HashMap<Integer, ArrayList<Integer>> toPrint = new HashMap<Integer,ArrayList<Integer>>();


        while (!nodes.isEmpty()){
            Node t = nodes.poll();
            if(visited[t.d]){continue;}
            if(!toPrint.containsKey(t.m)){toPrint.put(t.m, new ArrayList<Integer>(Collections.singletonList(t.d)));}
            else{toPrint.get(t.m).add(t.d);}

            visited[t.d] = true;
            for(int i = 0; i < N; i++){
                if(adjmatrix[t.d][i] == 1){nodes.add(new Node(i, t.m + 1));}
            }
        }

        int c = 1;
        while (true){
            try {
                Collections.sort(toPrint.get(c));
                for (Integer i : toPrint.get(c)) {
                    System.out.print(i+1 + " ");
                }
                System.out.println();
            }
            catch (Exception e){
                break;
            }
            c++;
        }


        
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
