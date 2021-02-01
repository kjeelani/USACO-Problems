fin = open("crossroad.in", "r")
fout = open("crossroad.out", "w")

'''
1.)Read all data
2.)Make a crossing_count variable
3.)Create a for loop that iterates through the input:
	a.)If the sighting is the first time, add it to our crossing_list var with its number and side
	b.)If the sighting is not the first time, then check to see if the sighting in crossing_list is different from the input
		i.)If it is, update crossing_list and crossing_count
4.)output the value of crossing_count
'''

ncows = int(fin.readline())
cow_sightings = [[int(y) for y in fin.readline().rstrip().split(' ')] for x in range(ncows)]
crossing_dict, crossing_count = {}, 0

for sighting in cow_sightings:
	if(sighting[0] in crossing_dict.keys()):
		if(crossing_dict[sighting[0]] != sighting[1]):
			crossing_dict[sighting[0]] = sighting[1]
			crossing_count += 1
	else:
		crossing_dict[sighting[0]] = sighting[1]

fout.write(str(crossing_count) + "\n")
fout.close()
