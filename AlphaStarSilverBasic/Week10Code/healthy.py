'''
1.)Use binary search to find minimum number of feeds
    a.)For each search testing X feeds, find all sets of X feeds and find the shortest one
    that exists. If none exist, return False, if it does, return true
'''
from sys import stdin


fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
V = int(fin.readline()); needs = [int(x) for x in fin.readline().rstrip().split(' ')]
F = int(fin.readline()); feeds = [[int(x) for x in fin.readline().rstrip().split(' ')] for i in range(F)]
best = {i:[] for i in range(F)}

def needsMet(arr):
    for x, y in zip(arr, needs):
        if(x < y): return False
    return True

def vitamensPossible(pos, arr, iarr):
    if(needsMet(arr)):
        best[len(iarr)-1].append(iarr)
        return
    if(pos == F):
        return
    for i in range(2):
        if(i == 0): vitamensPossible(pos + 1, arr, iarr)
        if(i == 1):
            vitamensPossible(pos + 1, [arr[j] + feeds[pos][j] for j in range(V)], iarr + [pos+1])

vitamensPossible(0, [0 for j in range(V)], [])

for i in range(F):
    if(len(best[i]) != 0):
        print(str(i+1), end=" ")
        for e in sorted(best[i])[0]:
            print(str(e), end=" ")
        break
    
        

    
            

