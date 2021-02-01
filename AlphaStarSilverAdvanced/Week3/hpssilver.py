'''
1.) From 1 to N-2 calculate the max amount of wins for the 6 different combinations of switches
2.) Complexity O(6*N)
'''
from sys import stdin 

class Tracker:
    
    def __init__(self, l1, l2):
        self.left = l1
        self.right = l2
        self.choices = ["HS", "HP", "SH", "SP", "PH", "PS"]
        self.windict = {"S":"P", "P":"H", "H":"S"}

    
    def find_wins(self):
        l = []
        for c in self.choices:
            l.append(self.left[self.windict[c[0]]] + self.right[self.windict[c[1]]])
        return max(l)

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
N = int(fin.readline())
moves = [fin.readline().rstrip() for i in range(N)]
maxwins = 0
tracker = Tracker({"S":0, "P":0, "H":0}, {"S":moves.count("S"), "P":moves.count("P"), "H":moves.count("H")})

for i in range(-1, N):
    if(i == -1): maxwins = tracker.find_wins(); continue
    tracker.left[moves[i]] += 1
    tracker.right[moves[i]] -= 1
    maxwins = max(maxwins, tracker.find_wins())

print(maxwins)