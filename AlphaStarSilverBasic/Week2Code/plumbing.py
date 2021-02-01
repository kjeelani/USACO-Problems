from sys import stdin

fin = open("textfiles/test.in", "r")
fout = open("textfiles/test.out", "w")
'''
Iterate through each index of the array, searching all 8 neighbors, and 
keeping track of best depth
'''

n, m = map(int, fin.readline().rstrip().split(' '))
pond = [[int(x) for x in fin.readline().rstrip().split(" ")] for i in range(n)]
best = 0

dx, dy = [0,0,-1,-1,-1,1,1,1], [1,-1,-1,1,0,-1,1,0]

for i in range(n):
    for j in range(m):
        if(pond[i][j] <= best):
            continue
        for y, x in zip(dy, dx):
            if(0 <= y + i < n and 0 <= x + j < m):
                if(pond[y+i][x+j] == pond[i][j]):
                    best = pond[i][j]

fout.write(str(best) + "\n")
fout.close()
