from sys import stdin as s


s1, s2 = s.readline().lower().rstrip(), s.readline().lower().rstrip()

i, ans, x = 0, 0, True
while x:
	ans += 1
	for j in range(26):
		if(s2[i] == s1[j]):
			i += 1
			if(i >= len(s2)): x= False; break

print(ans) 