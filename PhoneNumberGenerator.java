import java.util.Random;

public class PhoneNumberGenerator {

    public Long phoneNumberGenerator(){
            Random random = new Random();
            long randomNumber = (long) (random.nextDouble() * 10000000000L);
        return randomNumber;
    }
    public static void main (String args[]){
        PhoneNumberGenerator p=new PhoneNumberGenerator();
        p.phoneNumberGenerator();
    }
}
