fin = open("shuffle.in", "r")
fout = open("shuffle.out", "w")
from copy import deepcopy

'''
1.)Store line 2 as index list
2.)Store line 3 as cowlist
3.)Rearrange cowlist based on the index list
'''

ncows = int(fin.readline())
indexlist = [int(e) for e in fin.readline().rstrip().split(' ')]
cowlist = fin.readline().rstrip().split(' ')
ordered_cowlist = []

for i in range(3):
	print(cowlist)
	for i in range(ncows):
		correct_index = indexlist[i] - 1
		ordered_cowlist.append(cowlist[correct_index])
	cowlist = deepcopy(ordered_cowlist)
	ordered_cowlist = []
print(cowlist)

for cow in cowlist:
	fout.write(cow + "\n")
fout.close()
