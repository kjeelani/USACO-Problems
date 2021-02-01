fin = open("lifeguards.in", "r")
fout = open("lifeguards.out", "w")


'''
1.)Read data
2.)Calculate the total time the lifeguards take up without one missing
3.)For each cow:
	a.)Find the amount of time the cow DOES NOT overlap and store it to a var with the value of the cow with the minimum overlap
4.)Return total distance minus minimum overlap
'''
ncows = int(fin.readline())
timings = [[int(e) for e in fin.readline().rstrip().split(' ')] for i in range(ncows)]
timings.sort()
total_time, minimum_cow = 0, 10**10 + 4


start, end = 0, 0
for i in range(ncows):
	non_overlap = timings[i][1] - timings[i][0]
	if(i == 0):
		start, end = timings[i][0], timings[i][1]
		if(timings[i+1][0] < timings[i][1]):
			non_overlap += timings[i][1] - timings[i+1][0]
		if(non_overlap < minimum_cow):
			minimum_cow = non_overlap
		continue
	
	elif(timings[i][0] > end):
		total_time += end - start
		start, end = timings[i][0], timings[i][1]
	elif(timings[i][1] > end):
		end = timings[i][1]

	if(i == ncows-1):
		if(timings[i-1][1] > timings[i][0]):
			non_overlap -= timings[i-1][1] - timings[i][0]
	else:
		if(timings[i-1][1] > timings[i][0]):
			non_overlap -= timings[i-1][1] - timings[i][0]
		if(timings[i+1][0] < timings[i][1]):
			non_overlap -= timings[i][1] - timings[i+1][0]

		
	if(non_overlap < minimum_cow and not non_overlap <= 0):
		minimum_cow = non_overlap
	elif(non_overlap <= 0):
		minimum_cow = 0

total_time += end - start
print(minimum_cow)

fout.write(str(total_time-minimum_cow) + "\n")
fout.close()
