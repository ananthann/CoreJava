import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Student implements Method{
    String name;
    String address;
    Integer rollNo;
    Integer age;
    @Override
    public void print() {
        System.out.println(name);
        System.out.println(age);
        System.out.println(rollNo);
        System.out.println(address);
    }
    @Override
    public void read(){
        Scanner s=Staff.createScannerObject();
        System.out.println("enter Student name");
        name=s.next();
        System.out.println("enter Student address");
        address=s.next();
        System.out.println("enter Student Id");
        rollNo=s.nextInt();
        System.out.println("enter Student age");
        age=s.nextInt();
    }
    public static void main(String args[]) throws IOException {
        FileReader fileReader=new FileReader("/home/xminds/Documents/Fix/src/" +
                "resources/application.properties");
        Properties p=new Properties();
        p.load(fileReader);
        String content=p.getProperty("value");
        System.out.println(content);
        if (content.equals("Student")){
            Student s2=new Student();
            s2.read();
            s2.print();
        }
        if (content.equals("Department")){
            Department d2=new Department();
            d2.print();
        }
        if (content.equals("Staff")){
            Staff staff2=new Staff();
            staff2.print();
        }
    }
}
