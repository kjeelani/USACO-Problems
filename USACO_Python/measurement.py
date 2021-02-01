fin = open("measurement.in", "r")
fout = open("measurement.out", "w")

'''
1.)Read data
2.)Sort entries by time
3.)In a for loop
	a.)Change the event based on occurance. If there is a change in the previous leaderboard, increase lb_change by 1
4.)Output lb_change
'''

nlogs = int(fin.readline())
lb_change, lb = 0, []
logs = [fin.readline().rstrip().split(' ') for i in range(nlogs)]
for log in logs:
	for i in range(3):
		if(i != 1):
			log[i] = int(log[i])
logs.sort()
cow_dict = {"Mildred":7, "Elsie":7, "Bessie":7}

def get_keys(val):
	lst = []
	for key, value in cow_dict.items(): 
			if val == value:
				lst.append(key) 
	return lst

def find_temp_lb():
	tlb = get_keys(max(cow_dict.values()))
	return tlb

for i in range(nlogs):
	cow_dict[logs[i][1]] += logs[i][2]
	temp_lb = find_temp_lb()
	temp_lb.sort()
	if(temp_lb != lb):
		lb = temp_lb
		lb_change += 1

fout.write(str(lb_change) + "\n")
fout.close()
