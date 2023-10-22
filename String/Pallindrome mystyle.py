def hh():
    while True:
        f = input('Enter The Word : ')
        s=f
        if f[::-1]==s:
            print('Output ---- Palindrome')
        else:
            print('Output ---- Not a Palindrome')
        print('\n')
        print('Do you want to check about more Words? "(y/n)"')
        a = input()
        if a == 'n' or a == 'N':
            print('--- Program Ends ---')
            break
hh()
