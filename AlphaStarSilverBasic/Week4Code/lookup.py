'''
1.)Iterate through cows
    a.)If cow is not greater than current top of stack, keep it(index) in stack
    b.)Else remove from the stack, set that index to number and repeat a until condition is met
    c.)If condition cannot be met, set that index to 0
'''
from copy import copy
from sys import stdin
fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
n = int(fin.readline())
cows = [int(fin.readline()) for i in range(n)]
answerlist = [0 for i in range(n)]
cowstack = []

i = 0
while i < n:
    print(cowstack, i)
    if(cowstack == []):
        cowstack.append(copy(i))
        i += 1
        continue
    if(cows[cowstack[-1]] >= cows[i]):
        cowstack.append(copy(i))
        i += 1
    else:
        answerlist[cowstack.pop()] = i + 1

for a in answerlist:
    fout.write(str(a) + "\n")
fout.close()



    