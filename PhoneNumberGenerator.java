import java.util.Random;
import java.util.Scanner;

public class PhoneNumberGenerator {
    Scanner s=new Scanner(System.in);

    public Long phoneNumberGenerator(){
            Random random = new Random();
            long randomNumber = (long) (random.nextDouble() * 10000000000L);
        return randomNumber;
    }
    public void mainMethod(){
       Customer c1=new Customer();
       c1.addCustomer();
//       Customer c2=new Customer();
//       c2.addCustomer();
//       Customer c3=new Customer();
//       c3.addCustomer();
       TelephoneDirectory td=new TelephoneDirectory();
       System.out.println("enter the district to show the numbers in that districts");
       String dis=s.next();
       td.getNumbersFromDistricts(dis);
    }
    public static void main (String args[]){
        PhoneNumberGenerator ph=new PhoneNumberGenerator();
        ph.mainMethod();
    }
}
