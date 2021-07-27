
list1 = [112,5,6,8,218,651]
numbers_list = list(input ("Enter a list of numbers with commas in between:").split(","))
length=len(numbers_list)
print (length)
print (numbers_list)

sum=0
for i in range (0,length):
    sum = sum + int(numbers_list[i])

# for number in numbers:
#   sum += int(number)

print (sum)
