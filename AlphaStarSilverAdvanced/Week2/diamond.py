'''
1.)Precompute for each point the best interval before and after it
2.)Go through the array again and find the maximum some of right[i] + left[i]
'''
from sys import stdin

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
N, K = map(int, fin.readline().rstrip().split(' '))
diamonds = sorted([int(fin.readline()) for i in range(N)])
big, small = [0 for i in range(N)], [0 for i in range(N)]

si, ei, best = 0, 0, 0
while True:
    if(diamonds[ei] - diamonds[si] <= K): best = max(best, ei-si+1); small[ei] = best; ei += 1
    else: si += 1
    if(ei >= N): break

diamonds = diamonds[::-1]
si, ei, best = 0, 0, 0
while True:
    if(diamonds[si] - diamonds[ei] <= K): best = max(best, ei-si+1); big[N-1-ei] = best; ei += 1
    else: si += 1
    if(ei >= N): break

best = 0
for x, y in zip(small, big):
    best = max(best, x+y)
print(min(N,best))
