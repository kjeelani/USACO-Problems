"""
ID: kaif.aj1
LANG: PYTHON3
TASK: transform
"""
fin = open("transform.in", "r")
fout = open("transform.out", "w")
n = int(fin.readline())
tile_matrixB = []
tile_matrixA = []
for i in range(n):
    tile_matrixB.append(fin.readline().rstrip())
for i in range(n):
    tile_matrixA.append(fin.readline().rstrip())

#write a function that checks for 90, 180, 270 degrees rotation as well as reflection and combination
def ro90(l):
    transform = []
    for a in range(n):
        s = ""
        for b in range(n):
            s += l[n-1-b][a]
        transform.append(s)
    return transform

def ro180(l):
    transform = []
    for a in range(n):
        s = ""
        for b in range(n):
            s += l[n-1-a][n-1-b]
        transform.append(s)
    return transform

def ro270(l):
    transform = []
    for a in range(n):
        s = ""
        for b in range(n):
            s += l[b][n-1-a]
        transform.append(s)
    return transform

def refl(l):
    transform = []
    for a in range(n):
        s = ""
        for b in range(n):
            s += l[a][n-1-b]
        transform.append(s)
    return transform

def comb(l):
    transform = refl(l)
    if(ro90(transform) == tile_matrixA or ro180(transform) == tile_matrixA or ro270(transform) == tile_matrixA):
        return True
    else:
        return False
    

def __main__():
    #90
    if(ro90(tile_matrixB) == tile_matrixA):
        return 1
    elif(ro180(tile_matrixB) == tile_matrixA):
        return 2
    elif(ro270(tile_matrixB) == tile_matrixA):
        return 3
    elif(refl(tile_matrixB) == tile_matrixA):
        return 4
    elif(comb(tile_matrixB)):
        return 5
    elif(tile_matrixB == tile_matrixA):
        return 6
    else:
        return 7

fout.write(str(__main__()) + '\n')
fout.close()
