'''
1.) Go through all possible positions i, j, k
2.) Add all combinations of spotted to array
3.) In nonspotted array, check if there is any combinations present. If not, then increment
total counter
'''
from sys import stdin

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
N, M = map(int, fin.readline().rstrip().split(' '))
spotted, nonspotted = [fin.readline().rstrip() for i in range(N)], [fin.readline().rstrip() for i in range(N)]
encode = {'A':0, 'T':1, 'G':2, 'C':3}
ncows = 0

def find(c, triplet):
    return encode[c[triplet[0]]] * 16 + encode[c[triplet[1]]] * 4 + encode[c[triplet[2]]]

for i in range(M):
    for j in range(i+1, M):
        for k in range(j+1, M):
            marked = [False for i in range(64)]
            for cow in spotted:
                marked[find(cow, (i,j,k))] = True
            for cow in nonspotted:
                if(marked[find(cow, (i,j,k))]):
                    break
            else:
                ncows += 1

print(ncows)