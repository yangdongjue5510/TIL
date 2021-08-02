user_input = input('Input: ')
datafile = open('testfile.txt', 'a')
datafile.write(user_input+'\n')
datafile.close()