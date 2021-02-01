"""
ID: kaif.aj1
LANG: PYTHON3
PROG: beads
"""
fin = open("beads.in", "r")
fout = open("beads.out", "w")
#init
numbeads = int(fin.readline())
necklace = fin.readline().rstrip()
longest_chain = 0
necklace = necklace + necklace + necklace
#main
def longestchain(bead):
	'''takes parameter bead and returns the longest number of beads that can be collected'''
	behind_color = ''
	ahead_color = ''
	bead_counter = 0
	for i in range(numbeads):
		if(necklace[bead+i] != 'w'):
			ahead_color = necklace[bead+i]
			break
	for i in range(numbeads):
		if(necklace[bead-i-1] != 'w'):
			behind_color = necklace[bead-i-1]
			break
	for i in range(numbeads):
		if(necklace[bead+i] == 'w' or necklace[bead+i] == ahead_color):
			bead_counter += 1
		else:
			break
	for i in range(numbeads):
		if(necklace[bead-i-1] == 'w' or necklace[bead-i-1] == behind_color):
			bead_counter += 1
		else:
			break
	return bead_counter
	

for i in range(numbeads, numbeads*2):
	tb = longestchain(i)
	if(tb > longest_chain):
		longest_chain = tb

if(longest_chain > numbeads):
	longest_chain = numbeads
fout.write(str(longest_chain) + "\n")
fout.close()
