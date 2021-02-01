"""
ID: kaif.aj1
LANG: PYTHON3
PROG: barn1
"""
#init
fin = open("barn1.in", "r")
fout = open("barn1.out", "w")
nboards, nstalls, ncows = map(int, fin.readline().rstrip().split(' '))
cow_stalls, gap_indices = [int(fin.readline().rstrip()) for i in range(ncows)], []
cow_stalls.sort()
print(cow_stalls)
total_length = 0

def sv(k):
	return k[1]

#main
for i in range(ncows-1):
	gap_indices.append([cow_stalls[i+1]-cow_stalls[i],i])
gap_indices.sort(reverse=True)
gap_indices = gap_indices[:(nboards-1)]
gap_indices.sort(key=sv)
print(gap_indices)
for e in range(len(gap_indices)+1):
	if(nboards == 1):
		total_length = cow_stalls[-1] - cow_stalls[0] + 1
		break
	if(e == 0):
		total_length += cow_stalls[gap_indices[0][1]] - cow_stalls[0]+1
	elif(e == len(gap_indices)):
		total_length += cow_stalls[-1] - cow_stalls[gap_indices[-1][1]+1]+1
	else:
		total_length += cow_stalls[gap_indices[e][1]] - cow_stalls[gap_indices[e-1][1]+1] + 1
	print(total_length)
fout.write(str(total_length) + '\n')
fout.close()
