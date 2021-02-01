from sys import stdin as s

N = 7
numbers = [int(x) for x in s.readline().rstrip().split(' ')]
ans = []

for i in range(N):
	for j in range(i+1, N):
		for k in range(j+1, N):
			a = numbers[i]; b = numbers[j]; c = numbers[k]
			others = numbers[:]
			others.remove(a); others.remove(b); others.remove(c)
			if(a+b in others and b+c in others and c+a in others and a+b+c in others): ans = [a,b,c]; break
		else:
			continue
		break
	else:
		continue
	break
ans.sort()
print(ans[0], ans[1], ans[2])
