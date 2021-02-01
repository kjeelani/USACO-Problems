fin = open("hps.in", "r")
fout = open("hps.out", "w")

'''
1.)Read data
2.)Find opposite string of John's string using a predetermined dict and create two dicts to represent bessie doing one action and bessie doing another
3.)For each splicer(which gets incrmeented every iteration), find the maximum value of wins that Bessie can get for each splice
	a.)If the two lists have the same action, go with the on that has the most wins
4.)Return max wins
'''
n = int(fin.readline())
opposite = {"H":"P", "S":"H", "P":"S"}
beat_john_list = [opposite[fin.readline().rstrip()] for i in range(n)]
start_actions, end_actions = {"H":0, "S":0, "P":0}, {"H":0, "S":0, "P":0}
maxwins = 0

for e in beat_john_list:
	end_actions[e] += 1

def sec(v):
	return v[1]

def find_maxwins():
	sl, el = list(start_actions.items()), list(end_actions.items())
	sl.sort(key=sec)
	el.sort(key=sec)
	if(sl[2][0] == el[2][0]):
		if(sl[2][1] > el[2][1]):	
			return sl[2][1] + el[1][1]
		else:
			return sl[1][1] + el[2][1]
	else:
		return sl[2][1] + el[2][1]

	




for i in range(n):
	w = beat_john_list[i]
	start_actions[w] += 1
	end_actions[w] -= 1
	x = find_maxwins()
	if(x > maxwins):
		maxwins = x

fout.write(str(maxwins) + "\n")
fout.close()
