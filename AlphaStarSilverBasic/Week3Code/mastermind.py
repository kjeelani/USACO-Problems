'''
1.)From numbers 1000-9999
    a.)Check if it fits all 100 guess criteria
2.)You need to first check if there are any correct locations.(mark in used array)
Then the leftover ones will be considered for wrong location, correct number
'''
fin, fout = open("textfiles/test.in", "r"), open("textfiles/test.out", "w")
n = int(fin.readline())
guesses = [[int(x) if len(x) != 4 else x for x in fin.readline().rstrip().split()] for i in range(n)]
print(guesses)
def fits_criteria(n, guess):
    actN = str(n)
    actNvisited, guessNvisited = [False for i in range(4)], [False for i in range(4)]
    param1, param2 = 0,0
    #for if num is in correct location
    for i in range(4):
        if(actN[i] == guess[0][i]):
            actNvisited[i] = True
            guessNvisited[i] = True
            param1 += 1
    #for if num is correct but in wrong location
    for i in range(4):
        for j in range(4):
            if(actN[i] == guess[0][j] and not (actNvisited[i] or guessNvisited[j])):
                actNvisited[i] = True
                guessNvisited[j] = True
                param2 += 1
    if(guess[1] == param1 and guess[2] == param2):
        return True
    else:
        return False


for i in range(10**3, 10**5):
    for g in guesses:
        if(not fits_criteria(i, g)):
            break
    else:
        fout.write(str(i) + "\n")
        fout.close()
        break
else:
    fout.write("NONE")
    fout.close()