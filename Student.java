import java.util.Scanner;

public class Student {
    double maths;
    double physics;
    double chemistry;
    double malayalam;
    double biology;
    static Integer TotalOutOf=500;
    public Student(double a,double b){
        Double sum=a+b;
        System.out.println("sum ="+sum);
    }
    public Student() {
    }
    public static void newMethod(){
        Student i=new Student();
        i.maths=1;
        TotalOutOf=10;
    }
    public Double addStudent( double maths,
                              double physics,
                              double chemistry,
                              double malayalam,
                              double biology){
        double sum=  (maths+physics+chemistry+malayalam+biology);
        return sum;
    }
    public static void main(String args[]){
        Student s1=new Student();
        Scanner s=new Scanner(System.in);
        System.out.println("enter the mark of biology");
        s1.biology= s.nextDouble();
        System.out.println("enter the mark of biology");
        s1.malayalam= s.nextDouble();
        System.out.println("enter the mark of biology");
        s1.maths= s.nextDouble();
        System.out.println("enter the mark of biology");
        s1.chemistry= s.nextDouble();
        System.out.println("enter the mark of biology");
        s1.physics= s.nextDouble();
        System.out.println("Marks = "+s1.addStudent(s1.maths,s1.physics,s1.chemistry,s1.malayalam,
                s1.biology)+"/"+TotalOutOf);
        Student s2=new Student(2,4);
        newMethod();
    }
}
