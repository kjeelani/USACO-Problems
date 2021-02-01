from sys import stdin

N, Q = map(int, stdin.readline().rstrip().split(' '))

prefix = [int(x) for x in stdin.readline().rstrip().split(' ')] + [0]
for i in range(1, N):
  prefix[i] += prefix[i-1]
for i in range(Q):
  x, y = map(int, stdin.readline().rstrip().split(' '))
  print(prefix[y-1]-prefix[x-2])