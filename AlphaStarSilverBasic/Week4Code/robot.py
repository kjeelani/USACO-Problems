'''
1.)Create a queue of numbers from 1 to n
2.)For each operation, simulate it in a stack
3.)Finally after all operations, return length of stack
and all numbers from the stack in order
'''
from copy import copy
fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
n = int(fin.readline())
commands = [fin.readline().rstrip() for i in range(n)]
haybales, c = [], 1

for cmd in commands:
    if(cmd == "ADD"):
        haybales.append(c)
        c += 1
    else:
        haybales.pop()

fout.write(str(len(haybales)) + "\n")
for h in haybales:
    fout.write(str(h) + "\n")
fout.close()