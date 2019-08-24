import random

def main():
    # Leave this for getting your three numbers
    val1 = random.randint(1,11)
    val2 = random.randint(1,11)
    val3 = random.randint(1,11)
    print("Welcome to your slot machine!")
    print("Would you like to play?")
    yn = input("Enter yes/no: ").lower()
    yes = "yes"
    no = "no"
    tot_win = 0
    # from pdb import set_trace; set_trace()
    while yn != no:
        val1 = random.randint(1, 11)
        val2 = random.randint(1, 11)
        val3 = random.randint(1, 11)
        if yn == "yes":
            print("Generating your three numbers ...")
            print("You spun " + str(val1) + " " + str(val2) + " " + str(val3))
            if val1 == 7 and val2 == 7 and val3 == 7:
                win = int(750)
                print("Yay!")
                print("You received " + str(win) + " points!")
            elif val1 == 7 or val2 == 7 or val3 == 7:
                if val1 == val2 or val1 == val3 or val2 == val3:
                    win = int(100)
                    print("Yay!")
                    print("You received " + str(win) + " points!")
                elif val1 != val2 and val1 != val3 and val2 != val3:
                    win = int(-10)
                    print("Oh no!")
                    print("You received " + str(win) + " points!")
            elif val1 != 7 and val2 != 7 and val3 != 7:
                if val1 == val2 and val2 == val3:
                    win = int(250)
                    print("Yay!")
                    print("You received " + str(win) + " points!")
                elif val1 == val2 or val1 == val3 or val2 == val3:
                    win = int(50)
                    print("Yay!")
                    print("You received " + str(win) + " points!")
                elif val1 != val2 and val1 != val3 and val2 != val3:
                    win = int(-20)
                    print("Oh no!")
                    print("You received " + str(win) + " points!")
            win_now = win
            tot_win = tot_win + win_now
            if tot_win < 500 and tot_win > -1000:
                print("You now have " + str(tot_win) + " points!")
                yn = input("Must enter yes/no: ").lower()
            elif tot_win > 500:
                print("Know when to quit!")
            elif tot_win < -1000:
                print("You're in too much debt!")
                exit()
        elif yn != yes and yn != no:
            print("Input invalid.")
            yn = input("Must enter yes/no: ").lower()


    if yn == "no":
        print("Your total: " + str(tot_win))
        print("Goodbye")
        exit()



if __name__ == '__main__':
    main()