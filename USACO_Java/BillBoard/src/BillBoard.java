import java.io.*;
import java.security.KeyPair;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BillBoard {
    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("billboard.out"));
        int totaloverlap = 0;

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int[] billboard1 = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        st = new StringTokenizer(fin.readLine());
        int[] billboard2 = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        st = new StringTokenizer(fin.readLine());
        int[] truck = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        totaloverlap += area(billboard1) + area(billboard2) - (findOverlap(billboard1, truck) + findOverlap(billboard2, truck));;
        fout.write(totaloverlap + "\n");
        fout.close();
    }

    private static int area(int[] r) {
        return (r[2] - r[0]) * (r[3] - r[1]);
    }

    private static int findOverlap(int[] r1, int[] r2) {
        int[] xarr = new int[] {r1[0], r1[2], r2[0], r2[2]};
        int[] yarr = new int[] {r1[1], r1[3], r2[1], r2[3]};
        if((xarr[2] > xarr[1] || xarr[3] < xarr[0]) && (yarr[2] > yarr[1] || yarr[3] < yarr[0])){
            return 0;
        }
        Arrays.sort(xarr); Arrays.sort(yarr);

        int overlap = (xarr[2] - xarr[1]) * (yarr[2] - yarr[1]);
        if(overlap > area(r1)){
            return area(r1);
        }
        else{
            return overlap;
        }
    }
}
