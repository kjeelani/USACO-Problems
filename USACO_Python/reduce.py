fin = open("reduce.in", "r")
fout = open("reduce.out", "w")
from copy import deepcopy

'''
1.)Read data into vars
2.)Find the area of a rectangle with the minimum x coord removed, minimum y coord removed, maximum x coord removed, and maximum y coord removed
	a.)To do this, subtract max by min x, max y by min y, and mutliply two areas together
3.)The smallest area gets outputted
'''
def second(val):
	return val[1]

ncows = int(fin.readline())
coordinates = [[int(x) for x in fin.readline().rstrip().split(' ')] for i in range(ncows)]
c1, c2, c3, c4 = deepcopy(coordinates), deepcopy(coordinates), deepcopy(coordinates), deepcopy(coordinates)
c1.remove(min(c1, key= lambda item: item[0]))
c2.remove(max(c2, key= lambda item: item[0]))
c3.remove(min(c3, key= lambda item: item[1]))
c4.remove(max(c4, key= lambda item: item[1]))

def find_area(coords):
	xlist, ylist = [x[0] for x in coords], [x[1] for x in coords]
	minX, maxX = min(xlist), max(xlist)
	minY, maxY = min(ylist), max(ylist)
	print(maxX, minX, maxY, minY)
	return (maxX-minX) * (maxY-minY)


area_list = [find_area(c1), find_area(c2), find_area(c3), find_area(c4)]
print(area_list)

fout.write(str(min(area_list)) + "\n")
fout.close()
