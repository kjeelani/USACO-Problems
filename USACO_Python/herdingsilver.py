fin = open("herding.in", "r")
fout = open("herding.out", "w")
from math import ceil
'''
1.)Read data, sort data, and create prefix sum
2.)To find minimum, return ceil(n/2)
3.)To find maximum, sum up all elements in prefix sum, and return maximum of sum-l[0] and sum-l[-1]
'''

n = int(fin.readline())

def prefix(l):
	newl = []
	for i in range(n-1):
		newl.append(l[i+1]-l[i]-1)
	return newl

gaps = prefix(sorted([int(fin.readline()) for i in range(n)]))
sumgaps = sum(gaps)

fout.write("{}\n".format(str(n//2)))
fout.write("{}\n".format(str(max(sumgaps-gaps[0], sumgaps-gaps[-1]))))
fout.close()
