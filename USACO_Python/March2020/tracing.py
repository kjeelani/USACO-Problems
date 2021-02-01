"""
ID: kaif.aj1
LANG: PYTHON3
PROG: tracing
"""
#init
fin = open("tracing.in", "r")
fout = open("tracing.out", "w")
ncows, nhandshakes = map(int, fin.readline().rstrip().split(' '))
cows = [False if e == '0' else True for e in list(fin.readline().rstrip())]
handshakes = [[int(e) for e in fin.readline().rstrip().split(' ')] for i in range(nhandshakes)]
handshakes.sort()
print(handshakes, cows)
npatients , lb, ub = 0, 1, 'Infinity'
cow_is_patient = [True if cows[i]==True else False for i in range(ncows)]

#main
infected = [False for i in range(ncows)]
handshake_count, klist= [0 for i in range(ncows)], [0 for i in range(ncows)]

for i in range(nhandshakes):
	x, y = handshakes[i][1]-1, handshakes[i][2]-1
	handshake_count[x]+=1 
	handshake_count[y]+=1
	if(cows[x] == False or cows[y] == False):
		if(not infected[x] and not infected[y]):
			cow_is_patient[x], cow_is_patient[x]  = False, False
		else:
			infected[x], infected[y] = True, True
		if(infected[x]==cows[x] and infected[y] == cows[y] and cows[x] != cows[y] and klist[i] == 0):
			klist[i] = handshake_count[i]
	else:
		infected[x], infected[y] = True, True

npatients = cow_is_patient.count(True)
klist = list(filter(lambda x: x!=0, klist))
if(len(klist) != 0):
	if(len(klist) == 1):
		lb = klist[0]
	else:
		lb = min(klist)
		ub = max(klist)
print(infected)
print(cow_is_patient)
print(klist)
fout.write("{} {} {}".format(str(npatients),str(lb),str(ub)) + '\n')
fout.close()
