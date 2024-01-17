# -*- coding: utf-8 -*-
from functools import reduce

print(abs(100))

def my_abs(x):
    if x >= 0:
        return x
    else:
        return -x

print(my_abs(90))


def test(x,n=2):
    s=1
    while n>0:
        n=n-1
        s=s*x
    return s

print(test(2,3))


def f1(a, b, c=0, *args, **kw):
    print('a =', a, 'b =', b, 'c =', c, 'args =', args, 'kw =', kw)

def f2(a, b, c=0, *, d, **kw):
    print('a =', a, 'b =', b, 'c =', c, 'd =', d, 'kw =', kw)
# 必选参数、默认参数、可变参数、命名关键字参数和关键字参数。

#  *args是可变参数，args接收的是一个tuple；

# **kw是关键字参数，kw接收的是一个dict。
f1(1,2)

f2(1, 2, d=99, ext=None)


def fact(n):
    if n==1:
        return 1
    return n * fact(n - 1)

print(fact(10))


L = list(range(100))

#每隔5个数取一个
print(L[::5])

print(L[10:23])

print(L[:20:3])

d = {'a': 1, 'b': 2, 'c': 3}

for key in d:
    # print(key)
    print(d[key])

print("-------------------------")

for ch in 'ABC':
    print(ch)

# for i, value in enumerate(['A', 'B', 'C']):
#     print(i, value)
print("-------------------------")

for i,value in enumerate(['A','B','C']):
    print(i,value)

print("------------------------")


def add(x, y, f):
    return f(x) + f(y)

print(add(-5, 6, abs))

print("------------------------")

DIGITS = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}


def str2int(s):
    def fn(x,y):
        return x*10+y
    def char2num(num):
        return DIGITS[s]
    return reduce(fn,map(char2num,s))

print(str2int("9"))

name_list=['adam', 'LISA', 'barT']

def normalize(name):
    return name.lower().capitalize()

# 测试:
L1 = ['adam', 'LISA', 'barT']
L2 = list(map(normalize, L1))
print(L2)


print("---------------------------------")

def is_odd(n):
    return n % 2 == 1
print(list(filter(is_odd, [1, 2, 4, 5, 6, 9, 10, 15])))

print("---------------------------------")
L = list(filter(lambda n:n%2==1, range(1, 20)))
print(L)


print("---------------------------------------")
def more(x,y):
    nx=x+2
    ny=y+2
    return nx,ny

print(more(3,9))