import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static TreeSet<Integer> xvalues = new TreeSet<Integer>();
    static TreeSet<Integer> yvalues = new TreeSet<Integer>();
    static TreeMap<Integer, TreeSet<Integer>> xcount = new TreeMap<Integer, TreeSet<Integer>>();
    static TreeMap<Integer, TreeSet<Integer>> ycount = new TreeMap<Integer, TreeSet<Integer>>();



    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("threelines.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("_.out"));

        N = toInt(fin.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(fin.readLine());
            int x = toInt(st.nextToken()); int y = toInt(st.nextToken());
            xvalues.add(x); yvalues.add(y);

            Set<Integer> count = ycount.get(x);
            if(count == null){ycount.put(x, new TreeSet<Integer>(Arrays.asList(y)));}
            else{count.add(y);}

            count = xcount.get(y);
            if(count == null){xcount.put(y, new TreeSet<Integer>(Arrays.asList(x)));}
            else{count.add(x);}
        }

        if(checkThreeLines() || checkTwoLines()){System.out.println(1);}
        else{System.out.println(0);}
        
    }

    private static boolean checkTwoLines() {
        boolean firstCondition = true;
        Integer violate = 0;
        TreeSet<Integer> totalyvals = new TreeSet<>();
        for(Integer x : xvalues){
            TreeSet<Integer> yvals = ycount.get(x);
            if(yvals.size() > 2){violate++;}
            else{
                for(Integer i : yvals){totalyvals.add(i);}
            }
            if(totalyvals.size() > 2 || violate > 1){firstCondition = false; break;}
        }

        boolean secondCondition = true;
        violate = 0;
        TreeSet<Integer> totalxvals = new TreeSet<>();
        for(Integer y : yvalues){
            TreeSet<Integer> xvals = xcount.get(y);
            if(xvals.size() > 2){violate++;}
            else{
                for(Integer i : xvals){totalxvals.add(i);}
            }
            if(totalyvals.size() > 2 || violate > 1){secondCondition = false; break;}
        }

        return  firstCondition || secondCondition;
    }

    private static boolean checkThreeLines() {
        return xvalues.size() <= 3 || yvalues.size() <= 3;
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
