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
/*Completed randomNUmber.java
import java.util.Scanner;
import java.util.Random;
public class randomNumber {
    public static void checking() {
        Scanner input = new Scanner(System.in);
        Random ran = new Random();
        boolean check = false;
        int numberRandom = ran.nextInt(100) + 1;
        int leftBound = 1;
        int rightBound = 100;
        int i = 0;
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a random number between 1 and 100.");
        System.out.println("Try to guess what it is!");
        while (!check) {
            System.out.println("Enter your guess:");
            String in = input.nextLine();
            if (in.length() > 3 || in.length() == 0) {
                System.out.println("Your guess has to be an integer from 1 to 100!");
            } else {
                try {
                    Integer.parseInt(in);
                    int number = Integer.parseInt(in);
                    if (number > 100 || number < 1) {
                        System.out.println("your number has to be from 1 to 100");
                    } else if (number > numberRandom) {
                        if (rightBound > number) {
                            rightBound = number;
                        }
                        System.out.println("Your number is higher than the number I picked. It ranges between " + leftBound + " and " + rightBound + ".");
                        i++;
                    } else if (number < numberRandom) {
                        if (leftBound < number) {
                            leftBound = number;
                        }
                        System.out.println("Your number is lower than the number I picked. It ranges between " + leftBound + " and " + rightBound + ".");
                        i++;
                    } else {
                        System.out.println("Correct! You guessed the number" + number + " in " + (i + 1) + " tries.");
                        check = true;
                        System.out.println("Do you want to play again? (Yes/No)");
                        YesNo();

                    }
                } catch (NumberFormatException e) {
                    System.out.println("Your guess has to be an integer from 1 to 100!");
                }
            }
        }
    }
    public static void YesNo() {
        boolean checkYesNo = false;
        while (!checkYesNo) {
            Scanner yesNoInput = new Scanner(System.in);
            String yesNo = yesNoInput.nextLine();
            if (yesNo.equalsIgnoreCase("Yes")) {
                checking();
                checkYesNo = true;
            } else if (yesNo.equalsIgnoreCase("No")) {
                System.out.println("Thanks for playing!");
                checkYesNo = true;
            } else {
                System.out.println("Your answer has to be Yes or No");
                checkYesNo = false;
            }
        }
    }

    public static void main(String[] args) {
        checking();
    }
}
*/

