fin = open("swap.in", "r")
fout = open("swap.out", "w")

'''
1.)Read data and create list
2.)
'''
n, m, k = map(int, fin.readline().rstrip().split())
cows = [i for i in range(n)]

def truepattern(l):
	tempcow = cows[:]
	for m in l:
		if(m[0] == 0):
			slic = tempcow[m[1]::-1]
		else:
			slic = tempcow[m[1]:m[0]-1:-1]
		tempcow[m[0]:m[1]+1] = slic
	return tempcow

instructions = truepattern([[int(x)-1 for x in fin.readline().rstrip().split()] for i in range(m)])

patternlist = [cows[:]]

for i in range(k):
	tempcow = [cows[e] for e in instructions]
	cows = tempcow
	#print(cows)
	if(cows == patternlist[0]):
		print(i)
		for e in patternlist[k%i+1]:
			fout.write(str(e+1) + "\n")
		fout.close()
		break
	else:
		patternlist.append(cows[:])
else:
	for e in cows:
		fout.write(str(e+1) + "\n")
	fout.close()


