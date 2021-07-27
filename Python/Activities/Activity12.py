
number= int (input("Tell me how many : "))
def recursiveSum(n):
  if n:
    return n + recursiveSum(n-1)
  else:
    return 0

print(recursiveSum(number))