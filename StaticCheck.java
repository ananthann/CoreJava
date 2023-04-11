public class StaticCheck {
  int a;
    static int b=2;
    public static void main(String args[]){
        StaticCheck s1=new StaticCheck();
        StaticCheck s2=new StaticCheck();
        StaticCheck s3=new StaticCheck();
        s1.a=3;
       System.out.println(s1.a);
        System.out.println(s1.b);
        s2.b=9;
        System.out.println(s2.b);
        System.out.println(s3.b);
        System.out.println(StaticCheck.a);
    }
}
