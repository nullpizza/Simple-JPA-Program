package entity;

import javax.persistence.*;
import java.util.Scanner;

public class MyJPA {
    public static int choice = -1;
    private static final JpaClass jpa = new JpaClass();
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public static void main(String[] args) {
        var obj = new MyJPA();
        while (choice != 0) {
            obj.databaseMenu();
            switch (choice) {
                case 1 -> obj.createContact();
                case 2 -> obj.readContact();
                case 3 -> obj.searchById();
                case 4 -> obj.deleteContact();
                case 5 -> obj.updateFirstName();
                case 6 -> obj.updateLastName();
                case 7 -> obj.updateAddress();
                case 8 -> obj.updateContactInfo();
            }
        }
    }


    private void createContact() {
        jpa.create(new Contact());
    }

    private void readContact() {
        System.out.println("Sorted by comparator: \n");
        jpa.read();
    }

    private void searchById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Contact id: ");
        int id = sc.nextInt();
        sc.nextLine();
        jpa.search(id); // takes the user input as an argument
    }

    // Update first name
    private void updateFirstName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter contact ID: ");
        int contactId = sc.nextInt();
        sc.nextLine();
        jpa.updateFName(contactId);
    }

    // Update last name
    private void updateLastName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Contact ID: ");
        int contactId = sc.nextInt();
        sc.nextLine();
        jpa.updateLName(contactId);
    }

    // Update address
    private void updateAddress() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Contact ID: ");
        int contactId = sc.nextInt();
        sc.nextLine();
        jpa.updateAddress(contactId);
    }

    // Update contact information
    private void updateContactInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Contact ID: ");
        int contactId = sc.nextInt();
        sc.nextLine();
        jpa.updateContacInformation(contactId);
    }

    private void deleteContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID of the contact you want to delete: ");
        int id = sc.nextInt();
        sc.nextLine();
        jpa.deleteContact(id);
    }

    private void databaseMenu() {
        MyException exception = new MyException();
        System.out.println(
                """
                        +----------------------------+\s
                        |    [Contact Management]    |\s
                        +----------------------------+\s
                        | [1]. Create                |\s
                        + [2]. Read                  +\s
                        | [3]. Search                |\s
                        + [4]. Delete                +\s
                        | [5]. Update first name     |\s
                        | [6]. Update last name      |\s
                        | [7].Update address         |\s
                        | [8].Update contact info    |\s
                        +----------------------------+\s
                        """);
        exception.integerException("\nEnter: ");
    }
}


