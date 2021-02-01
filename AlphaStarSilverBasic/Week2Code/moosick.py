from sys import stdin

fin = open("textfiles/test.in", "r")
fout = open("textfiles/test.out", "w")
'''
Sort C chord then check all notes while sorting them to see if the gap matches the C chord
'''

n = int(fin.readline())
notes = [int(fin.readline()) for i in range(n)]
c = int(fin.readline())
chord = sorted(int(fin.readline()) for i in range(c))
count, countindex = 0, []

s, e = 0, c
while e <= n:
    potential_chord = sorted(notes[s:e])
    for i in range(1, c):
        if(potential_chord[i] - potential_chord[i-1] == chord[i] - chord[i-1]):
            continue
        break
    else:
        count += 1
        countindex.append(s)
    s += 1
    e += 1

fout.write(str(count) + "\n")
for e in countindex:
    fout.write(str(e+1) + "\n")
fout.close()

