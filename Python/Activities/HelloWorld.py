print ("Hello World")

	
quantity = 3
itemno = 567
price = 49.95
myorder = "I want to pay {2} dollars for {0} pieces of item {1}."
print(myorder.format(quantity, itemno, price))

example_dict =	{
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
for x in example_dict:
  print(x)
  print(example_dict[x])

for x, y in example_dict.items():
  print(x, y)