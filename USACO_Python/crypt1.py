"""
ID: kaif.aj1
LANG: PYTHON3
PROG: crypt1
"""
#init
fin = open("crypt1.in", "r")
fout = open("crypt1.out", "w")
lenset = int(fin.readline().rstrip())
solution = 0
nset = [int(e) for e in fin.readline().rstrip().split(' ')]

#main
def partial_product(big, small):
	new = big * small
	if(len(str(new)) != 3):
		return False
	for i in str(new):
		if(int(i) not in nset):
			return False
			break
	return True

def final_product(big, s2, s1):
	new = big*s1 + 10*(big*s2)
	if(len(str(new)) != 4):
		return False
	for i in str(new):
		if(int(i) not in nset):
			return False
			break
	return True

nset.sort()
#print(nset)
#c=0
for n1 in nset:
	for n2 in nset:
		for n3 in nset:
			for n4 in nset:
				for n5 in nset:
					#c+=1
					num1 = n1*100 + n2*10 + n3
					num2 = n4*10 + n5
					if(num1<100 or num2<10):
						continue
					if(not(partial_product(num1, n4) and partial_product(num1, n5))):
						continue
					if(final_product(num1, n4, n5)):
						solution += 1
#print(c)
#print(final_product(315, 1, 1))
fout.write(str(solution) + '\n')
fout.close()
