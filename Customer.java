import java.util.Scanner;

public class Customer {
    String name;
    Integer age;
    Address address;
    public void setAddress(Address address){
        this.address=address;
    }
    public void setName(String name){
        this.name=name;
    }
    public Address getAddress(){
        return address;
    }

    public void setAge(Integer age){
        this.age=age;
    }
    public Customer addCustomer(){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter name");
        name=s.next();
        System.out.println("Enter age");
        age=s.nextInt();

        Address ad=new Address();
        System.out.println("enter district");
        ad.district=s.next();
        System.out.println("enter place");
        ad.place=s.next();
        System.out.println("enter pin code");
        ad.pinCode=s.nextLong();
        ad.setDistrict(ad.district);
        ad.setPlace(ad.place);
        ad.setPinCode(ad.pinCode);

        Customer c=new Customer();
        c.setName(name);
        c.setAge(age);
        c.setAddress(ad);
        return c;
    }
}
