'''
1.) Go through all possible positions i, j, k
2.) Add all combinations of spotted to array
3.) In nonspotted array, check if there is any combinations present. If not, then increment
total counter

50% correct
'''
from sys import stdin 

class Cow():
    def __init__(self, data):
        self.pos = int(data[0])
        self.type = data[1]
    
    @staticmethod
    def posSort(v):
        return v.pos

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
N = int(fin.readline())
cows = sorted([Cow(fin.readline().rstrip().split(' ')) for i in range(N)], key=Cow.posSort)
prefix = {i:[-1, 0] for i in range(-N, N)}

c = 0
for i in range(N):
    if(cows[i].type == "G"): c += 1
    else: c -= 1
    if(prefix[c][0] == -1): prefix[c][0] = i+1
    else: prefix[c][1] = i

mx = 0
for i in range(-N, N):
    p = prefix[i]
    try:
        if(p[0] != -1): print(p); mx = max(mx, cows[p[1]].pos - cows[p[0]].pos)
    except IndexError:
        pass

print(mx)




     