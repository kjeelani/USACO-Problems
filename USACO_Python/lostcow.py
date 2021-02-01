"""
ID: kaif.aj1
LANG: PYTHON3
PROG: lostcow
"""
fin = open("lostcow.in", "r")
fout = open("lostcow.out", "w")
x, y = map(int, fin.readline().rstrip().split(' '))
distance, xgry, currentx = 0, True, x

'''
1.)Find out if x is greater or less than y
2.)Create a recursive function that simulates x going back and forward by multiplying the distance parameter by -2.
3.)The exit condition will be when x is greater/less than y depending on #1
4.)Subtract the absolute value of x from y and subtract that value from the total distance to get your answer
'''
def find_distance():
	global currentx, distance
	position = 1
	while True:
		if(xgry):
			if(currentx <= y):
				distance -= (abs(currentx-y) + abs(position/-2))
				break
		else:
			if(currentx >= y):
				distance -= (abs(currentx-y) + abs(position/-2))
				break
		currentx = x
		currentx += position
		distance += abs(position) * 2
		position *= -2
		print(distance)

if(x > y):
	xgry = True
	find_distance()
	fout.write(str(int(distance)) + "\n")
	fout.close()
elif(x < y):
	xgry = False
	find_distance()
	fout.write(str(int(distance)) + "\n")
	fout.close()
else:
	fout.write(str(distance) + "\n")
	fout.close()
