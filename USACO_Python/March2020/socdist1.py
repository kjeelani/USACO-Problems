"""
ID: kaif.aj1
LANG: PYTHON3
PROG: socdist1
"""
#init
from math import ceil, floor
fin = open("socdist1.in", "r")
fout = open("socdist1.out", "w")
nstalls = int(fin.readline().rstrip())
stall = list(fin.readline().rstrip())
curr_dist, curr_dist2 = 0, 0
print(stall)

#main
if('1' not in stall):
	td = len(stall)-2
else:
	clist = []
	c = 0
	for i in range(nstalls):
		if(stall[i] == '0'):
			c += 1
		else:
			clist.append(c)
			c = 0
	clist.append(c)
	clist.sort()
	print(clist)
	td = ceil(clist[-2]/2)
	if(clist[-1] > 4):
		temp_td = floor((clist[-1]+1)/3)
		if(temp_td>td):
			td = temp_td
	
	#special case
	sc1, sc2 = 0, 0
	for i in range(nstalls):
		if(stall[i] == '0'):
			sc1 += 1
		else: 
			break
	for i in range(nstalls):
		if(stall[-i] == '0'):
			sc2 += 1
		else: 
			break
	if(sc1>td and sc2>td):
		td = min(sc1,sc2)
if(td == 0):
	td = 1
# for i in range(nstalls):
# 	if(stall[i] == '0' and i != pos1):
# 		dist = min([dist_back(i), dist_forw(i)])
# 		if(dist > curr_dist2):
# 			curr_dist2 = dist
# 			pos2 = i

fout.write(str(td) + '\n')
fout.close()
