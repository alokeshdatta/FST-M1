numbers_list = list(input ("Enter a list of numbers with commas in between:").split(","))
#length=len(numbers_list)
first_element = numbers_list[0]
last_element = numbers_list[-1]

if (first_element==last_element):
    print(True)
else:
    print(False)