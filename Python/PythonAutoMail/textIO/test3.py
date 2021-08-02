user_input = input('Input: ')
datafile = open('testfile.txt', 'w')
datafile.write(user_input+'\n')
datafile.close()