"""
ID: kaif.aj1
LANG: PYTHON3
PROG: ride
"""
from string import ascii_uppercase
fin = open("ride.in", "r")
fout = open("ride.out", "w")
word1 = fin.readline().rstrip()
word2 = fin.readline().rstrip()
word1sum = 1
word2sum = 1
for i in range(len(word1)):
    word1sum *= ascii_uppercase.index(word1[i]) + 1
for j in range(len(word2)):
    word2sum *= ascii_uppercase.index(word2[j]) + 1
if(word1sum % 47 == word2sum % 47):
    fout.write("GO" + '\n')
else:
    fout.write("STAY" + '\n')
fout.close()
