fin = open("lifeguards.in", "r")
fout = open("lifeguards.out", "w")

'''
1.)Read data into vars
2.)Sort timings
3.)Loop through all the timings:
	a.)For each timing range, calculate the total overlap from all other lifeguards
	b.)If it is greater than current maximum, replace
4.)Output maximum
'''

ncows = int(fin.readline())
timings = [[int(e) for e in fin.readline().rstrip().split(' ')] for i in range(ncows)]
max_overlap, deleted_timing, deleted_index = 0, [], 0

timings.sort()

def find_max_distance():
	distance = 0
	start, end = 0, 0
	for i in range(ncows-1):
		if(i == 0):
			start, end = timings[i][0], timings[i][1]
		elif(timings[i][0] > end):
			distance += end - start
			start, end = timings[i][0], timings[i][1]
		else:
			end = timings[i][1]
	distance += end - start
	return distance

for i in range(ncows):
	deleted_timing, deleted_index = timings[i], i
	del timings[i]
	print("After deletion:", timings)
	total_overlap = find_max_distance()
	timings.insert(deleted_index, deleted_timing)
	print("After insertion:", timings)
	if(total_overlap > max_overlap):
		max_overlap = total_overlap

print(max_overlap)

fout.write(str(max_overlap) + "\n")
fout.close()
