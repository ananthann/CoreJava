import java.util.Scanner;

public class Department implements Method {
    String deptName;
    Integer deptCode;

    @Override
    public void print() {

        System.out.println(deptCode);
        System.out.println(deptName);
    }
    @Override
    public void read(){
        Scanner s=Staff.createScannerObject();
        System.out.println("enter staff name");
        deptName=s.next();
        System.out.println("enter staff Id");
        deptCode=s.nextInt();
    }
}
