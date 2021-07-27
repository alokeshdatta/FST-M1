
player1 = input ("What is player1's name ?")
player2 = input ("What is player2's name ?")

while True:

    player1_answer = input(player1 + ", do you want to choose rock, paper or scissors? ").lower()
    player2_answer = input(player2 + ", do you want to choose rock, paper or scissors? ").lower()
    
    if player1_answer == player2_answer:
        print("It's a tie!")
    elif player1_answer == 'rock':
        if player2_answer == 'scissors':
            print(player1 + " wins!")
        elif player2_answer == 'paper':
            print(player2 + " wins")
        else: print("Invalid input! Player2 have not entered rock, paper or scissors, try again.")
        # rest code should be like above block
    elif player1_answer == 'scissors':
        if player2_answer == 'paper':
            print(player1 + " wins!")
        else:
            print(player2 + " wins!")
    elif player1_answer == 'paper':
        if player2_answer == 'rock':
            print(player1 + " wins!")
        else:
            print(player2+" wins!")
    else:
        print("Invalid input! Try again.")


    repeat = input("Do you want to play one more round? Yes/No: ").lower()
        
        
    if(repeat == "yes"):
            continue
        
    elif(repeat == "no"):
        print ("Thanks for playing")
        raise SystemExit
     
    else:
        print("You entered an invalid option. Exiting now.")
        raise SystemExit        