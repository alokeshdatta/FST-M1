numbers_list = tuple(input ("Enter a list of numbers with commas in between:").split(","))
print (type(numbers_list))
for number in numbers_list:
    if (int(number) % 5 == 0):
        print(number)
