first_list = [67, 20, 919, 2, 33, 78]
second_list = [84, 92, 91, 67, 4, 1002]
#print("First List ", listOne)
#print("Second List ", listTwo)
 
thirdList = []
for number in first_list:
    if (number % 2 != 0):
        thirdList.append(number)
        
for item in second_list:
    if (item % 2 == 0):
        thirdList.append(item) 	
print("third List is:"+ str(thirdList))
