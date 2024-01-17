
num = int(input("请输入一个数字"))

factorial =1

if num<0:
    print("-----")
elif num==0:
    print("0的是0")
else:
    for i in range(1,num):
        factorial=factorial*i

    print("-----------",factorial)