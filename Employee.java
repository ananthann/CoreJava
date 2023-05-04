import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee{
    private Employee(){}
    public static Employee employee;
    public static Employee getEmployeeObject(){
        if(employee==null){
            employee=new Employee();
        }
        return  employee;
    }
    Scanner s=new Scanner(System.in);
    String name;
    Integer age;
    Integer expInYears;
    String address;
    List< Employee> EmployeeList=new ArrayList<>();
    public void addEmployee(){
        System.out.println("enter name");
        name=s.next();
        System.out.println("enter age");
        age=s.nextInt();
        System.out.println("Experience in years");
        expInYears=s.nextInt();
        System.out.println("enter address");
        address=s.next();
    }
    public void createUser(Company c, Employee a){
        a.addEmployee();
        System.out.println("Company details");
        System.out.println("Company name ="+c.name);
        System.out.println("Place ="+c.place);
        EmployeeList.add(a);
        System.out.println(a.name);
    }

    public static void main(String args[]) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Employee e1=new Employee();
        Company c1= new Company("xminds","tvm");
        Company c2=new Company("xminds","tvm");
        Company c3= new Company();


        Company c5=c3;
        System.out.println(c1==c2);
        System.out.println(c5);

        System.out.println(c3==c5);
        System.out.println(".....");
        Company c6=new Company(c3);
        System.out.println();

        Employee e3= Employee.getEmployeeObject();
        Employee e4=Employee.getEmployeeObject();
        System.out.println(e3==e4);
    }
}
