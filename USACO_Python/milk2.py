"""
ID: kaif.aj1
LANG: PYTHON3
PROG: milk2
"""
#init
fin = open("milk2.in", "r")
fout = open("milk2.out", "w")
numintervals = int(fin.readline())
intervals = []
nomilk_int = 0
yesmilk_int = 0
for i in range(numintervals):
	s, e = map(int, fin.readline().rstrip().split(' '))
	intervals.append([s,e])
intervals.sort()
for i in intervals:
	print(i[0], i[1])

#main
#if there is only one interval

#longest period with no milk
greatest_time = 0
for i in range(numintervals-1):
	if(greatest_time < intervals[i][1]):
		greatest_time = intervals[i][1]
	if(greatest_time < intervals[i+1][0]):
		tempmilk = intervals[i+1][0] - greatest_time
		if(tempmilk > nomilk_int):
			nomilk_int = tempmilk

#longest period of time with milk
yesmilk_tempint = 0
head, tail = intervals[0][0], intervals[0][1]
for i in range(numintervals-1):
	if(intervals[i][1] >= intervals[i+1][0] or tail >= intervals[i+1][0]):
		if(tail <= intervals[i+1][1]):
			tail = intervals[i+1][1]
	else:
		temp_temp = tail - head
		if(temp_temp > yesmilk_tempint):
			print("-----")
			print(head, tail)
			print("-----")
			yesmilk_tempint = temp_temp
		try:
			head = intervals[i+1][0]
			tail = intervals[i+1][1]
		except:
			head = intervals[i+1][0]
			tail = intervals[i][1]

#if there is one interval encompassing all other intervals
temp_temp = tail - head
if(temp_temp > yesmilk_tempint):
	yesmilk_tempint = temp_temp
yesmilk_int = yesmilk_tempint

if(numintervals == 1):
	fout.write(str(intervals[0][1] - intervals[0][0]) + " " + str(0) + "\n")
else:
	fout.write(str(yesmilk_int) + " " + str(nomilk_int) + "\n")
fout.close()
