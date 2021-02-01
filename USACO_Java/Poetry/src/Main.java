import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/*
    1.)Read data, and put all the ending syllable counts into a set
    2.)Use combinations to find all the possibilities of a line if the ending of the line is a certain syllable
    Keep this in a dictionary
    3.)Make a dictionary of rhyme_scheme:syllables
    4.)Keep a dictionary of letter counts
    5.)Sum each letter as so:
        a.)#letters * sum(dict2[dict3[0..i]])
    6.)Return sum

*/
public class Main {
    static int N; static int K; static int M;
    static HashSet<Integer> syllableSet = new HashSet<Integer>(); static Set<Integer> rhymeSchemeSet = new HashSet<Integer>();
    static HashMap<Integer, Integer> syllableToCharCount = new HashMap<Integer, Integer>();
    static HashMap<Integer, ArrayList<Integer>> rhymeSchemeToSyllables = new HashMap<Integer, ArrayList<Integer>>();;
    static HashMap<String, Integer> alphabetCounter = new HashMap<String, Integer>();

    static int counter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("poetry.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("poetry.out"));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(fin.readLine());
            Integer x = Integer.parseInt(st.nextToken()); Integer y = Integer.parseInt(st.nextToken());
            syllableSet.add(x); rhymeSchemeSet.add(y);
            ArrayList<Integer> temp = rhymeSchemeToSyllables.get(y);
            if (temp == null) {temp = new ArrayList<Integer>(); rhymeSchemeToSyllables.put(y, temp);}
            temp.add(x);
        }

        for(int i = 0; i < M; i++){
            String letter = fin.readLine().trim();
            Integer count = alphabetCounter.get(letter);
            if (count == null) {alphabetCounter.put(letter, 1);}
            else {alphabetCounter.put(letter, count + 1);}
        }

        for(Integer n : syllableSet){
            syllableToCharCount.put(n, findAllComb(K-n));
        }

        int partialsum = 1;
        for(Integer i : rhymeSchemeToSyllables.keySet()){
            int t = 0;
            for(Integer sy : rhymeSchemeToSyllables.get(i)){
                t += syllableToCharCount.get(sy);
            }
            partialsum *= t;
        }

        fout.write(partialsum * M + "\n"); fout.close();


    }

    private static Integer findAllComb(int n) {
        findComb(n);
        int t = counter;
        counter = 0;
        return t;
    }

    private static void findComb(int n) {
        if(n == 0){counter++; return;}
        else if(n < 0){return;}
        for(Integer i : syllableSet){
            findComb(n-i);
        }
    }

}
