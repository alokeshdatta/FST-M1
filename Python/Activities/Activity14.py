def fib(n):
    if (n <= 1):
        return n
    else:
        return fib(n-1) + fib(n-2)

fib_num= int(input("How many fibonacci numbers do you want ?"))

print("fibonacci sequence is as below:")
for i in range (fib_num):
    print(fib(i))