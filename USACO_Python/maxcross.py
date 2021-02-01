fin = open("maxcross.in", "r")
fout = open("maxcross.out", "w")
'''
1.)Read and sort data
2.)For each element in array, find number of values of e + k. If it is lower than the maximum value, the replace it
3.)Return the lowest value
'''

n, k, b = map(int, fin.readline().rstrip().split(" "))
mint = 10 ** 10

tlist = [int(fin.readline()) for i in range(b)]
tlist.sort()

def find_len_above(i, m):
	'''i is the index to start and n is e + k'''
	t = 0
	for c in range(i+1, b+1):
		if(c >= b-1):
			if(n - tlist[-1] >= k):
				return 0
			else:
				return 10**10
		elif(m < tlist[c]):
			break
		t += 1
	return t

for i in range(b):
	x = find_len_above(i, tlist[i] + k)
	if(x < mint):
		mint = x

fout.write(str(mint) + "\n")
fout.close()
