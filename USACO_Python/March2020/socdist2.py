"""
ID: kaif.aj1
LANG: PYTHON3
PROG: socdist2
"""
#init
fin = open("socdist2.in", "r")
fout = open("socdist2.out", "w")
ncows = int(fin.readline().rstrip())
cows = [[int(e) for e in fin.readline().rstrip().split(' ')] for i in range(ncows)]
cows.sort()
r, mincows = 0, 1
print(cows)

#main
def find_r():
	temp_r = 1000000000
	for i in range(ncows):
		if(cows[i][1] == 0):
			if(i == 0):
				if(cows[i+1][1] == 1 and cows[i+1][0] - cows[i][0] < temp_r):
					temp_r = cows[i+1][0] - cows[i][0]
					#print(cows[i+1][0] - cows[i][0])
			elif(i == ncows-1):
				if(cows[i-1][1] == 1 and cows[i][0] - cows[i-1][0] < temp_r):
					temp_r = cows[i][0] - cows[i-1][0]
					#print(cows[i][0] - cows[i-1][0])
			else:
				x, y = cows[i+1][0] - cows[i][0], cows[i][0] - cows[i-1][0]
				if(cows[i-1][1] == 1 and cows[i+1][1] == 1):
					if(min(x, y) < temp_r):
						temp_r = min(x, y)
						#print(min(x,y))
				elif(cows[i-1][1] == 1):
					if(y < temp_r):
						temp_r = y
				elif(cows[i+1][1] == 1):
					if(x < temp_r):
						temp_r = x
	return temp_r-1

#everything above here is working

# def check_slice(sl):
# 	if(1 in [sl[x][1] for x in range(len(sl))]):
# 		return True
# 	else:
# 		return False

r = find_r()
print(r)
filtered_cows = list(filter(lambda x: x[1] == 1, cows))
print(filtered_cows)
for i in range(len(filtered_cows)):
	if(i == 0):
		pass
	else:
		if(filtered_cows[i][0]-filtered_cows[i-1][0] > r):
			mincows += 1

fout.write(str(mincows) + "\n")
fout.close()
