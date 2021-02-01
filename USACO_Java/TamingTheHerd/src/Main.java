import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int min;
    private static  int max;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("taming.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("taming.out"));

        //read data
        int N = Integer.parseInt(fin.readLine());
        int[] confirmedBreakouts = new int[N];
        confirmedBreakouts[N-1] = -1;
        ArrayList<Integer> logs = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(fin.readLine());
        for (int i = 0; i < N; i++){
            logs.add(Integer.parseInt(st.nextToken()));
        }
        Collections.reverse(logs);

        //fill in breakouts
        boolean illegal = false;
        for(int i = 0; i < N; i++){
            if(logs.get(i) != -1) {
                if (i + logs.get(i) > N) {
                    illegal = true;
                    break;
                }
                confirmedBreakouts[i] = logs.get(i);
                confirmedBreakouts[i + logs.get(i)] = -1;
            }
            if(confirmedBreakouts[i] == 0){
                confirmedBreakouts[i] = -99;
            }
        }

        if(illegal){
            fout.write("-1\n"); fout.close();
        }
        if(simulateBreakouts(confirmedBreakouts, N)){
            fout.write(min + " " + max + "\n"); fout.close();
        }
        else{
            fout.write("-1\n"); fout.close();
        }
    }

    private static boolean simulateBreakouts(int[] cBarray, int N) {
        boolean isScanning = true;
        ArrayList<Integer> legality = new ArrayList<Integer>();
        for(int i = 0; i < N; i++) {
            //reduces all counters by 1
            for(int j = 0; j < legality.size(); j++){
                legality.set(j, legality.get(j) - 1);
            }
            if(cBarray[i] == -99){
                if(isScanning){
                    max++;
                }
            }
            else if(cBarray[i] >= 1){
                //stop adding to max counter
                legality.add(cBarray[i]);
                isScanning = false;
            }
            else{
                isScanning = true;
                max++; min++;
                //if all counters are not agreeable, break program return -1
                for(Integer x : legality){
                    if(x != 0){
                        return false;
                    }
                }
                legality = new ArrayList<Integer>();
            }
        }
        return true;
    }

}
