'''
1.)For each character:
    a.)Call palindrome_lenth(i, i) (and palindrome_length(i, i+1) if a[i] = a[i+1])
    b.)Keep max counter as well as its starting index
2.)palindrome_length keeps a scanner starting from indices that goes outwards and ignores all punctuation
    a.)Return length of palindrome once scan is violated
3.)Return amx palindrome and a[i:i+maxcount+1]
'''
from sys import stdin
from string import ascii_letters
from time import time
fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
s = time()
message = "".join(fin.readlines())
n = len(message)
maxcounter, max_li, max_ri = 0, 0, 0
def findnextleft(index):
    while True:
        index -= 1
        if(index < 0):
            return None
        if(message[index] in ascii_letters):
            return index

def findnextright(index):
    while True:
        index += 1
        if(index > n-1):
            return None
        if(message[index] in ascii_letters):
            return index
    
def palindrome(si, ei):
    tempcount = 1
    l, r = si, ei
    if(si != ei):
        tempcount = 2
    while True:
        templ, tempr = findnextleft(l), findnextright(r)
        if(templ is None or tempr is None):
            return tempcount, l, r
        if(message[templ].lower() == message[tempr].lower()):
            tempcount += 2
            l, r = templ, tempr
        else:
            break
    return tempcount, l, r

for i in range(n):
    s = time()
    if(message[i] not in ascii_letters):
        continue
    next_i = findnextright(i)
    if(next_i is None):
        break
    if(message[i] == message[next_i]):
        count, si, ei = palindrome(i, next_i)
    else:
        count, si, ei = palindrome(i, i)
    
    if(count > maxcounter):
        maxcounter = count
        max_li, max_ri = si, ei
    print(time() - s)

fout.write(str(maxcounter) + "\n")
fout.write(message[max_li:max_ri+1])
