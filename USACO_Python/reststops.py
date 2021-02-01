fin = open("reststops.in", "r")
fout = open("reststops.out", "w")

'''
1.)Read data
2.)Sort the stop list by tastiness and then iterate over it
	a.)For each element, check to see if its previous element is behind it in position. If it is, then append it to a new list. If not, then ignore it
3.)Now, use a function to simulate the walk with the optimal amount of stops within the newly modified tastiness list
4.)Return the total tastiness
'''
total_distance, n, frate, brate = map(int, fin.readline().rstrip().split(" "))

def optimal_stops(l):
	newl = [l[0]]
	for i in range(n):
		if(i == 0):
			continue
		if(newl[-1][0] < l[i][0]):
			newl.append(l[i])
	return newl

def sec(v):
	return v[1]

tastylist = [[int(x) for x in fin.readline().rstrip().split(" ")] for i in range(n)]
tastylist.sort(key=sec,reverse=True)
tastylist = optimal_stops(tastylist)

btime, tastiness, prevstop = 0, 0, 0
for stop in tastylist:
	ftime = stop[0] * frate
	btime += (stop[0] - prevstop) * brate
	prevstop = stop[0]
	stoptime = ftime-btime
	tastiness += (stoptime) * stop[1]
	btime += stoptime
	#print(btime, ftime)

fout.write(str(tastiness) + "\n")
fout.close()
