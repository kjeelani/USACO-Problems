fin = open("sort.in", "r")
fout = open("sort.out", "w")

from copy import deepcopy

'''
1.)Read data(for each item initialize a tuple with data and position)
2.)Create a copy of a list and sort it by data
3.)For each element (x, y), subtract y-x and return the greatest difference
'''

n = int(fin.readline())
arr = [(int(fin.readline()), i) for i in range(n)]
copyarr = deepcopy(arr)
copyarr.sort()
moo_counter = 0

for e, i in zip(copyarr, range(n)):
	dif = e[1] - i
	if(dif > moo_counter):
		moo_counter = dif
	
fout.write(str(moo_counter+1) + "\n")
fout.close()
