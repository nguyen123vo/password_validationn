import java.util.Scanner;
import java.util.Random;
public class randomNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random ran = new Random();
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a random number between 1 and 100.");
        System.out.println("Try to guess what it is!");
        boolean check= false;
        int numberRandom = ran.nextInt(100) + 1;
        int leftBound = 0;
        int rightBound = 100;
        int i = 0;
        while (!check) {
            System.out.println("Enter your guess:");
            int number =  input.nextInt();
            if (number > numberRandom) {
                rightBound = number;
                System.out.println("Your number is higher than the number I picked. It ranges between " + leftBound + " and " + rightBound + ".");
                i++;
            } else if (number < numberRandom) {
                leftBound = number;
                System.out.println("Your number is lower than the number I picked. It ranges between " + leftBound + " and " + rightBound + ".");
                i++;
            } else {
                System.out.println("Correct! You guessed the number" + number + " in " + (i + 1) + " tries.");
                check = true;
            }
        }

    }
}
// CHƯA KỊP SET YES/NO //