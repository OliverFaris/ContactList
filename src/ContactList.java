// Contact list by Oliver Faris
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    // Instance variable
    private ArrayList<Person> contacts;

    // Constructor
    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    // Methods
    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(Scanner scanner) {
        System.out.println("Select a type of contact to add:\n1. Student\n2. Athlete");
        int input = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please fill in the following information.\nFirst Name: ");
        String name = scanner.nextLine();
        System.out.println("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        if (input == 1) {
            System.out.println("Grade: ");
            int grade = scanner.nextInt();
            scanner.nextLine();
            Person student = new Student(name, lastName, phoneNumber, grade);
            contacts.add(student);
        }
        else if (input == 2) {
            System.out.println("Sport: ");
            String sport = scanner.nextLine();
            System.out.println("Wins: ");
            int numWins = scanner.nextInt();
            scanner.nextLine();
            Person athlete = new Athlete(name, lastName, phoneNumber, sport, numWins);
            contacts.add(athlete);
        }
        else {
            System.out.println("Invalid.");
        }
    }

    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p);
        }
    }

    public void sort(int sortBy) {
        String firstPerson;
        String secondPerson;
        for (int i = 0; i < contacts.size() -1; i++) {
            for (int j = 0; j < contacts.size() -i -1; j++) {
                if(sortBy ==0) {
                    firstPerson = contacts.get(j).getFirstName();
                    secondPerson = contacts.get(j+1).getFirstName();
                }
                else if(sortBy ==1) {
                    firstPerson = contacts.get(j).getLastName();
                    secondPerson = contacts.get(j+1).getLastName();
                }
                else {
                    firstPerson = contacts.get(j).getPhoneNumber();
                    secondPerson = contacts.get(j+1).getPhoneNumber();
                }
                if (firstPerson.compareTo(secondPerson) > 0 ) {
                    contacts.add(j+1, contacts.remove(j));
                }
            }
        }
    }

    public Person searchByFirstName(String firstName) {
        for (Person person : contacts) {
            if (person.getFirstName().equals(firstName)) {
                System.out.println(person);
                return person;
            }
        }
        System.out.println(firstName + " is not in the list.");
        return null;
    }

    public Person searchByLastName(String lastName) {
        for (Person person : contacts) {
            if (person.getLastName().equals(lastName)) {
                System.out.println(person);
                return person;
            }
        }
        System.out.println(lastName + " is not in the list.");
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person person : contacts) {
            if (person.getPhoneNumber().equals(phoneNumber)) {
                System.out.println(person);
                return person;
            }
        }
        System.out.println(phoneNumber + " is not in the list.");
        return null;
    }

    public void listStudents() {
        for (Person person : contacts) {
            if(person instanceof Student) {
                System.out.println(person);
            }
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int input;
        System.out.println("Welcome to your Contacts List\nPlease pick from the following menu options");
        do {
            System.out.println("\nMenu:\n1. Add contact\n2. List all contacts by first name\n3. List all contacts by" +
                    " last name\n4. List all contacts by phone number\n5. List all students\n6. Search by first name" +
                    "\n7. Search by last name\n8. Search by phone number\n0. Exit");
            input = scanner.nextInt();
            scanner.nextLine();

            switch(input) {
                case 0:
                    break;
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    sort(0);
                    printContacts();
                    break;
                case 3:
                    sort(1);
                    printContacts();
                    break;
                case 4:
                    sort(2);
                    printContacts();
                    break;
                case 5:
                    listStudents();
                    break;
                case 6:
                    System.out.println("Enter a name: ");
                    searchByFirstName(scanner.nextLine());
                    break;
                case 7:
                    System.out.println("Enter a last name: ");
                    searchByLastName(scanner.nextLine());
                    break;
                case 8:
                    System.out.println("Enter a phone number: ");
                    searchByPhoneNumber(scanner.nextLine());
                    break;
            }
        } while(input != 0);
    }

    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        contactList.run();
    }
}
