fin = open("homework.in", "r")
fout = open("homework.out", "w")

'''
1.)Read data
2.)Create a maximumK list and a maximumaverage var
3.)Create a for loop that:
	a.)Will slice the list of the first K values and remove the lowest value
	b.)Get the average of that list and compare it with maximumaverage
		i.)If equal to maximumaverage, append thr K value to the maximumK list
		ii.)If greater than maximumaverage, clear maximumK list and append the new K value
4.)Output all data in maximum K list to file

NOTE: THIS SOLUTION WORKS< BUT NOT IN THE BOUNDS GIVEN
'''
nscores = int(fin.readline())
scores = [int(e) for e in fin.readline().rstrip().split(' ')]
maxK, maxaverage = [], 0

def find_average(l):
	return sum(l)/len(l)

for i in range(1, nscores-2):
	sliced_scores = scores[i:]
	sliced_scores.remove(min(sliced_scores))
	average = find_average(sliced_scores)
	if(average == maxaverage):
		maxK.append(i)
	elif(average > maxaverage):
		maxaverage = average
		maxK = [i]

for k in maxK:
	fout.write(str(k) + "\n")
fout.close()
