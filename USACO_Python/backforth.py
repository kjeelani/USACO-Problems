fin = open("backforth.in", "r")
fout = open("backforth.out", "w")

blist1, blist2 = [int(x) for x in fin.readline().rstrip().split(' ')], [int(x) for x in fin.readline().rstrip().split(' ')]
tankset = set()

def combinations(l1, l2, tank, day):
	global c
	if(day == 5): tankset.add(tank); return; 
	if(day % 2 == 1):
		for i in range(10):
			tl1 = l1[:]
			tl1.pop(i); combinations(tl1, l2+[l1[i]], tank-l1[i], day+1)
	else:
		for i in range(11):
			tl2 = l2[:]
			tl2.pop(i); combinations(l1 + [l2[i]], tl2, tank+l2[i], day+1)


combinations(blist1, blist2, 1000, 1)
fout.write("{}\n".format(len(tankset))); fout.close()