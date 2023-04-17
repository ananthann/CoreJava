import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class TelephoneDirectory {
    Long phoneNumber;
    Customer customer;
    public void setCustomer(Customer customer){
        this.customer=customer;
    }
    public  void setPhoneNumber(Long number){
        this.phoneNumber=number;
    }
    public Customer getCustomer(){
        return customer;
    }
    static HashMap<Long,Customer> telephoneDirectory=new HashMap<Long,Customer>();
    public void addNumberForCustomer(){
        PhoneNumberGenerator p=new PhoneNumberGenerator();
        Customer customer=new Customer();
        telephoneDirectory.put(p.phoneNumberGenerator(),customer.addCustomer());
        System.out.println(telephoneDirectory);
    }

    //search address using number
    public void getAddressByPhoneNumber(Long number){
        String district= telephoneDirectory.get(number).getAddress().getDistrict();
        Long pn=telephoneDirectory.get(number).getAddress().getPinCode();
        String pl=telephoneDirectory.get(number).getAddress().getPlace();
        System.out.println(district);
        System.out.println(pl);
        System.out.println(pn);
    }

    //display phone number and address using districts
    public void displayPhoneNumberAndAddress(String district){
        for(Map.Entry<Long, Customer> entry: telephoneDirectory.entrySet()) {
            if(entry.getValue().getAddress().getDistrict().equalsIgnoreCase(district))  {
                System.out.println("district"+entry.getValue().getAddress().getDistrict());
                System.out.println("place "+entry.getValue().getAddress().getPlace());
                System.out.println("Pin code "+entry.getValue().getAddress().getPinCode());
                System.out.println( entry.getKey());
            }
        }
    }

    //listing phone numbers from specific districts
    public  void getNumbersFromDistricts(String district){
        for(Map.Entry<Long, Customer> entry: telephoneDirectory.entrySet()) {
            if(entry.getValue().getAddress().getDistrict().equalsIgnoreCase(district))  {
                System.out.println(entry.getKey());
            }
        }
    }


    //display list of number and address from a district
    public void getNumberAndAddress(String district){
        System.out.println(district);
        for(Map.Entry<Long, Customer> entry: telephoneDirectory.entrySet()) {
            if(entry.getValue().getAddress().getDistrict().equalsIgnoreCase(district))  {
                System.out.println(entry.getKey());
            }
        }
    }

    //display keys in ascending order
    // Creating a TreeSet from the keySet of the HashMap to sort the keys
    public void keysInAscending() {
        TreeSet<Long> sortedKeys = new TreeSet<>(telephoneDirectory.keySet());
        // Printing the keys in ascending order
        for (Long key : sortedKeys) {
            System.out.println(key);
        }
    }
}
