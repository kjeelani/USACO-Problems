'''
1.) Create a sliding window of size K and slide through road
    a.) Keep track of minimum amount of lights
    
Alternative Solution:
1.) Create a prefix sum, then find queries from 1 to N-K
'''
from sys import stdin 

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
N, K, B = map(int, fin.readline().rstrip().split(' '))

def prefix(l):
    s = 0
    newl = [0 for i in range(N)]
    for i in range(N):
        if(l[i] == 1):
            s += 1
        newl[i] = s
    return newl

signals = [0 for i in range(N)]
for i in range(B):
    signals[int(fin.readline())-1] = 1
signals = prefix(signals)
print(signals)
minfix = 10**10
for i in range(N-K):
    minfix = min(minfix, signals[i+K] - signals[i])

print(minfix)