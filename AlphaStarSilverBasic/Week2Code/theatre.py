from sys import stdin

fin = open("textfiles/test.in", "r")
fout = open("textfiles/test.out", "w")
'''
Sort by distance, row, then column, then fill in matrix and print
'''

x, y = map(int, fin.readline().rstrip().split(' '))
origin = (y-1, x//2)

def dist(x1, y1):
    return (origin[0] - y1) ** 2 + (origin[1] - x1) ** 2

def sk(v):
    return (v[0], -v[1], v[2])

coords = []

for i in range(y):
    for j in range(x):
        coords.append((dist(j, i), i, j))
coords.sort(key=sk)

theatre = [[0 for j in range(x)] for i in range(y)]
print(coords)

i = 0
for c in coords:
    i += 1
    theatre[c[1]][c[2]] = str(i)

for tr in theatre:
    fout.write(" ".join(tr) + "\n")
fout.close()

