'''
1.) Read data
2.) For each word, create a "linked list" with the word and search it in the matrix using DFS
'''
from sys import stdin

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
N = 5; board = [fin.readline().rstrip().split(' ') for i in range(N)]
words = []; count = 0
# while stdin.isatty():
#     words.append(stdin.readline().rstrip())
dx,dy = [-1,-1,-1,0,0,1,1,1], [1,0,-1,1,-1,1,0,-1]
found = False

def dfs(coord, word, visited):
    global count, found
    x,y = coord[0], coord[1]
    
    if(found): return
    visited[x][y] = True
    
    for ix in dx:
        for iy in dy:
            fx, fy = x + ix, y + iy
            try:
                if(0 <= fx < N and 0 <= fy < N and not visited[fx][fy] and board[fx][fy] == word[-2]): 
                    dfs((fx, fy), word[:-1], visited)
            except IndexError: count += 1; found = True; return
    
    
    

for word in fin:
    w = word.rstrip()
    for r in range(N):
        for c in range(N):
            if(board[r][c] != w[0]): continue
            dfs((r,c), w[::-1], [[False for i in range(N)] for j in range(N)])
            if(found): found = False; break
        else:
            continue
        break

print(count)

