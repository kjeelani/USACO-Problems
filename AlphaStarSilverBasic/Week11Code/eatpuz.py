'''
1.) Binary tree branch using recursion, deciding whether to eat a feed or not.
2.) For each iteration, always update maxCal var if we reach a new maximum
3.) If we reach over a certain calorie limit, stop the recursion
'''
from sys import stdin

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
C, N = map(int, fin.readline().rstrip().split())
feeds = [int(x) for x in fin.readline().rstrip().split(' ')]
maxCal = 0

def find_comb(pos, cal):
    global maxCal
    if(cal > C): return
    if(pos == N): maxCal = max(maxCal, cal); return
    maxCal = max(maxCal, cal)
    for i in range(2):
        if(i == 0): find_comb(pos+1, cal)
        else: find_comb(pos+1, cal+feeds[pos])

find_comb(0, 0)
print(maxCal)