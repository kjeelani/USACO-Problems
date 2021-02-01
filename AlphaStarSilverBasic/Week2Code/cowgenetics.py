from sys import stdin

fin = open("textfiles/test.in", "r")
fout = open("textfiles/test.out", "w")
'''
For each cow/bull pairing, loop through all other cow/bulls and check if DNA matches
'''

n, m = map(int, fin.readline().rstrip().split(' '))
bulls = [(fin.readline().rstrip(), i) for i in range(n)]
cows = [(fin.readline().rstrip(), i+n) for i in range(m)]
totalcows = bulls + cows
countmatrix = [[0 for j in range(m)] for i in range(n)]

for b in range(n):
    curb = bulls[b]
    for c in range(m):
        curc = cows[c]
        tempc = 0
        for cow in totalcows:
            if(cow[1] != curb[1] and cow[1] != curc[1]):
                for char1, char2, char3 in zip(curb[0], curc[0], cow[0]):
                    #print(char1, char2, char3)
                    if(not(char3 == char2 or char3 == char1)):
                        break
                else:
                    tempc += 1
                print("\n")
        countmatrix[b][c] = str(tempc)

#print(totalcows)

for row in countmatrix:
    fout.write(" ".join(row) + "\n")
fout.close()
