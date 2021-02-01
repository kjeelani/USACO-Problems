fin = open("traffic.in", "r")
fout = open("traffic.out", "w")
from collections import deque
'''
1.)Read data
	a.)While reading data, if data.traffic is None, increase the window until it is not None, then use a union function and insert that into list
2.)Process each sensor group into a "prefix sum" keeping track of the width of the interval until end
3.)Find min and max intervals and return them
'''
class Sensor():

	def __init__(self, sensordata):
		self.type = sensordata[0]
		self.min = int(sensordata[1])
		self.max =  int(sensordata[2])

	def __repr__(self):
		return "{}:{}-{}".format(self.type, self.min, self.max)



n = int(fin.readline())
sensors = [Sensor(fin.readline().rstrip().split()) for i in range(n)]

#print(sensors)

def combine(s1, s2, typ):
	if(typ == "b"):
		if(s2.type == "off"):
			return Sensor(["none",s1.min+s2.min, s1.max+s2.max])
		else:
			return Sensor(["none", s1.min-s2.max, s1.max-s2.min])
	else:
		if(s2.type == "off"):
			return Sensor(["none", s1.min-s2.max, s1.max-s2.min])
		else:
			return Sensor(["none",s1.min+s2.min, s1.max+s2.max])
def union(l):
	return Sensor(["none", 
					max([x.min for x in l]), 
					min([x.max for x in l])]
	)

#finding min interval
cS = None
for i in range(n-1, -1, -1):
	tempS = sensors[i]
	if cS is None:
		if(tempS.type == "none"):
			cS = tempS
		continue
	if(tempS.type == "none"):
		cS = union([cS, tempS])
	else:
		cS = combine(cS, tempS, "b")
	#print(cS)

print("---")
def ma(s):
	if(s < 0):
		return 0
	else:
		return s

fout.write("{} {}\n".format(ma(cS.min), cS.max))

#finding max interval
cS = None
for i in range(n):
	tempS = sensors[i]
	if cS is None:
		if(tempS.type == "none"):
			cS = tempS
		continue
	if(tempS.type == "none"):
		cS = union([cS, tempS])
	else:
		cS = combine(cS, tempS, "f")
	#print(cS)

fout.write("{} {}\n".format(ma(cS.min), cS.max))
fout.close()
