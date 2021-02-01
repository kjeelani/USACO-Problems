fin = open("cowcode.in", "r")
fout = open("cowcode.out", "w")
from copy import deepcopy
'''
1.)Read data
2.)The code below is not efficent whatsover, and is used as a test
'''

def nothing():
	pass

l = fin.readline().rstrip().split(" ")
n, code = int(l[1]), list(l[0])

lenstr = len(code)
print(lenstr)
while lenstr < n:
	temp = code[:]
	temp.insert(0, temp.pop(-1))
	code.extend(temp)
	lenstr *= 2
	print(code)

fout.write(code[n-1] + "\n")
fout.close()
