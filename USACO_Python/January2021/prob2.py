from sys import stdin as s


N = int(s.readline())
#Even is True, Odd is False
evens, odds = 0, 0
for x in s.readline().rstrip().split(' '):
	if(int(x) % 2 == 0): evens += 1
	else: odds += 1

isEven = True
groups = 0
while True:
	if(isEven):
		if(evens > 0): evens -= 1
		elif(odds > 1): odds -= 2
		else: break
	else:
		if(odds > 0): odds -= 1
		else: break
	groups += 1
	isEven = not isEven

if(odds == 1 and isEven): groups -= 1
print(groups)

