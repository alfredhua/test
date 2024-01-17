# -*- coding: utf-8 -*-

age = 20
if age >= 18:
    print('your age is', age)
    print('adult')
print('-------------------------')

age = 3
if age >= 18:
    print('your age is', age)
    print('adult')
else:
    print('your age is', age)
    print('teenager')

print('-------------------------')
age = 3
if age >= 18:
    print('adult')
elif age >= 6:
    print('teenager')
else:
    print('kid')

print('------------------')

birth = input('birth: ')
if int(birth) < 2000:
    print('00前')
else:
    print('00后')