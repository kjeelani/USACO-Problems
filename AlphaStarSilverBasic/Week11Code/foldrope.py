'''
1.) Store data in an array, sort it, make it a 2L+1 array to make it count for .5
2.) Mark all knots(besides endpoints) and centers of knots as canidates to try
    a.) For each canidate loop forward and backwards and see if it violates its validity
    (meaning it reaches and endpoint of a tail without a time when one endpoint is similar to another)
    If it doesnt, count it as a valid position

'''
from sys import stdin

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
N, L = map(int, fin.readline().rstrip().split(' '))
knots = sorted([int(fin.readline()) for i in range(N)])
lineArr = [0 for i in range(2*L+1)]
criticalPoints = set()
for i in range(N):
    lineArr[knots[i]*2] = 1
    if(i != N-1): criticalPoints.add((knots[i+1]+knots[i]))
    if(i != 0 and i != N-1): criticalPoints.add(knots[i]*2)
    
nfolds = 0
for cp in criticalPoints:
    valid = False
    for offset in range(1,2*L+1):
        if(not(0 <= cp-offset and cp+offset <= 2*L)): valid = True; break
        if(lineArr[cp-offset] != lineArr[cp+offset]): break; 
    if(valid): nfolds += 1;
    
print(nfolds)

