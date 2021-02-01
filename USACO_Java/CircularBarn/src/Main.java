import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

class CircularArrayList<E> extends ArrayList<E>
{
    public E get(int index) {
        if(index < 0){ index = index + size();}
        return super.get(index % this.size());
    }
}

class Node{
    int v; int d;
    public Node(int v, int d){this.v = v; this.d = d;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return v == node.v;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v);
    }
}

public class Main {
    static int N;
    static CircularArrayList<Node> barn;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("cbarn.out"));
        N = toInt(fin.readLine()); barn = new CircularArrayList<>();
        for(int i = 0; i < N; i++){barn.add(new Node(toInt(fin.readLine()), 0));}


        int i = 0;
        while(barn.contains(new Node(0,0))){
            //System.out.println(barn.toString() + " " + i);
            boolean happened = false;
            while(barn.get(i).v > 0 && barn.get(i + 1).v == 0) {
                happened = true;
                barn.get(i).v -= 1;
                findLastZero(i);
            }
            if(happened){i--;}
            else{i++;}
        }
        for(i = 0; i < N; i++){
            ans += Math.pow(barn.get(i).d, 2);
        }
        fout.write(ans + "\n"); fout.close();

        
    }

    private static void findLastZero(int i) {
        for(int j = i+1; j < 2*N; j++){
            if(barn.get(j).v != 0){
                barn.get(j-1).v += 1; barn.get(j-1).d += j-i-1;
                break;
            }
        }
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
