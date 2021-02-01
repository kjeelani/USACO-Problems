import java.io.*;
import java.util.*;

/*
CODE EXPLANATION HERE
*/

public class Main {
    static int N; static int Q;
    static char[] toPaint; static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    static int strokes = 0;
    static HashMap<Character, ArrayList<ArrayList<Character>>> taboo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = toInt(st.nextToken());; Q = toInt(st.nextToken());

        toPaint = f.readLine().trim().toCharArray();

        HashMap<Character, Boolean> alphacheck = new HashMap<>();
        HashMap<Character, ArrayList<Integer>> charindices = new HashMap<>();
        for(int i = 0; i < 26; i++){
            alphacheck.put(alphabet[i], false);
            charindices.put(alphabet[i], new ArrayList<>());
            taboo.put(alphabet[i], new ArrayList<>());
        }
        for(int i = 0; i < N; i++){
            if(!alphacheck.get(toPaint[i])){strokes++;}
            alphacheck.replace(toPaint[i], true);
            charindices.get(toPaint[i]).add(i);
            for(int j = 0; j < 26; j++){
                if(alphabet[j] > toPaint[i]){alphacheck.replace(alphabet[j], false);}
            }
        }

        for(int i = 0; i < 26; i++){
            ArrayList<Integer> c = charindices.get(alphabet[i]);
            for(int j = 0; j < c.size()-1; j++){
                ArrayList<Character> t = new ArrayList<>();
                for(int k = c.get(j)+1; k < c.get(j+1)-1; k++){
                    if(alphabet[i] > toPaint[k]){t.add(toPaint[k]);}
                }
                if(t.size() > 0){taboo.get(alphabet[i]).add(t);};
            }
        }

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(f.readLine());
            System.out.println(findStrokes(toInt(st.nextToken()), toInt(st.nextToken())));
        }

        
    }

    private static int findStrokes(int s, int e) {
        char[] temp = Arrays.copyOfRange(toPaint, s, e);
        int tstrokes = strokes;
       HashSet<Character> splice = new HashSet<>();
       for(int i = 0; i < s-e; i++){
           splice.add((Character) temp[i]);
       }

       System.out.println(tstrokes + " " + splice.toString() + " " + taboo.toString());

       for(int i = 0; i < 26; i++){
            for(ArrayList<Character> t: taboo.get(alphabet[i])){
                boolean delStroke = true;
                for(Character c : t){
                    if(!splice.contains(c)){delStroke = false; break;}
                }
                if(delStroke){tstrokes--;}
           }
       }
       return tstrokes;
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
