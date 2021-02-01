import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("hoofball.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("hoofball.out"));

        //read data
        int N = Integer.parseInt(fin.readLine());
        String[] temp = fin.readLine().trim().split( " ");
        int[] cows = new int[N];
        for(int i = 0; i < N; i++){
            cows[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(cows);

        //keep track of coordinates for oscillating pairs
        ArrayList<Integer> oscPairI = new ArrayList<Integer>();
        for(int i = 0; i < N; i++){
            if(i == N-1){continue;}
            int s = cows[i]; int e = cows[i+1];
            if (i == 0){
                if(e-s <= cows[i+2] - e){
                    oscPairI.add(i);
                }
            }
            else if (i + 2 == N){
                if(e-s < s-cows[i-1]){
                    oscPairI.add(i);
                }
            }
            else{
                if(e-s < s-cows[i-1] && e-s <= cows[i+2]-e){
                    oscPairI.add(i);
                }
            }
        }

        System.out.println(Arrays.toString(new ArrayList[]{oscPairI}));

        //update counter for each pair
        for(Integer i : oscPairI){
            System.out.print(C + " ");

            if(i == 0 || i == N-2){
                C++;
            }
            else if(i == 1){
                C++;
                if(cows[i+2] - cows[i+1] <= cows[i+3] - cows[i+2]){
                    C++;
                }
            }
            else if(i == N-3){
                C++;
                if(cows[i] - cows[i-1] < cows[i-1] - cows[i-2]){
                    C++;
                }
            }
            else{
                boolean c1 = cows[i+2] - cows[i+1] <= cows[i+3] - cows[i+2];
                boolean c2 = cows[i] - cows[i-1] < cows[i-1] - cows[i-2];
                if(c1){C++;}
                if(c2){C++;}
                if(!c1 && !c2){C++;}
            }
            System.out.println(C);
        }

        fout.write(C + "\n");
        fout.close();



    }

}
