'''
1.) Read data
2.) Loop through each character and check all 8 possibilities for three letter words
    a.) If a three letter word has two equal letters followed by a different letter,
    update it to a dictionary
    b.) Return the max of dict.values()
'''
from sys import stdin 



N, M = map(int, stdin.readline().rstrip().split(' '))
matrix = [stdin.readline().rstrip() for i in range(N)]
word_dict = {}

xypairs = [
    (0,1,0,2), (1,0,2,0), (0,-1,0,-2), (-1,0,-2,0),
    (1,1,2,2), (1,-1,2,-2), (-1,1,-2,2), (-1,-1,-2,-2)
]
for i in range(N):
    for j in range(M):
        for p in xypairs:
            if(not(0 <= i + p[2] < N and 0 <= j + p[3] < M)): continue
            c1, c2, c3 = matrix[i][j], matrix[i+p[0]][j+p[1]], matrix[i+p[2]][j+p[3]]
            if(c1 != c2 and c2 == c3 and c1 != "M" and c2 != "O"): 
                word = c1 + c2 + c3
                if word not in word_dict: word_dict[word] = 1
                else: word_dict[word] += 1

try: print(max(word_dict.values()))
except: print(0)          
                



     