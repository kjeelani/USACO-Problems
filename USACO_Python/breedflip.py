fin, fout = open("breedflip.in", "r"), open("breedflip.out", "w")

N = int(fin.readline())
A, B = fin.readline(), fin.readline()

flips = 0
isDifferent = False
for l1, l2 in zip(A,B):
	if(l1 != l2):
		if(not isDifferent): 
isDifferent = True
flips += 1
	else:
		if(isDifferent): 
			isDifferent = False

fout.write("{}\n".format(flips)); 
fout.close()


