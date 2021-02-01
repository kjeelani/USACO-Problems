"""
ID: kaif.aj1
LANG: PYTHON3
PROG: blocks
"""
from string import ascii_lowercase

fin = open("blocks.in", "r")
fout = open("blocks.out", "w")
nrows = int(fin.readline())
blocklist = [fin.readline().rstrip().split(' ') for i in range(nrows)]
charnumlist = []
charcount = [0 for i in range(26)]

def remove_duplicates(p):
	'''returns a character list of a "set" version of p(a list of two words)'''
	mini_charcount1, mini_charcount2, truemini_charcount = [0 for i in range(26)], [0 for i in range(26)], [0 for i in range(26)]
	for char in p[0]:
		mini_charcount1[ascii_lowercase.index(char)] += 1
	for char in p[1]:
		mini_charcount2[ascii_lowercase.index(char)] += 1
	for n1, n2, i in zip(mini_charcount1, mini_charcount2, range(26)):
		if(n1 > n2):
			truemini_charcount[i] = n1
		else:
			truemini_charcount[i] = n2
	return truemini_charcount

for pair in blocklist:
	charnumlist.append(remove_duplicates(pair))

for i in range(26):
	sum = 0
	for num in [charnumlist[j][i] for j in range(nrows)]:
		sum += num
	charcount[i] = sum

for num in charcount:
	fout.write(str(num) + "\n")
fout.close()
