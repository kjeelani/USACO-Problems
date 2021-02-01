"""
ID: kaif.aj1
LANG: PYTHON3
PROG: combo
"""
#init
fin = open("combo.in", "r")
fout = open("combo.out", "w")
ndials = int(fin.readline().rstrip())
act_comb, master_comb = [int(e) for e in fin.readline().rstrip().split(' ')], [int(e) for e in fin.readline().rstrip().split(' ')]
temp_combinations = []
#main
def combinationator(c):
	global temp_combinations
	for i in range(-2,3):
		if(c[0]+i>ndials or c[0]+i<1):
			if(c[0]+i>ndials):
				n1 = c[0]-ndials+i
			else:
				n1 = ndials+c[0]+i
		else:
			n1 = c[0]+i
		for j in range(-2,3):
			if(c[1]+j>ndials or c[1]+j<1):
				if(c[1]+j>ndials):
					n2 = c[1]-ndials+j
				else:
					n2 = ndials+c[1]+j
			else:
				n2 = c[1]+j
			for k in range(-2,3):
				if(c[2]+k>ndials or c[2]+k<1):
					if(c[2]+k>ndials):
						n3 = c[2]-ndials+k
					else:
						n3 = ndials+c[2]+k
				else:
					n3 = c[2]+k
				if(n1<=ndials and n1>0 and n2<=ndials and n2>0 and n3<=ndials and n3>0):
					temp_combinations.append([n1,n2,n3])

combinationator(act_comb)
combinationator(master_comb)

combinations = []
for e in temp_combinations:
	if(e not in combinations):
		combinations.append(e)
combinations.sort()
for i in combinations:
	print(i)

fout.write(str(len(combinations))+ '\n')
fout.close()
