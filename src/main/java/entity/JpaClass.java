package entity;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static entity.MyJPA.emf;

public class JpaClass {

    public void create(Contact c) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Scanner sc = new Scanner(System.in);
        System.out.print("First Name: ");
        String fName = sc.nextLine();
        System.out.print("\nLast Name: ");
        String lName = sc.nextLine();
        System.out.print("\nAddress: ");
        String address = sc.nextLine();
        System.out.print("\nContact");
        String contact = sc.nextLine();
        c.setfName(fName);
        c.setlName(lName);
        c.setAddress(address);
        c.setContact(contact);
        em.persist(new Contact(fName, lName, address, contact));
        em.getTransaction().commit();
    }

    /**
     * this method reads the
     */
    public void read() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Contact> contactTypedQuery = em.createQuery("Select c from Contact c", Contact.class);
        List<Contact> contactList = contactTypedQuery.getResultList();
        contactList.sort(Comparator.comparing(Contact::getfName));
        System.out.println(contactList);
    }

    /**
     * @param contactId takes the id that we entered and put that inside the parameter parameters
     */
    public void updateFName(int contactId) {
        EntityManager em = emf.createEntityManager();
        Contact contact = em.find(Contact.class, contactId);
        Scanner sc = new Scanner(System.in);
        em.getTransaction().begin();
        System.out.print("New First Name: ");
        String fNameUpdate = sc.nextLine();
        contact.setfName(fNameUpdate);
        em.getTransaction().commit();
        System.out.println("new first name: "+contact.getfName());

    }


    public void updateLName(int contactId) {
        EntityManager em = emf.createEntityManager();
        Contact contact = em.find(Contact.class, contactId);
        Scanner sc = new Scanner(System.in);
        em.getTransaction().begin();
        System.out.print("New last name: ");
        String lNameUpdate = sc.nextLine();
        contact.setlName(lNameUpdate);
        em.getTransaction().commit();
        System.out.println("new last name: "+contact.getlName());

    }

    public void updateAddress(int contactId) {
        Scanner sc = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();
        Contact contact = em.find(Contact.class, contactId);
        System.out.print("Enter new address: ");
        String newAddress = sc.nextLine();
        contact.setAddress(newAddress);
        System.out.println("new address: "+contact.getAddress());
    }

    /**
     * @param contactId takes the id that we entered and put that inside the parameter parameters
     */
    public void updateContacInformation(int contactId) {
        EntityManager em = emf.createEntityManager();
        Contact contact = em.find(Contact.class, contactId);
        Scanner sc = new Scanner(System.in);
        em.getTransaction().begin();
        System.out.print("New Contact Information:  : ");
        String newContactInfo = sc.nextLine();
        contact.setContact(newContactInfo);
        em.getTransaction().commit();
        System.out.println("new contact information: "+contact.getContact());

    }


    public void deleteContact(int id) {
        EntityManager em = emf.createEntityManager();
        Contact contact = em.find(Contact.class, id);
        contact.setId(id);
        em.getTransaction().begin();
        em.remove(contact);
        System.out.println(contact+" have been deleted");
        em.getTransaction().commit();
    }


    /**
     * @param id takes a variable type of int and it is called id.
     *           it is the same value that we entered the MyJPA.java class
     *           this method Creates a typed query and selects from our contact database where the id
     *           is equal to the id we entered in our scanner where we call this method
     *           <p></p>
     *           <p>This method first creates a entity manager then a typed query where it
     *           selects the contact that have a matching ID with the id that we took in the parameters
     *           then it is a try catch method: first it check is it is true otherwise if stated false it will
     *           print out that no contact could be found with that id</p> also this method will be a very good
     *           help if the user want to update or delete a contact from the database. because
     *           the methods for deleting a contact from the database is by the ID
     */
    public void search(int id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Contact> contactQuery = em.createQuery(" SELECT c from Contact c where c.id=:id", Contact.class);
        contactQuery.setParameter("id", id);
        try {
            Contact contact = contactQuery.getSingleResult();
            contact.getId();
            System.out.println(contact);
        } catch (NoResultException notFoundException) { // if false catch an NoResultException!
            System.out.println("No Contact could be found with that id, please read all employees\n and check the ID:s");
            System.out.println("Exception: " + notFoundException);
        }
        em.close();
    }
}
