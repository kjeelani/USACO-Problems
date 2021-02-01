import java.io.*;
import java.util.*;

/*
1) Read data. Store M cows into stack
2.)Create array of N to represent order
3.)Fill in K cows within the array and add them to InPlace list
4.)Scan backwards
    a.)Pop from stack. If cow in InPlace, go backwards until cow is reached. Or else place in next unfilled position
5.)Scan list to find first empty position and return it


80% Solved
*/

public class Main {
    static int K; static int N; static int M;
    static int[] order;
    static ArrayList<Integer> inPlace = new ArrayList<Integer>();
    static Stack<Integer> hierarchy = new Stack<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("milkorder.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("milkorder.out"));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        order = new int[N];

        st = new StringTokenizer(fin.readLine());
        for(int i = 0; i < M; i++){
            hierarchy.push(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(fin.readLine());
            int value = Integer.parseInt(st.nextToken()); int position = Integer.parseInt(st.nextToken())-1;
            inPlace.add(value); order[position] = value;
        }

        int temp = hierarchy.peek();
        boolean toPlace = inPlace.contains(temp);
        for(int i = N - 1; i >= 0; i--){
//            System.out.println(order[i] == 0);
            try {
                if (!toPlace && order[i] == 0) {
                    order[i] = hierarchy.pop();
                    inPlace.add(order[i]);
                    temp = hierarchy.peek();
                    toPlace = inPlace.contains(temp);
                } else if (order[i] == temp) {
                    hierarchy.pop();
                    temp = hierarchy.peek();
                    toPlace = inPlace.contains(temp);
                }
            }
            catch (EmptyStackException e){
                break;
            }
        }
//        System.out.println(Arrays.toString(hierarchy.toArray()));
//        System.out.println(Arrays.toString(inPlace.toArray()));
//        System.out.println(Arrays.toString(order));
        boolean placeOne = inPlace.contains(1);
        for(int i = 0; i < N; i++){
            if(order[i] == 0 && !placeOne){
                fout.write((i + 1) + "\n");
                fout.close();
                break;
            }
            else if(order[i] == 1 && placeOne){
                fout.write((i + 1) + "\n");
                fout.close();
                break;
            }
        }


    }

}
