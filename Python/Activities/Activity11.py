	
fruit_shop = {
    "apple": 10,
    "banana": 15,
    "orange": 8,
    "peaches": 15
}
 
fruit = input("Which fruit do you want? ").lower()
 
if(fruit in fruit_shop):
    print("Yes, this is available")
else:
    print("No, this is not available")