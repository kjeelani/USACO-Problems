"""
ID: kaif.aj1
LANG: PYTHON3
PROG: buckets
"""
#init
fin = open("buckets.in", "r")
fout = open("buckets.out", "w")
city_arr = [fin.readline().rstrip() for i in range(10)]
rock, barn, lake = [], [], []
ncows = 0
for r in range(10):
	for c in range(10):
		if(city_arr[r][c] == 'B'):
			barn = [c,r]
		elif(city_arr[r][c] == 'L'):
			lake = [c,r]
		elif(city_arr[r][c] == 'R'):
			rock = [c,r]
print(rock, lake, barn)

def check_direction():
	if(barn[0] > lake[0]):
		if(barn[1] > lake[1]):
			return [-1,-1]
		else:
			return [-1, 1]
	else:
		if(barn[1] > lake[1]):
			return [1, -1]
		else:
			return [1, 1]

vector = check_direction()


#main
while True:
	if(barn[0] == lake[0]):
		barn[1] += vector[1]
		ncows += 1
		if(barn == rock):
			ncows += 2
	elif(barn[1] == lake[1]):
		barn[0] += vector[0]
		ncows += 1
		if(barn == rock):
			ncows += 2
	else:
		barn[0], barn[1] = barn[0] + vector[0], barn[1] + vector[1]
		ncows += 2
	print(barn, ncows)
	if(barn == lake):
		break
fout.write(str(ncows-1) + "\n")
fout.close()
