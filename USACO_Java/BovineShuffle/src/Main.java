import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n;

    public static void main(String[] args) throws IOException {
	    BufferedReader fin = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("shuffle.out"));

        n = Integer.parseInt(fin.readLine());
        //for code
        StringTokenizer st = new StringTokenizer(fin.readLine());
        Integer[] codec = new Integer[n];
        for(int i = 0; i < n; i++){
            codec[i] = Integer.parseInt(st.nextToken());
        }

        //for cows
        st = new StringTokenizer(fin.readLine());
        String[] cows = new String[n];
        for(int i = 0; i < n; i++){
            cows[i] = st.nextToken();
        }

        Integer[] reverse_codec = reverse(codec);

        for(int i = 0; i < 3; i++) {
            String[] temp = new String[n];
            for (int j = 0; j < n; j++) {
                temp[reverse_codec[j]-1] = cows[j];
            }
            cows = temp;
            //System.out.println(Arrays.toString(cows));
        }

        for(String cow: cows){
            fout.write(cow + "\n");
        }
        fout.close();
    }

    private static Integer[] reverse(Integer[] codec) {
        Integer[] numarray = new Integer[n];
        for(int i = 0; i < n; i++){
            numarray[i] = i+1;
        }
        Integer[] to_return = new Integer[n];
        for (int i = 0; i < n; i++) {
            to_return[codec[i]-1] = numarray[i];
            //System.out.println(Arrays.toString(to_return));
        }
        return to_return;
    }
}
