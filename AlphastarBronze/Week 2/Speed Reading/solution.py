import sys

#function takes in S_i, T_i, and R_i and outputs minutes needed to read the book
def cow_power(bks_per_min, time_before_burnout, rest):
    pages_read = 0
    min = 0
    while True:
        for i in range(time_before_burnout):
            pages_read += bks_per_min
            min += 1
            if(pages_read >= numPages):
                break
        if(pages_read >= numPages):
            print(min)
            break
        min += rest
