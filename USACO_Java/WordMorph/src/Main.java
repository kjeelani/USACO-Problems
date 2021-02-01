import java.io.*;
import java.util.*;

/*
1.) Read data. Remove all words not similar in length to the act word from the dictionary
2.) 
 */

class Node{
    String d; int m;
    public Node(String data, int moves){
        this.d = data; this.m = moves;
    }
}

public class Main {
    static ArrayList<String> dictionary = new ArrayList<String>();
    static HashMap<String, Boolean> visited = new HashMap<String, Boolean>();

    static String word1; static String word2; static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
        word1 = fin.readLine().trim(); word2 = fin.readLine().trim(); N = word1.length();
        while(fin.ready()){
            String t = fin.readLine().trim();
            if(t.length() == N){dictionary.add(t);visited.put(t, false);}
        }
        Collections.sort(dictionary);

        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(new Node(word1, 0));
        while(true){
            Node t = nodes.poll();
            if(visited.get(t.d)){continue;}
            if(t.d.equals(word2)){System.out.println(t.m);break;}
            visited.replace(t.d, true);
            for(String s : dictionary){
                if(intersection(t.d, s)){nodes.add(new Node(s, t.m+1));}
            }
        }
        
    }

    private static boolean intersection(String s1, String s2) {
        int diff = 0;
        for(int i = 0; i < N; i++){
            if(!s1.substring(i, i+1).equals(s2.substring(i, i+1))){diff++;}
            if(diff > 1){return false;}
        }
        return true;
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
