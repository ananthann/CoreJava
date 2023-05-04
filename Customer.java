import java.util.*;

public class Customer {
    Scanner sc=new Scanner(System.in);
 String name;
Long phoneNumber;
List<Customer> customers=new ArrayList<>();
public Customer addCustomerDetails() {
    Customer c1=new Customer();
    System.out.println("Enter name");
    c1.name = sc.next();
    System.out.println("Enter phone number");
    c1.phoneNumber = sc.nextLong();
    if (Ticket.customersAndTicket.get(c1.phoneNumber)!=null)
    {
        System.out.println("Seats are already booked using this number,Try adding another number");
        System.out.println("Enter phone number");
        c1.phoneNumber = sc.nextLong();
    }
    else
    {
        customers.add(c1);
    }
    return c1;
}
}
