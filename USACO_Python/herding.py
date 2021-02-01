"""
ID: kaif.aj1
LANG: PYTHON3
PROG: herding
"""
from copy import deepcopy
#init
fin = open("herding.in", "r")
fout = open("herding.out", "w")
c1, c2, c3 = map(int, fin.readline().rstrip().split(' '))
clist = [c1,c2,c3]

#main
def consecutive(l):
	'''checks if the list has consecutive numbers'''
	if(l[0]+1 == l[1] and l[1]+1 == l[2]):
		return True
	else:
		return False

def minimum(l):
	'''finds the minimum number of moves until cows reach consecutive positions'''
	moves = 0
	if(consecutive(l)):
		moves = 0
	elif(l[1] - l[0] > 2 or l[2] -l[1] > 2):
		moves = 2
	else:
		moves = 1
	return moves

def maximum(l):
	'''finds the maximum number of moves until cows reach consecutive positions'''
	moves = 0
	if(consecutive(l)):
		moves = 0
	elif(l[1] - l[0] > l[2] - l[1]):
		moves = l[1]-l[0] - 1
	else:
		moves = l[2]-l[1] - 1
	return moves

mini, maxi = minimum(deepcopy(clist)), maximum(deepcopy(clist))
fout.write(str(mini) + '\n')
fout.write(str(maxi) + '\n')
fout.close()


