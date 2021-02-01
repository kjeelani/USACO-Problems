'''
1.) Sort data given
2.) Use combination method
    a.) For each branch, make sure that we are starting from the correct index to branch out
    b.) Also keep track of number of constants and vowels in the digit generation
    
'''
from sys import stdin

fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
L, N = map(int, fin.readline().rstrip().split(' '))
chars = sorted(fin.readline().rstrip().split(' '))
vowels = "aeiou"
wordlist = []

def find_comb(strbuild, prevI, vcount, ccount):
    if(len(strbuild) == L):
        if(vcount >= 1 and ccount >= 2): wordlist.append(strbuild)
        return
    for i in range(prevI+1, N):
        if(chars[i] in vowels): find_comb(strbuild + chars[i], i, vcount + 1, ccount)
        else: find_comb(strbuild + chars[i], i, vcount, ccount + 1)
            

find_comb("", -1, 0, 0)

for w in wordlist:
    print(w)