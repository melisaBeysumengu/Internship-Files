package Week1.Day1;

import java.util.Scanner;

public class NumberGuess {

    static int getInput(){
        System.out.println("----------------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value: ");
        return sc.nextInt();
    }

    static int createRandomVariable(){
        return 1 + (int)(100* Math.random());
    }


    public static void main(String[] args) {
        int number = createRandomVariable();
        int guessLimit = 5;
        int i;
        int input;

        for (i = 0; i < guessLimit; i++) {
            input = getInput();

            if (number == input) {
                System.out.println("You found the number");
                break;
            }
            else if (number > input && i != guessLimit - 1) 
                System.out.println("Number is greater than " + input);
            else if (number < input && i != guessLimit - 1) 
                System.out.println("Number is less than " + input);
        }

        if (i == guessLimit) {
            System.out.println("You reached the guess limit.\nThe number was " + number);
        }
    }
    
}
