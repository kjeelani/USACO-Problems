fin = open("whereami.in", "r") 
fout = open("whereami.out", "w")



'''
1.)Read data
2.)Using O(n+n/2+n/3+...1), we can scan the list k letters at a time, and append them to a list. If we find a duplicate within the list, it is not our K. Or else, return K
'''

nmailboxes = int(fin.readline())
mailboxes = fin.readline().rstrip()
l, K = [], 0

for k in range(1, nmailboxes+1):
	for j in range(nmailboxes-k):
		#k+1 represents the length of substring
		l.append(mailboxes[j:j+k+1])
	if(len(set(l)) == len(l)):
		K = k + 1
		break
	else:
		l = []

fout.write(str(K) + "\n")
fout.close()
