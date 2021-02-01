import java.io.*;
import java.util.*;
/*
1.) Read Data and check Lowerbound length and upperbound length
2.) Populate interesting numbers list from size of lowerbound to size of upperbound
3.) Check for all interesting numbers if it is in range and return # of moos
 */
public class Main {
    static long X; static long Y;
    static ArrayList<Long> interestingNums = new ArrayList<Long>();

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(fin.readLine());
        X = toInt(st.nextToken()); Y = toInt(st.nextToken());

        populateInterestingNumbers((X + "").length(), (Y + "").length());
        Collections.sort(interestingNums);
        int moos = 0;
        for(long n : interestingNums){
            if(n > Y){break;}
            if(n <= Y && n >= X){moos++;}
        }

        System.out.println(moos);
    }

    private static void populateInterestingNumbers(Integer lb, Integer ub) {
        for(int size = lb; size <= ub; size++){
            for(int dif = 0; dif < 10; dif++){
                for(int same = 0; same < 10; same++){
                    if(dif == same){continue;}
                    for(int pos = size-1; pos >= 0; pos--){
                        if(same == 0 && pos != size-1 || dif == 0 && pos == size-1){continue;}
                        long num = 0;
                        for(int i = 0; i < size; i++){
                            if(i == pos){num += dif * Math.pow(10, i);}
                            else{num += same * Math.pow(10,i);}
                        }
                        interestingNums.add(num);
                    }
                }
            }
        }
    }

    private static long toInt(String x){
        return Long.parseLong(x);
    }
}
