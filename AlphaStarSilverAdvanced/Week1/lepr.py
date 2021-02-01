'''
1.) Read data
2.) Loop through each point in matrix
    a.) For each point, go 4 out of the 8 possible directions
        i.)Two diagonals in opposite directions as well as down and up
        ii.) During this loop, if you reach N-1, go back to 0
        and if you reach 0, go back to N-1
    b.)If there is a maximum, update it
'''

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
N = int(fin.readline()); maxR = -10**4
riches = [[int(x) for x in fin.readline().rstrip().split(' ')] for i in range(N)]

def go_down(coord):
    global maxR
    i = coord[0]; j = coord[1]
    tsum = riches[i][j]
    for k in range(N-1):
        maxR = max(tsum, maxR)
        i = (i + 1) % N
        tsum += riches[i][j]
    maxR = max(tsum, maxR)

def go_right(coord):
    global maxR
    i = coord[0]; j = coord[1]
    tsum = riches[i][j]
    for k in range(N-1):
        maxR = max(tsum, maxR)
        j = (j + 1) % N
        tsum += riches[i][j]
    maxR = max(tsum, maxR)
            
def go_diagonal_down(coord):
    global maxR
    i = coord[0]; j = coord[1]
    tsum = riches[i][j]
    for k in range(N-1):
        maxR = max(tsum, maxR)
        i = (i + 1) % N; j = (j + 1) % N
        tsum += riches[i][j]
    maxR = max(tsum, maxR)
        
        
def go_diagonal_up(coord):
    global maxR
    i = coord[0]; j = coord[1]
    tsum = riches[i][j]
    for k in range(N-1):
        maxR = max(tsum, maxR)
        i = (i - 1 + N) % N; j = (j + 1) % N
        tsum += riches[i][j]
    maxR = max(tsum, maxR)

for i in range(N):
    for j in range(N):
        go_down((i,j)); go_right((i,j)); go_diagonal_down((i,j)); go_diagonal_up((i,j))

print(str(maxR))
        