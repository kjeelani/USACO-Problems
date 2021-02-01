import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;


//TODO: NOT COMPLETED. Will Finish Later

class sortByDate implements Comparator<Log>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Log a, Log b)
    {
        return a.date - b.date;
    }
}

class Log{
    int date;
    int id;
    int val;

    public Log(int Tdate, int Tid, int Tval){
        id = Tid; date = Tdate; val = Tval;
    }

    public String toString(){
        return this.date + " " + this.id + " " + this.val;
    }
}

public class Main {
    private static int N;
    private static int nChanges;
    private static int oldMax; private static int oldNum; private static int oldID;

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("measurement.in"));
        Scanner in = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(fin.readLine());

        N = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> cowscores = new TreeMap<Integer, Integer>();
        TreeMap<Integer, ArrayList<Integer>> leaderboard = new TreeMap<Integer, ArrayList<Integer>>();
        ArrayList<Log> logs = new ArrayList<Log>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer((fin.readLine()));
            Log temp = new Log(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            logs.add(temp);
            if (!cowscores.containsKey(temp.id)) {
                cowscores.put(temp.id, 0);
            }
        }

        Collections.sort(logs, new sortByDate());

        for (Log log : logs) {
            Integer old = cowscores.get(log.id);
            if (leaderboard.containsKey(old) && leaderboard.get(old).contains(log.id)) {
                leaderboard.get(old).remove(new Integer(log.id));
                if (leaderboard.get(old).isEmpty()) {
                    leaderboard.remove(new Integer(old));
                }
            }
            cowscores.replace(log.id, log.val + old);

            /*Updating Leaderboard*/
            if (!leaderboard.containsKey(log.val + old)) {
                leaderboard.put(log.val + old, new ArrayList<Integer>(Arrays.asList(log.id)));
            } else {
                if (leaderboard.get(log.val + old).isEmpty()) {
                    leaderboard.remove(new Integer(log.val + old));
                }
                leaderboard.get(log.val + old).add(log.id);
            }

            int tempMax = leaderboard.lastKey();
            ArrayList<Integer> tempID = leaderboard.get(tempMax);
            int tempNum = tempID.size();
            if (tempNum != oldNum || tempMax != oldMax && oldID != tempID.get(0)) {
                nChanges++;
            }
            oldMax = tempMax;
            oldNum = tempNum;
            oldID = tempID.get(0);
            System.out.println(Arrays.toString(leaderboard.entrySet().toArray()) + " " + nChanges);

        }

        System.out.println(nChanges);

    }
}
