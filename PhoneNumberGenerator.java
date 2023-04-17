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
       TelephoneDirectory td=new TelephoneDirectory();
        TelephoneDirectory td1=new TelephoneDirectory();
        TelephoneDirectory td2=new TelephoneDirectory();
        td.addNumberForCustomer();
       td1.addNumberForCustomer();
        td2.addNumberForCustomer();
        System.out.println("td"+td);

       System.out.println("1. enter the district to show the numbers in that districts");
       System.out.println("2. get Address By PhoneNumber");
        System.out.println("3. display PhoneNumber And Address of specific district");
        System.out.println("4. Phone numbers In Ascending");
        System.out.println(" enter the number in the options to work");
       Integer a=s.nextInt();
       if (a.equals(1))
       {
           System.out.println("enter the district name");
           String dis=s.next();
           td2.getNumbersFromDistricts(dis);
       }
       if (a.equals(3))
       {
           System.out.println("enter the district name");
           String dis=s.next();
           td2.displayPhoneNumberAndAddress(dis);
       }
       if (a.equals(4))
       {
           td2.keysInAscending();
       }
    }
    public static void main (String args[]){
        PhoneNumberGenerator ph=new PhoneNumberGenerator();
        ph.mainMethod();
    }
}
