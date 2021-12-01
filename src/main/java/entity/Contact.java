package entity;

import javax.persistence.*;


@Entity
@Table(name = "contactdb", schema = "contact")

public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String fName;
    private String lName;
    private String contact;
    private String address;

    public Contact() {
    }

    public Contact(String fName, String lName, String address, String contact) {
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.contact = contact;
    }

    // setter
    public void setId(int id) {
        this.id = id;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    // getter
    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "\nContact" +
                "id=" + id +
                ", first Name= " + fName +
                ", last Name= " + lName +
                ", contact= " + contact +
                ", address= " + address +
                "}\n";
    }
}
