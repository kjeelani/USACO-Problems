fin = open("cowdance.in", "r")
fout = open("cowdance.out", "w")

from copy import deepcopy
'''
1.)Read data
2.)Set k=N and call show_finish() that returns a bool
	a.)this creates a PriorityQueue that takes in K amount of elements
	b.)then it continues to pop the lowest element, subtract it from t, and adding the next element until time is up.
	c.)if the initial list is empty, return true, else return False
3.)Do this until k finally returns false, then increment k by 1 and return it
'''

n, maxtime = map(int, fin.readline().rstrip().split(" "))
cowqueue = [int(fin.readline()) for i in range(n)]

def show_finish(k):
	temp, temp_time = deepcopy(cowqueue), maxtime
	stage = []
	for i in range(k):
		stage.append(temp.pop(0))
	while temp_time > 0:
		#print(stage, temp_time)
		x = min(stage)
		stage.remove(x)
		temp_time -= x
		for i in range(len(stage)):
			stage[i] -= x
		try:
			stage.append(temp.pop(0))
		except IndexError:
			return max(stage) <= temp_time
	return len(stage) == 0


k = 1
while True:
	if(show_finish(k)):
		break
	k += 1

fout.write(str(k) + "\n")
fout.close()
