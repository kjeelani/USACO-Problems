"""
ID: kaif.aj1
LANG: PYTHON3
TASK: namenum
"""
d = open("dict.txt", "r")
fin = open("namenum.in", "r")
fout = open("namenum.out", "w")
serial_num = fin.readline().rstrip()
telephone_dict = {'2':'ABC', '3':'DEF', '4':'GHI', '5':'JKL', '6':'MNO', '7':'PRS', '8':'TUV', '9':'WXY'}
potential_names = []
gears = [0 for i in range(len(serial_num))]
name_dict = [d.readline().rstrip() for i in range(4617)]
name_dict = list(filter(lambda x: (len(x) == len(serial_num)),name_dict))


def gear_shift():
	if(gears.count(0) == 0 and gears.count(1) == 0):
		return True
	else:
		for i in range(1, len(gears)+1):
			if(gears[-i] != 2):
				gears[-i] += 1
				break
			else:
				#gears[-i-1] += 1
				gears[-i] = 0
		return False

for i in range(len(serial_num)):
	tele_string = telephone_dict[serial_num[i]]
	name_dict = list(filter(lambda x: (x[i] == tele_string[0] or x[i] == tele_string[1] or x[i] == tele_string[2]),name_dict))
	if(len(name_dict) == 0):
		break


if(len(name_dict) == 0):
	fout.write("NONE" + "\n")
else:
	for i in name_dict:
		fout.write(i + '\n')
fout.close()

