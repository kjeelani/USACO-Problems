'''

Interval problems: If I have n intervals with 2n "critical points"(start, stop)
which are marked respectively 1 and -1, sort the endpoints based on their positions

Each endpoint is a tuple: (position, label(-1 or 1)) and is sorted by it's position

Search through the ranges and keep indicators on the # of overlaps there are

'''
from sys import stdin; from copy import copy
fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
n = int(fin.readline())
endpoints = []
cd = 0
for i in range(n):
    dist = fin.readline().rstrip().split(' ')
    if(dist[1] == "R"):
        endpoints.append((cd, 1))
        cd += int(dist[0])
        endpoints.append((cd, -1))
    else:
        endpoints.append((cd, -1))
        cd -= int(dist[0])
        endpoints.append((cd, 1))

def sped(v):
    return (v[0], -v[1])
    
endpoints.sort(key=sped)

count = 0
layer = 0
start, end = endpoints[0][0], 0
for e in endpoints:
    end = e[0]
    if(e[1] == 1):
        if(start == None):
            start = e[0]
        layer += 1
    else:
        layer -= 1
        if(layer < 2):
            if(start == None):
                continue
            count += end - start
            start = None
    print(start, end, layer, count)

fout.write(str(count) + "\n")
fout.close()
