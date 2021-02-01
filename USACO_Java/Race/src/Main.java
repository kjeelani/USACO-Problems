import java.io.*;
import java.util.*;

public class Main {
    private static int K;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("race.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("race.out"));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        K = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            fout.write(findMin(Integer.parseInt(fin.readLine())) + "\n");
            System.out.print("\n");
        }

        fout.close();

    }

    private static Integer findMin(int X) {
        int steps = 0; int totalDistance = 0; int stride = 1;
        while(totalDistance < K){
            steps += 1;
            totalDistance += stride;
            if(gaussSum(stride + 1) - gaussSum(X-1) <= K-totalDistance+X-1){stride += 1; }
            else if(gaussSum(stride) - gaussSum(X-1) <= K-totalDistance+X-1){}
            else{stride -= 1;}
        }
        return steps;
    }

    private static int gaussSum(int x) {
        return (x * (1+x))/2;
    }

}
