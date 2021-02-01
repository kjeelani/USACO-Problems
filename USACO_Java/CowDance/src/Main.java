import java.io.*;
import java.util.*;

/*
1.) Read data
2.) Binary search values of K and for each value simulate whether K can meet time Tmax (simulating time)
 */
public class Main {
    static int N; static int Tmax;
    static Stack<Integer> cows = new Stack<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("cowdance.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("cowdance.out"));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = toInt(st.nextToken()); Tmax = toInt(st.nextToken());

        for(int i = 0; i < N; i++){
            cows.add(toInt(fin.readLine()));
        }

        int mn = 1; int mx = N; int md = 0;
        while (mx - mn > 1){
            md = (mx + mn) / 2;
            if(simulateStage(md)){mx = md;}
            else{mn = md+1;}
        }
        if(simulateStage(mn)){fout.write(mn + "\n");}
        else{fout.write(mx + "\n");}
        fout.close();
    }

    private static boolean simulateStage(int K) {
        Stack<Integer> tempcows = (Stack) cows.clone();
        HashMap<Integer, Integer> onStage = new HashMap<Integer, Integer>();

        for(int i = 0; i < K; i++){
            onStage.put(i, tempcows.pop());
        }

        int time = 0;
        while(!tempcows.isEmpty()){
            int min = Collections.min(onStage.values());
            time += min;
            for (int i = 0; i < K; i++) {
                int t = onStage.get(i);
                if (t - min == 0) {
                    try {
                        onStage.replace(i, tempcows.pop());
                    }
                    catch (Exception e){
                        onStage.replace(i, 0);
                    }
                } else {
                    onStage.replace(i, t - min);
                }
            }
        }
        return time + Collections.max(onStage.values()) <= Tmax;
    }

    private static int toInt(String x){
        return Integer.parseInt(x);
    }
}
