import java.util.Scanner;

class Contact {
    String name;
    String mobileNumber;
    String designation;

    Contact(String name, String mobileNumber, String designation) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.designation = designation;
    }

    public void display() {
        System.out.println("Name: " + name + ", Mobile No: " + mobileNumber + ", Designation: " + designation);
    }
}

class PhoneBook {
    Contact[] contacts;
    int count;

    PhoneBook(int size) {
        contacts = new Contact[size];
        count = 0;
    }

    public void addContact(String name, String mobileNumber, String designation) {
        if (count < contacts.length) {
            contacts[count] = new Contact(name, mobileNumber, designation);
            count++;
            System.out.println("Contact added successfully!");
        } else {
            System.out.println("Phone book is full!");
        }
    }

    public void deleteContact(String name) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (contacts[i].name.equals(name)) {
                found = true;
                for (int j = i; j < count - 1; j++) {
                    contacts[j] = contacts[j + 1];
                }
                contacts[count - 1] = null;
                count--;
                System.out.println("Contact deleted successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found!");
        }
    }

    public void printContactByName(String name) {
        for (int i = 0; i < count; i++) {
            if (contacts[i].name.equals(name)) {
                contacts[i].display();
                return;
            }
        }
        System.out.println("Contact not found!");
    }

    public void printContactByDesignation(String designation) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (contacts[i].designation.equals(designation)) {
                contacts[i].display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contact found with that designation!");
        }
    }

    public void printAllContacts() {
        if (count == 0) {
            System.out.println("No contacts in the phone book!");
        } else {
            for (int i = 0; i < count; i++) {
                contacts[i].display();
            }
        }
    }
}

public class PhoneBookManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the phone book:");
        int size = sc.nextInt();
        sc.nextLine();  // Consume newline

        PhoneBook phoneBook = new PhoneBook(size);

        int choice;
        do {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Print Contact by Name");
            System.out.println("4. Print Contact by Designation");
            System.out.println("5. Print All Contacts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Mobile Number: ");
                    String mobileNumber = sc.nextLine();
                    System.out.print("Enter Designation: ");
                    String designation = sc.nextLine();
                    phoneBook.addContact(name, mobileNumber, designation);
                    break;
                case 2:
                    System.out.print("Enter Name of contact to delete: ");
                    String deleteName = sc.nextLine();
                    phoneBook.deleteContact(deleteName);
                    break;
                case 3:
                    System.out.print("Enter Name: ");
                    String searchName = sc.nextLine();
                    phoneBook.printContactByName(searchName);
                    break;
                case 4:
                    System.out.print("Enter Designation: ");
                    String searchDesignation = sc.nextLine();
                    phoneBook.printContactByDesignation(searchDesignation);
                    break;
                case 5:
                    phoneBook.printAllContacts();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
        sc.close();
    }
}
