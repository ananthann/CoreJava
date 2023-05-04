import java.util.Scanner;

public class Staff implements Method{
    public static Scanner s;
    public static Scanner createScannerObject(){
        if (s==null)
        s=new Scanner(System.in);
        return s;
    }
    String staffName;
    Integer staffId;
    Integer staffAge;
    @Override
    public void print() {
        System.out.println(staffId);
        System.out.println(staffName);
        System.out.println(staffAge);
    }
    @Override
    public void read(){
        createScannerObject();
        System.out.println("enter staff name");
        staffName=s.next();
        System.out.println("enter staff Id");
        staffId=s.nextInt();
        System.out.println("enter staff age");
        staffAge=s.nextInt();
    }
}
