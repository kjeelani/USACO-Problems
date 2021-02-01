'''
1.) Create telephone dict and read data
2.) Find all combinations of words, and for each word, do a bianry search to check if its valid
3.) Print all possible words sorted
'''
from sys import stdin 

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
S = fin.readline().rstrip()
N = len(S)
telephone = {"2":"ABC", "3":"DEF", "4":"GHI", "5":"JKL", "6":"MNO", "7":"PRS", "8":"TUV", "9":"WXY"}
words = sorted(fin.read().split("\n"))
W = len(words)
valid_words = []

def valid(w):
    low, high, mid = 0, W-1, 0
    while low <= high: 
        mid = (high + low) // 2
        if words[mid] < w: 
            low = mid + 1
        elif words[mid] > w: 
            high = mid - 1
        else: 
            return True
    return False 


def combination(strbuild, pos):
    if(pos == N):
        if(valid(strbuild)): valid_words.append(strbuild)
        return
    for char in telephone[S[pos]]:
        combination(strbuild + char, pos + 1)

combination("", 0)

valid_words.sort()
if(len(valid_words) == 0): print("NONE")
for w in valid_words: print(w) 