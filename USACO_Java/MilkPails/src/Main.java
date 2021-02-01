
import java.io.*;
import java.util.*;

class State{
    int x; int y;
    public State(int x, int y){
        this.x = x; this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return x == state.x &&
                y == state.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Node{
    State s; int m;
    public Node(State s, int m){
        this.s = s; this.m = m;
    }
}

public class Main {
    static int X; static int Y;
    static int K; static int M;
    static HashMap<State, Boolean> states = new HashMap<State, Boolean>();

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("pails.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("pails.out"));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        X = toInt(st.nextToken()); Y = toInt(st.nextToken()); K = toInt(st.nextToken()); M = toInt(st.nextToken());

        Queue<Node> nodes = new LinkedList<Node>();
        int closest = Integer.MAX_VALUE;
        nodes.add(new Node(new State(0,0), 0));
        while(!nodes.isEmpty()){
            Node n = nodes.poll();
            if(states.containsKey(n.s)){continue;}
            else{states.put(n.s, true);}
            closest = Math.min(Math.abs(M-(n.s.x+n.s.y)), closest);
            if(n.m >= K){continue;}
            nodes.add(new Node(new State(0, n.s.y), n.m+1));
            nodes.add(new Node(new State(n.s.x, Y), n.m+1));
            nodes.add(new Node(new State(Math.max(n.s.x-(Y-n.s.y), 0), Math.min(n.s.x+n.s.y, Y)), n.m+1));
            nodes.add(new Node(new State(n.s.x, 0), n.m+1));
            nodes.add(new Node(new State(X, n.s.y), n.m+1));
            nodes.add(new Node(new State(Math.min(n.s.y+n.s.x, X), Math.max(n.s.y-(X-n.s.x), 0)), n.m+1));
        }
        fout.write(closest + "\n"); fout.close();
        
    }
    
    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
