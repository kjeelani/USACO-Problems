from sys import stdin as s



N = int(s.readline())
cows = sorted([int(x) for x in s.readline().rstrip().split(' ')])
stalls = sorted([(int(x), []) for x in s.readline().rstrip().split(' ')])
fixed = [False for i in range(N)]
ans = 1

for i in range(N):
	for st in stalls:
		if(st[0] >= cows[i]): st[1].append(i)

for st in stalls:
	notfixed = 0
	firstFix = True
	for c in st[1]:
		if(not fixed[c]): 
			if(firstFix): fixed[c] = True; firstFix = False
			notfixed += 1
	ans *= notfixed

print(ans)

