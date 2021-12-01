package entity;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

import static entity.MyJPA.choice;

public class MyException {

    /**
     * @param s takes a String as an argument and this
     *          input InputMismatchException takes a String and while that is true it will loop
     *          until the user enters a variable type of int
     *          <p>
     *
     *          </p>
     * @return if the user enter a variable type of int the while loop will stop looping and it will return
     * what the user have entered!
     *
     * <p>
     *
     * </p>
     *                this method is use for the main menu and it makes sure that the program
     *              doesn't crash and it will keep running even tho if the user enters a String
     *
     */


    public int integerException(String s) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(s);
            try {
                choice = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nOnly Numbers \n" + e);
            } finally {
                sc.nextLine();
            }
        }
        return choice;
    }
}


