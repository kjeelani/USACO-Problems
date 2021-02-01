fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")

while low <= high: 
    mid = (high + low) // 2
    if arr[mid] < x: 
        low = mid + 1
    elif arr[mid] > x: 
        high = mid - 1
    else: 
        return mid 

def upperbound(x):
    left, right = 0, n
    while left < right:
        mid = (right + left) // 2
        if(x >= arr[mid]):
            left = mid + 1
        else:
            right = mid
    return left

def lowerbound(x):
    left, right = 0, n
    while left < right:
        mid = (right + left) // 2
        if(x <= citylist[mid]):
            right = mid
        else:
            left = mid + 1
    return left

'''
Interval problems: If I have n intervals with 2n "critical points"(start, stop)
which are marked respectively 1 and -1, sort the endpoints based on their positions

Each endpoint is a tuple: (position, label(-1 or 1)) and is sorted by it's position

Search through the ranges and keep indicators on the # of overlaps there are
'''

comb_list = []

def find_combinations(arr):
    if(len(arr) == N):
        comb_list.append(arr)
        return
    find_combinations(arr + [1])
    find_combinations(arr + [0])

find_combinations([])
