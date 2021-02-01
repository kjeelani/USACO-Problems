#take each line after the first line and put a function in it that doubles the string
import sys

def StringDouble(single_string):
    single_string = list(single_string)
    new_string = []
    for i in range(len(single_string)-1):
        for j in range(scale_factor):
            new_string.append(single_string[i])
    new_string = "".join(new_string)
    for k in range(scale_factor):
        print(new_string)

first_line = sys.stdin.readline().split(" ")
height = int(first_line[0])
scale_factor = int(first_line[2])
for i in range(height):
    StringDouble(sys.stdin.readline())
    
