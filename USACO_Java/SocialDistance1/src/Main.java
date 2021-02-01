import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static char[] cows;
    private static ArrayList<Integer> emptystalls = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("socdist1.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("socdist1.out"));

        N = toInt(fin.readLine());
        cows = fin.readLine().toCharArray();

        int run = 0; boolean aRun = false;
        for(int i = 0; i < N; i++){
            if(cows[i] == '0'){run++;}
            else if(run != 0){
                emptystalls.add(run);
                run = 0;
            }
        }
        if(run != 0){emptystalls.add(run);}
        Collections.sort(emptystalls, Collections.reverseOrder());
        System.out.println(Arrays.toString(emptystalls.toArray()));

//        int max = N; int min = 2; int mid = 0;
//        while(max-min > 1){
//            mid = (min + max)/2;
//            if(testD(mid)){min = mid+1;}
//            else{max=mid;}
//        }
//        if(testD(max)){fout.write( max+ "\n");}
//        else{fout.write(min + "\n");}

        fout.write(testD() +"\n");
        fout.close();
    }

    private static int testD() {
        try{
            return Math.max((emptystalls.get(0)+1)/3, Math.min((emptystalls.get(0)+1)/2, (emptystalls.get(1)+1)/2));
        }
        catch (Exception e){
            return (emptystalls.get(0)+1)/3;
        }
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
