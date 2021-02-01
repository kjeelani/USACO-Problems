"""
ID: kaif.aj1
LANG: PYTHON3
PROG: friday
"""
fin = open("friday.in", "r")
fout = open("friday.out", "w")
years = int(fin.readline().rstrip())
day_counter = 13
month_counter = 1
start_year = 1900
current_year = 1900
day_list = [0,0,0,0,0,1,0]
thirty_one_list = [1,3,5,7,8,10,0]
thirty_list = [4,6,9,11]
while True:
	if(month_counter % 12 == 0):
		current_year += 1
	if(current_year >= start_year + years):
		break
	if(month_counter % 12 in thirty_one_list):
		day_counter += 31
	elif(month_counter % 12 in thirty_list):
		day_counter += 30
	else:
		if(current_year % 4 == 0 and (current_year % 100 != 0 or current_year % 400 == 0)):
			day_counter += 29
		else:
			day_counter += 28
	day_list[day_counter % 7 - 1] += 1
	month_counter += 1

fout.write(str(day_list[5]) + " " + str(day_list[6]) + " " + str(day_list[0]) + " " + str(day_list[1]) + " " + str(day_list[2]) + " " + str(day_list[3]) + " " + str(day_list[4]) + "\n")
fout.close()
