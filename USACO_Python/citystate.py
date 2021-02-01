fin = open("citystate.in", "r")
fout = open("citystate.out", "w")

'''
1.)Read data and crop city into a two character string
2.)Create a copy of the list flipped
3.)Use a dictionary to keep track of how many different pairings there are
4.)For each dictionary, add (n-1)! to the total pairing counts
NOT SOLVED
'''

def invert_cols_of_matrix(m):
	temp = []
	for e in m:
		temp.append(e[::-1])
	return temp

ncities = int(fin.readline())
city_dict = {}
for i in range(ncities):
	x = fin.readline().rstrip().split(" ")
	x[0] = x[0][:2]
	x = tuple(x)
	if(city_dict.get(x, "n") == "n"):
		city_dict[x] = 1
	else:
		city_dict[x] += 1
#print(city_dict)
total_pairs = 0

c=0
for e in city_dict.keys():
	try:
		if(e[0] != e[1]):
			total_pairs += city_dict[e[::-1]] * city_dict[e] 
			c+=1
	except KeyError:
		pass
print(c)

#print(citylist)
#print(flipped_citylist)

fout.write(str(int(total_pairs//2)) + "\n")
fout.close()



