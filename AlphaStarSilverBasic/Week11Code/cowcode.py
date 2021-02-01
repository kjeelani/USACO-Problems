'''
1.) We multiply original length of string by 2 until it is larger than N
2.) Recursively narrow down N
    a.) Use formula N %= (L/2 + 1). If N = L / 2, then N = N - 1
    b.) Do this while N is greater tha original string length
'''
from sys import stdin

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
data = fin.readline().rstrip().split(' ')
word, N = data[0], int(data[1])-1
L = len(word)
print(N)

while L < N:
    L *= 2

while N >= len(word):
    if(N == L//2): N -= 1
    else: N %= (L//2 + 1) 
    L /= 2
print(word[N])